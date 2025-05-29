package org.harvey.respiratory.net.exception;

import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.Getter;

/**
 * TODO  ClientReques的异常
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-30 00:10
 */
@Getter
public class ClientRequesException extends RuntimeException {
    private final int code;
    private final String reasonPhrase;

    public ClientRequesException(HttpResponseStatus status, String message) {
        super(message);
        this.code = status.code();
        this.reasonPhrase = status.reasonPhrase();
    }

    public ClientRequesException(HttpResponseStatus status, String message, Throwable cause) {
        super(message, cause);
        this.code = status.code();
        this.reasonPhrase = status.reasonPhrase();
    }

    public ClientRequesException(HttpResponseStatus status, Throwable cause) {
        super(cause);
        this.code = status.code();
        this.reasonPhrase = status.reasonPhrase();
    }

    protected ClientRequesException(
            HttpResponseStatus status,
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = status.code();
        this.reasonPhrase = status.reasonPhrase();
    }


    public ClientRequesException(HttpResponseStatus status) {
        super(status.toString());
        this.code = status.code();
        this.reasonPhrase = status.reasonPhrase();
    }
}
