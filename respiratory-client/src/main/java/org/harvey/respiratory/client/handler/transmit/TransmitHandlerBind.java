package org.harvey.respiratory.client.handler.transmit;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.harvey.respiratory.transmit.JacksonUtil;
import org.harvey.respiratory.transmit.correspondence.HttpClientManager;
import org.harvey.respiratory.transmit.correspondence.HttpRequestBuilder;
import org.harvey.respiratory.transmit.exception.TransmitException;
import org.harvey.respiratory.transmit.vo.HttpHeader;
import org.harvey.respiratory.transmit.vo.RestfulResult;
import org.harvey.respiratory.transmit.vo.SuccessfulHttpResponse;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-05 22:56
 */
@Getter
@AllArgsConstructor
@Slf4j
public class TransmitHandlerBind {
    private final SimpleDateFormat simpleDateFormat;
    private final HttpRequestBuilder httpRequestBuilder;
    private final HttpClientManager clientManager;

    public String formatDate(Date date) {
        return simpleDateFormat.format(date);
    }

    public void setHeaders(Iterable<HttpHeader> headers) {
        httpRequestBuilder.resetHeaders(headers);
    }

    public SuccessfulHttpResponse execute(HttpMethod httpMethod, String path) {
        return execute(httpMethod, path, null);
    }


    public SuccessfulHttpResponse execute(HttpMethod httpMethod, String path, String jsonBody) {
        try {
            log.debug("method={}, path={}", httpMethod, path);
            URI uri = new URI(path);
            HttpRequest httpRequest = httpRequestBuilder.buildRequest(httpMethod, uri, jsonBody);
            return clientManager.execute(httpRequest);
        } catch (InterruptedException e) {
            throw new TransmitException("请求被中断", e);
        } catch (URISyntaxException e) {
            throw new TransmitException("ERROR URI", e);
        }
    }

    public <T> T executeSimply(
            HttpMethod httpMethod, String path, Object body,
            TypeReference<RestfulResult<T>> typeReference) {
        String jsonStr = JacksonUtil.toJsonStr(body);
        SuccessfulHttpResponse response = execute(httpMethod, path, jsonStr);
        return dealResponse(response, typeReference);
    }

    public <T> T executeSimply(
            HttpMethod httpMethod, String path,
            TypeReference<RestfulResult<T>> typeReference) {
        return executeSimply(httpMethod, path, null, typeReference);
    }

    public String toJsonStr(Object bean) {
        return JacksonUtil.toJsonStr(bean);
    }

    public <T> T dealResponse(
            SuccessfulHttpResponse response,
            TypeReference<RestfulResult<T>> typeReference) {
        RestfulResult<T> restfulResult = response.buildData(typeReference);
        if (!restfulResult.succeed()) {
            throw new TransmitException(restfulResult.getMsg());
        }
        return restfulResult.getData();

    }
}
