package org.harvey.respiratory.transmit.correspondence;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import lombok.extern.slf4j.Slf4j;
import org.harvey.respiratory.transmit.exception.ClientRequesException;
import org.harvey.respiratory.transmit.vo.ErrorResponse;
import org.harvey.respiratory.transmit.vo.SuccessfulHttpResponse;

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
    public SuccessfulHttpResponse execute() throws InterruptedException {
        execute0();
        return syncReceive();
    }

    private void execute0() {
        try {
            synchronized (this) {
                // 代理类
                CorrespondenceTask task = this.manager.peekTask();
                Channel channel = task.getChannel();
                ChannelFuture channelFuture = channel.closeFuture();
                channelFuture.addListener(future -> {
                    channel.close();
                    manager.pollTask();
                });
            }
        } catch (Throwable e) {
            log.error("client error", e);
            throw new RuntimeException(e);
        }
    }


    private SuccessfulHttpResponse syncReceive() {
        // 放入Map
        try {
            // 等待响应
            CorrespondenceTask task = manager.peekTask();
            task.awaitResponse(); // sync() 会自动抛异常, await不会自动抛异常
            // 我们要自己通过Success方法来检查
            if (!task.isContentSuccess()) {
                throw task.contentCause();
            }
            if (!task.isHeadersSuccess()) {
                throw task.headerCause();
            }
            ErrorResponse errorResponse = task.getErrorResponse();
            if (errorResponse != null) {
                errorResponse.setContent(task.getContent());
                throw new ClientRequesException(errorResponse);
            }
            return new SuccessfulHttpResponse(task.getHeader(), task.getContent());
        } catch (Throwable e) {
            throw new RuntimeException(e.getMessage(), e);
        }

    }


}
