package org.harvey.respiratory.transmit.exception;

/**
 * Transmit的异常
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-05 23:18
 */
public class TransmitException extends RuntimeException {
    public TransmitException() {
        super();
    }

    public TransmitException(String message) {
        super(message);
    }

    public TransmitException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransmitException(Throwable cause) {
        super(cause);
    }

    protected TransmitException(
            String message,
            Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
