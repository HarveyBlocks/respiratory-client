package org.harvey.respiratory.handler.transmit;


import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.handler.UserSecurityHandler;
import org.harvey.respiratory.pojo.dto.LoginFormDto;
import org.harvey.respiratory.pojo.dto.RegisterFormDto;
import org.harvey.respiratory.pojo.dto.UserDto;
import org.harvey.respiratory.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;
import org.harvey.respiratory.transmit.vo.SuccessfulHttpResponse;

/**
 * 用户登录校验
 * /user/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com"Harvey Blocks</a
 * @version 1.0
 * @date 2025-06-01 14:09
 */
public class TransmitUserSecurityHandler implements TransmitHandler, UserSecurityHandler {

    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("user", "api");

    public TransmitUserSecurityHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public void sendCode(String phone) {
        bind.executeSimply(
                HttpMethod.POST, uriJoin.add("code"), phone, new TypeReference<RestfulResult<NullPlaceholder>>() {
                });
    }

    @Override
    public void login(LoginFormDto loginForm) {
        String jsonStr = bind.toJsonStr(loginForm);
        SuccessfulHttpResponse execute = bind.execute(HttpMethod.POST, uriJoin.add("login"), jsonStr);
        bind.dealResponse(execute, new TypeReference<RestfulResult<NullPlaceholder>>() {
        });
        bind.setHeaders(execute.getHeaders());
    }

    @Override
    public void register(RegisterFormDto registerForm) {
        String jsonStr = bind.toJsonStr(registerForm);
        SuccessfulHttpResponse execute = bind.execute(HttpMethod.POST, uriJoin.add("register"), jsonStr);
        bind.dealResponse(execute, new TypeReference<RestfulResult<NullPlaceholder>>() {
        });
        bind.setHeaders(execute.getHeaders());
    }

    @Override
    public void logout() {
        bind.executeSimply(HttpMethod.POST, uriJoin.add("logout"), new TypeReference<RestfulResult<NullPlaceholder>>() {
        });
    }

    @Override
    public UserDto me() {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("me"), new TypeReference<>() {
        });
    }

    @Override
    public UserDto queryUserById(Long userId) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add(userId), new TypeReference<>() {
        });
    }

    @Override
    public void update(UserDto userDTO) {
        bind.executeSimply(
                HttpMethod.PUT, uriJoin.add("update"), userDTO, new TypeReference<RestfulResult<NullPlaceholder>>() {
                });
    }
}