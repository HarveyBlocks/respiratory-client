package org.harvey.respiratory.transmit.vo;

import lombok.Data;

import java.util.Map;

/**
 * 异常的信息存储
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-30 00:15
 */
@Data
public class ErrorResponse {
    private final int code;
    private final String reasonPhrase;
    private final Iterable<Map.Entry<String, String>> headers;
    private String content;

    public ErrorResponse(int code, String reasonPhrase, Iterable<Map.Entry<String, String>> headers) {
        this.code = code;
        this.reasonPhrase = reasonPhrase;
        this.headers = headers;
    }
}
