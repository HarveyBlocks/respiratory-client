package org.harvey.respiratory.net.vo;

import lombok.Getter;
import org.harvey.respiratory.net.JacksonUtil;
import org.harvey.respiratory.net.correspondence.HttpHeader;
import org.harvey.respiratory.net.properties.NetProperties;

import java.util.ArrayList;
import java.util.Map;

/**
 * 符合Restful风格的Result
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 02:19
 */
@Getter
public class RestfulHttpResponse {
    public static final String CODE_FIELD = NetProperties.DEFAULT.get(NetProperties.PropertyName.CODE_FIELD);
    public static final String DATA_FIELD = NetProperties.DEFAULT.get(NetProperties.PropertyName.DATA_FIELD);
    public static final String MESSAGE_FIELD = NetProperties.DEFAULT.get(NetProperties.PropertyName.MESSAGE_FIELD);
    private final Iterable<HttpHeader> headers;
    private final int code;
    private final String message;
    private final String data;

    public RestfulHttpResponse(Iterable<Map.Entry<String, String>> headers, String content) {
        ArrayList<HttpHeader> list = new ArrayList<>();
        headers.forEach(e -> list.add(new HttpHeader(e)));
        this.headers = list;
        Map<String, String> map = JacksonUtil.toStringMap(content);
        this.code = Integer.parseInt(map.get(CODE_FIELD));//"code";
        this.data = map.get(DATA_FIELD);//data;
        this.message = map.get(MESSAGE_FIELD);//msg;
    }

    public <T> T getData(Class<T> targetType) {
        return JacksonUtil.toBean(data, targetType);
    }

    public boolean success() {
        return code == 200;
    }

    @Override
    public String toString() {
        return "RestfulHttpResponse{" +
               "headers=" + headers +
               ", code=" + code +
               ", message='" + message + '\'' +
               ", data='" + data + '\'' +
               '}';
    }
}
