package org.harvey.respiratory.transmit.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * 请求头/响应头
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-28 10:18
 */
@AllArgsConstructor
@Getter
public class HttpHeader implements Map.Entry<String, String> {
    private final String key;
    private String value;

    public HttpHeader(Map.Entry<String, String> e) {
        this(e.getKey(), e.getValue());
    }

    @Override
    public String setValue(String value) {
        return this.value = value;
    }

}
