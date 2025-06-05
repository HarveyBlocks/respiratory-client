package org.harvey.respiratory.transmit.vo;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;
import org.harvey.respiratory.transmit.JacksonUtil;

import java.util.ArrayList;
import java.util.Map;
import java.util.StringJoiner;

/**
 * 符合Restful风格的Result
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 02:19
 */
public class SuccessfulHttpResponse {
    private final String content;
    @Getter
    private final Iterable<HttpHeader> headers;

    public SuccessfulHttpResponse(Iterable<Map.Entry<String, String>> headers, String content) {
        ArrayList<HttpHeader> list = new ArrayList<>();
        headers.forEach(e -> list.add(new HttpHeader(e)));
        this.headers = list;
        if (content == null || content.isEmpty()) {
            throw new IllegalStateException("被服务器拒绝");
        }
        this.content = content;
    }

    public <T> RestfulResult<T> buildData(TypeReference<RestfulResult<T>> typeReference) {
        return JacksonUtil.toBean(content, typeReference);
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",");
        headers.forEach(h -> joiner.add(h.getKey() + ":" + h.getValue()));
        return "SuccessfulHttpResponse{" +
               "content='" + content + '\'' +
               ", headers=" + joiner +
               '}';
    }
}
