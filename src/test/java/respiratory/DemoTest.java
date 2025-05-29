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
            HttpRequest request = REQUEST_BUILDER.buildPostRequest(new URI("/user/code"), "15958295131");
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
            Map<String, Object> loginForm = Map.of("code", "040724", "phone", "15958295131", "password", "");
            HttpRequest request = REQUEST_BUILDER.buildPostRequest(new URI("/user/login"), loginForm);
            response = MANAGER.execute(request);
        } catch (InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
        log.info("{}", response);
    }

    public static final String AUTHORIZATION_TOKEN =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ1c2VyIjoxOTI2MjA0MjgxMjE2NTg5ODI1LCJleHAiOjE4MzQ5MzI2NDB9." +
            "OAtgDohtB0FNV2iytEAI-vkLks_gjJTyhTPdtonqDx9dSAhF4jGMMNyggRx01nO_AViRm9r6HDwTVhYMbwyfiobt8L2dLl9aNL" +
            "-VVDDr7v7vtKgYW6TAkSy6IaJRKUU6cTFQ0UkElIlu120_tHSCLyoZTy2CWqDqNoQbXKSIKSaFG1k8RQRvABZwtJJgdWmb_E04" +
            "U9rJNJrV561kI0CRV6TkXQpQXM2CGGViYoVM-JOR_P3aVI6_oGi2PhNTF94K5u4MaYDDOl2XF6ycKk6EB7Z6LQg_IQqe8Jq1ks" +
            "uuqk67cOzQrl4wQTPJFfQPTAAz3jJCDFOc5wGORr1yYw3QAxeeT5fIc5n9ixIZO5Kqvv-v6rivVMh4M4tQ7OLeAFHIm1sDY2Qh" +
            "en-6Vw93fgtQV64lD1_Ep8O6vb5M9H05h6JzFpaVyfa1XtQ1DQjEGZSxHZdRVpGQv3vvxy_r3N5HEyQ56_IsQhJF0CdgtfucOW" +
            "gSkqvLcaOpam_etK2yDveEg1FBF22KgsR6Nqa6gIT99DVnqBxFpSCQ3lNU8Wm8dij-9GUEHgxNuRrMssRWcjkblDSBLEcdFhMr" +
            "v11u4fjtK66CX3EwERVbwFRMC2a4eWItAauoh0NtSTmnMkieQZ_sLt8kSFYORV0Rh-EGDUvDKapqWnXjH0O8j12sqSBrx1w";

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
