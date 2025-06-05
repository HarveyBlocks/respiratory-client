package org.harvey.respiratory.transmit.exception;

import lombok.Getter;
import org.harvey.respiratory.transmit.vo.ErrorResponse;

/**
 * ClientReques的异常
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-30 00:10
 */
@Getter
public class ClientRequesException extends RuntimeException {
    private final ErrorResponse errorResponse;

    public ClientRequesException(
            ErrorResponse response, String message) {
        super(message);
        this.errorResponse = response;
    }

    public ClientRequesException(
            ErrorResponse response, String message, Throwable cause) {
        super(message, cause);
        this.errorResponse = response;
    }

    public ClientRequesException(
            ErrorResponse response, Throwable cause) {
        super(cause);
        this.errorResponse = response;
    }

    protected ClientRequesException(
            ErrorResponse response,
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorResponse = response;
    }


    public ClientRequesException(ErrorResponse response) {
        super();
        this.errorResponse = response;
    }
}
