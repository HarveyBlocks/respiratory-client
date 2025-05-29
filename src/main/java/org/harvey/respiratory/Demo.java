package org.harvey.respiratory;

import io.netty.handler.codec.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import org.harvey.respiratory.net.correspondence.HttpClientManager;
import org.harvey.respiratory.net.correspondence.HttpRequestBuilder;
import org.harvey.respiratory.net.vo.RestfulHttpResponse;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 02:38
 */
@Slf4j(topic = "demo")
public class Demo {
    public static void main(String[] args) {
        demo2();
    }

    public static final HttpClientManager MANAGER = new HttpClientManager();
    public static final HttpRequestBuilder REQUEST_BUILDER = new HttpRequestBuilder();

    public static void demo1() {
        // 阻塞获取响应
        RestfulHttpResponse response;
        try {
            HttpRequest request = REQUEST_BUILDER.buildGetRequest(new URI("/hello"));
            response = MANAGER.execute(request);
        } catch (InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        log.info("{}", response);
    }



    public static void demo2() {
        // 异步获取响应
        HttpRequest request;
        try {
            request = REQUEST_BUILDER.buildGetRequest(new URI("/hello"));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        MANAGER.execute(request, response -> log.info("{}",response));
        log.info("证明异步, 执行了接下来的语句");
    }

}
