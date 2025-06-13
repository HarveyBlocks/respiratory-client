package org.harvey.respiratory.client.handler.test;


import org.harvey.respiratory.client.handler.UserSecurityHandler;
import org.harvey.respiratory.client.pojo.dto.LoginFormDto;
import org.harvey.respiratory.client.pojo.dto.RegisterFormDto;
import org.harvey.respiratory.client.pojo.dto.UserDto;

/**
 * 用户登录校验
 * /user/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com"Harvey Blocks</a
 * @version 1.0
 * @date 2025-06-01 14:09
 */
public class TestUserSecurityHandler implements TestHandler, UserSecurityHandler {
    private final TestHandlerBind bind;

    public TestUserSecurityHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public void sendCode(String phone) {

    }

    @Override
    public void login(LoginFormDto loginForm) {

    }

    @Override
    public void register(RegisterFormDto registerForm) {

    }

    @Override
    public void logout() {

    }

    @Override
    public UserDto me() {
        return null;
    }

    @Override
    public UserDto queryUserById(Long userId) {
        return null;
    }

    @Override
    public void update(UserDto userDTO) {

    }
}