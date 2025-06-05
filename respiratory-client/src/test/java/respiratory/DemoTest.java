package respiratory;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.harvey.respiratory.transmit.correspondence.HttpClientManager;
import org.harvey.respiratory.transmit.correspondence.HttpRequestBuilder;
import org.harvey.respiratory.transmit.exception.ClientRequesException;
import org.harvey.respiratory.transmit.vo.ErrorResponse;
import org.harvey.respiratory.transmit.vo.RestfulResult;
import org.harvey.respiratory.transmit.vo.SuccessfulHttpResponse;
import org.junit.Test;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 02:38
 */
@Slf4j(topic = "demo-test")
public class DemoTest {

    public static final HttpClientManager MANAGER = new HttpClientManager();
    public static final HttpRequestBuilder REQUEST_BUILDER = new HttpRequestBuilder();


    /**
     * eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjoxOTIzNDMxNDM0MjQ1MTc3MzQ3LCJleHAiOjE4MzQ5MzM4MDh9.fNgh
     * DkqHEbYVW9nQA1m8yS1oL5ByQ2qvyrP4vCsKJd5-t3R2RXNAQorvFglhXEddpVQB6xBM1Yh4G6E-gtD8c0uRcYtetdLKRBd4V0Cjan
     * Qs-Tg55evbK0fDbyuqCdDyYu5bx30NFVt-qxOaZ-Z_zMUWyfjxyRtMjr8Asd7yfzXb_V-e9pCwNsmy0u4g1pB0Wz2jP5fHxwBuDVkb
     * DG0HvK1FddZM8-Z9FW1sn_18gTpn8xDLWAu1G5Df6u4OhHiBmx_UtY1285M8o3NdL1iaB0DFloxy9oqPOPehcXXQCKJkg2M9JHEWv5
     * 2YOrj6unxbqVIiUnCMjUvz_Iv2uL1IzNQUgN9-C_OP7q09BhF5YpJElZ4Pl16opI-fu_ujpQLFd2k5yI7jjLd4-IwJS1Zv8H3Bwt0b
     * EmRS8TZCZBJrQAF-w73swKp0G38nji7qFoRPKnkfUDa53mL7Dv2POE4MKQsGD6R3MsA1NdBNN6j-c2otdib07kISSCC7-gN-qsjsNs
     * YRZPhnBY-4elOnyL_XRz6CKUw4Llsfx-gJpJ15YfKwL7e1J81uHCRVzrmkho5_TI-3VcEe2cbESw1jsUpMJIcy01KJbQSxbujcgKfA
     * y08fCQFDzZwVMmSV8esLIbdR0B__Or6ElFi9qZRR_KE9tLncpGrZbSZf_7q9DCjZmmY
     */
    public static final String AUTHORIZATION_TOKEN =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjoxOTIzNDMxNDM0MjQ1MTc3MzQ3LCJleHAiOjE4MzQ5MzM4MDh9.fNgh" +
            "DkqHEbYVW9nQA1m8yS1oL5ByQ2qvyrP4vCsKJd5-t3R2RXNAQorvFglhXEddpVQB6xBM1Yh4G6E-gtD8c0uRcYtetdLKRBd4V0Cjan" +
            "Qs-Tg55evbK0fDbyuqCdDyYu5bx30NFVt-qxOaZ-Z_zMUWyfjxyRtMjr8Asd7yfzXb_V-e9pCwNsmy0u4g1pB0Wz2jP5fHxwBuDVkb" +
            "DG0HvK1FddZM8-Z9FW1sn_18gTpn8xDLWAu1G5Df6u4OhHiBmx_UtY1285M8o3NdL1iaB0DFloxy9oqPOPehcXXQCKJkg2M9JHEWv5" +
            "2YOrj6unxbqVIiUnCMjUvz_Iv2uL1IzNQUgN9-C_OP7q09BhF5YpJElZ4Pl16opI-fu_ujpQLFd2k5yI7jjLd4-IwJS1Zv8H3Bwt0b" +
            "EmRS8TZCZBJrQAF-w73swKp0G38nji7qFoRPKnkfUDa53mL7Dv2POE4MKQsGD6R3MsA1NdBNN6j-c2otdib07kISSCC7-gN-qsjsNs" +
            "YRZPhnBY-4elOnyL_XRz6CKUw4Llsfx-gJpJ15YfKwL7e1J81uHCRVzrmkho5_TI-3VcEe2cbESw1jsUpMJIcy01KJbQSxbujcgKfA" +
            "y08fCQFDzZwVMmSV8esLIbdR0B__Or6ElFi9qZRR_KE9tLncpGrZbSZf_7q9DCjZmmY";

    @Test
    public void me() {
        SuccessfulHttpResponse response;
        try {
            REQUEST_BUILDER.addHeader("authorization", AUTHORIZATION_TOKEN);
            HttpRequest request = REQUEST_BUILDER.buildGetRequest(new URI("/user/me"));
            response = MANAGER.execute(request);
        } catch (ClientRequesException ce) {
            // 可能是发送请求-响应这个过程中发生了错误, 那么需要捕获这个异常
            ErrorResponse errorResponse = ce.getErrorResponse();
            // 可以对错误的有关信息做出操作
            log.error("错误码: {}", errorResponse.getCode());
            log.error("错误描述: {}", errorResponse.getReasonPhrase());
            log.error("错误信息文本: {}", errorResponse.getContent());
            log.error("错误响应的响应头: {}", errorResponse.getHeaders());
            throw new RuntimeException(errorResponse.toString());
        } catch (InterruptedException | URISyntaxException e) {
            // 这里是客户端系统有异常
            throw new RuntimeException(e);
        }
        log.info("response = {}", response);
        RestfulResult<UserDto> data = response.buildData(new TypeReference<>() {
        });
        log.info("data = {}", data);
    }

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
}
