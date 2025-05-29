package org.harvey.respiratory.net.correspondence;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import org.harvey.respiratory.net.vo.RestfulHttpResponse;

/**
 * {@link HttpClientExecutor} 的实现
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 00:26
 */
@Slf4j
class DefaultHttpClientExecutor implements HttpClientExecutor {
    private final HttpClientManager manager;

    DefaultHttpClientExecutor(HttpClientManager manager) {
        this.manager = manager;
    }

    @Override
    public RestfulHttpResponse execute() throws InterruptedException {
        execute0();
        return syncReceive();
    }

    private void execute0() {
        try {
            synchronized (this) {
                // 代理类
                Channel channel = this.manager.peekTask().getChannel();
                ChannelFuture channelFuture = channel.closeFuture();
                channelFuture.addListener(future -> {
                    channel.close();
                    manager.pollTask();
                });
            }
        } catch (Throwable e) {
            log.error("client error", e);
            throw e;
        }
    }


    private RestfulHttpResponse syncReceive() {
        // 放入Map
        try {
            // 等待响应
            CorrespondenceTask task = manager.peekTask();
            task.waitResponse(); // sync() 会自动抛异常, await不会自动抛异常
            // 我们要自己通过Success方法来检查
            if (task.isSuccess()) {
                return new RestfulHttpResponse(task.getHeader(), task.getContent());
            } else if (!task.isHeadersSuccess()) {
                throw task.headerCause();
            } else if (!task.isContentSuccess()) {
                throw task.contentCause();
            }
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return null;
    }


}
