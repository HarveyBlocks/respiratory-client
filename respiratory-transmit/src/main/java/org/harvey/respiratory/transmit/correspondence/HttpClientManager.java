package org.harvey.respiratory.transmit.correspondence;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.harvey.respiratory.transmit.properties.NetProperties;
import org.harvey.respiratory.transmit.vo.ErrorResponse;
import org.harvey.respiratory.transmit.vo.SuccessfulHttpResponse;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 不要多开, 多开损耗资源
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 02:22
 */
@Slf4j
public class HttpClientManager {
    public static final String HOST = NetProperties.DEFAULT.get(NetProperties.PropertyName.HOST);
    public static final int PORT = Integer.parseInt(NetProperties.DEFAULT.get(NetProperties.PropertyName.PORT));
    public static final LogLevel LOG_LEVEL = LogLevel.INFO;
    private final HttpClientExecutor executor = new DefaultHttpClientExecutor(this);
    private final NioEventLoopGroup group = new NioEventLoopGroup();
    private final Bootstrap bootstrap;

    // 搞一个任务队列
    //  request-chanel-executor(内涵promise)
    private final ConcurrentLinkedQueue<CorrespondenceTask> queue = new ConcurrentLinkedQueue<>();

    public HttpClientManager() {
        Runtime.getRuntime().addShutdownHook(new Thread(this::close));
        bootstrap = initBootstrap();
    }

    private Bootstrap initBootstrap() {
        final Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.group(group);
        ChannelInitializer<SocketChannel> handlerInitializer = getHandlerInitializer();
        bootstrap.handler(handlerInitializer);
        return bootstrap;
    }

    private void close() {
        group.shutdownGracefully();
    }

    private ChannelInitializer<SocketChannel> getHandlerInitializer() {
        LoggingHandler loggingHandler = new LoggingHandler(LOG_LEVEL);
        HttpClientCodec messageCodec = new HttpClientCodec();
        ChannelInboundHandlerAdapter activeAdapter = new ChannelInboundHandlerAdapter() {
            @Override
            public void channelActive(ChannelHandlerContext ctx) {
                offerTask(ctx.channel());
                ctx.fireChannelActive();
            }
        };

        SimpleChannelInboundHandler<HttpResponse> responseHandler = new SimpleChannelInboundHandler<>() {

            @Override
            public void channelRead0(ChannelHandlerContext ctx, HttpResponse response) {
                // 即时删除Map中无用的promise
                // promise set 之后, 就会唤醒await()
                CorrespondenceTask task = peekTask();
                Iterable<Map.Entry<String, String>> headers = response.headers();
                HttpResponseStatus status = response.status();
                int code = status.code();
                if (200 <= code && code < 300) {
                    log.info("response status = {}", status);
                } else {
                    log.error("response status = {}", status);
                    task.setErrorResponse(new ErrorResponse(code, status.reasonPhrase(), headers));
                }
                task.setHeaders(headers);
                ctx.fireChannelRead(response);
            }

        };
        SimpleChannelInboundHandler<DefaultHttpContent> contentHandler = new SimpleChannelInboundHandler<>() {
            @Override
            protected void channelRead0(
                    ChannelHandlerContext ctx, DefaultHttpContent content) {
                String string = content.content().toString(Charset.defaultCharset());
                peekTask().setContent(string);
            }
        };
        return new ChannelInitializer<>() {
            @Override
            protected void initChannel(SocketChannel ch) {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast(loggingHandler);
                pipeline.addLast(messageCodec);
                pipeline.addLast(activeAdapter);
                pipeline.addLast(responseHandler);
                pipeline.addLast(contentHandler);
            }
        };
    }

    private void offerTask(Channel channel) {
        queue.offer(new CorrespondenceTask(channel));
    }

    CorrespondenceTask peekTask() {
        CorrespondenceTask task = queue.peek();
        if (task == null) {
            throw new RuntimeException("需要先构建任务");
        }
        return task;
    }

    void pollTask() {
        this.queue.poll();
    }


    public SuccessfulHttpResponse execute(HttpRequest request) throws InterruptedException {
        Channel channel = this.bootstrap.connect(HOST, PORT).sync().channel();
        channel.writeAndFlush(request).sync();
        return executor.execute();
    }


}
