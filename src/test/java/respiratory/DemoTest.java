package respiratory;

import io.netty.handler.codec.http.HttpRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.harvey.respiratory.Demo;
import org.harvey.respiratory.net.correspondence.HttpClientManager;
import org.harvey.respiratory.net.correspondence.HttpRequestBuilder;
import org.harvey.respiratory.net.vo.RestfulHttpResponse;
import org.harvey.respiratory.net.vo.RestfulResult;
import org.junit.Test;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 02:38
 */
@Slf4j(topic = "demo-test")
public class DemoTest {

    public static final HttpClientManager MANAGER = Demo.MANAGER;
    public static final HttpRequestBuilder REQUEST_BUILDER = Demo.REQUEST_BUILDER;


    @Test
    public void sendCode() {
        RestfulHttpResponse response;
        try {
            HttpRequest request = REQUEST_BUILDER.buildPostRequest(new URI("/user/code"), "18299382839");
            response = MANAGER.execute(request);
        } catch (InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        log.info("{}", response);
    }

    @Test
    public void login() {
        RestfulHttpResponse response;
        try {
            Map<String, Object> loginForm = Map.of("code", "463499", "phone", "18299382839", "password", "");
            HttpRequest request = REQUEST_BUILDER.buildPostRequest(new URI("/user/login"), loginForm);
            response = MANAGER.execute(request);
        } catch (InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        log.info("{}", response);
    }

    public static final String AUTHORIZATION_TOKEN =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjoxOTIzNDMxNDM0MjQ1MTc3MzQ3LCJleHAiOjE4MzQ5MzM4MDh9.fNgh" +
            "DkqHEbYVW9nQA1m8yS1oL5ByQ2qvyrP4vCsKJd5-t3R2RXNAQorvFglhXEddpVQB6xBM1Yh4G6E-gtD8c0uRcYtetdLKRBd4V0Cjan" +
            "Qs-Tg55evbK0fDbyuqCdDyYu5bx30NFVt-qxOaZ-Z_zMUWyfjxyRtMjr8Asd7yfzXb_V-e9pCwNsmy0u4g1pB0Wz2jP5fHxwBuDVkb" +
            "DG0HvK1FddZM8-Z9FW1sn_18gTpn8xDLWAu1G5Df6u4OhHiBmx_UtY1285M8o3NdL1iaB0DFloxy9oqPOPehcXXQCKJkg2M9JHEWv5" +
            "2YOrj6unxbqVIiUnCMjUvz_Iv2uL1IzNQUgN9-C_OP7q09BhF5YpJElZ4Pl16opI-fu_ujpQLFd2k5yI7jjLd4-IwJS1Zv8H3Bwt0b" +
            "EmRS8TZCZBJrQAF-w73swKp0G38nji7qFoRPKnkfUDa53mL7Dv2POE4MKQsGD6R3MsA1NdBNN6j-c2otdib07kISSCC7-gN-qsjsNs" +
            "YRZPhnBY-4elOnyL_XRz6CKUw4Llsfx-gJpJ15YfKwL7e1J81uHCRVzrmkho5_TI-3VcEe2cbESw1jsUpMJIcy01KJbQSxbujcgKfA" +
            "y08fCQFDzZwVMmSV8esLIbdR0B__Or6ElFi9qZRR_KE9tLncpGrZbSZf_7q9DCjZmmY";

    @ToString
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class UserDto implements Serializable {

        private Long id;
        private String name;

        private Integer role;
        private String identityCardId;

    }

    @Test
    public void me() {
        RestfulHttpResponse response;
        try {
            REQUEST_BUILDER.addHeader("authorization", AUTHORIZATION_TOKEN);
            HttpRequest request = REQUEST_BUILDER.buildGetRequest(new URI("/user/me"));
            response = MANAGER.execute(request);
        } catch (InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        log.info("response = {}", response);
        RestfulResult<UserDto> data = response.buildData();
        log.info("data = {}", data);
    }
}
