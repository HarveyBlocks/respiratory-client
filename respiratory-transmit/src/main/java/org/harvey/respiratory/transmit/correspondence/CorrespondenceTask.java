package org.harvey.respiratory.transmit.correspondence;

import io.netty.channel.Channel;
import io.netty.util.concurrent.DefaultPromise;
import lombok.Getter;
import lombok.Setter;
import org.harvey.respiratory.transmit.vo.ErrorResponse;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 11:41
 */
class CorrespondenceTask {
    private final DefaultPromise<String> contentPromise;
    private final DefaultPromise<Iterable<Map.Entry<String, String>>> headerPromise;
    @Getter
    private final Channel channel;
    @Getter
    @Setter
    private ErrorResponse errorResponse;

    CorrespondenceTask(Channel channel) {
        this.channel = channel;
        this.contentPromise = new DefaultPromise<>(channel.eventLoop());
        this.headerPromise = new DefaultPromise<>(channel.eventLoop());
    }


    public void setHeaders(Iterable<Map.Entry<String, String>> headers) {
        this.headerPromise.setSuccess(headers);
    }

    public void awaitResponse() throws InterruptedException {
        this.contentPromise.await();
        this.headerPromise.await();
    }

    public boolean isSuccess() {
        return this.headerPromise.isSuccess() && this.contentPromise.isSuccess();
    }

    public boolean isHeadersSuccess() {
        return this.headerPromise.isSuccess();
    }

    public Throwable headerCause() {
        return this.headerPromise.cause();
    }

    public boolean isContentSuccess() {
        return this.contentPromise.isSuccess();
    }

    public Throwable contentCause() {
        return this.contentPromise.cause();
    }

    public Iterable<Map.Entry<String, String>> getHeader() throws ExecutionException, InterruptedException {
        return this.headerPromise.get();
    }

    public String getContent() throws ExecutionException, InterruptedException {
        return this.contentPromise.get();
    }

    public void setContent(String content) {
        this.contentPromise.setSuccess(content);
    }


}
