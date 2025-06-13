package org.harvey.respiratory.client.handler;


import org.harvey.respiratory.client.ServerHandler;
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
public interface UserSecurityHandler extends ServerHandler {

    /**
     * PostMapping("/code")
     * 发送手机验证码
     */
    void sendCode(String phone);

    /**
     * 登录功能
     * PostMapping("/login")
     *
     * @param loginForm 登录参数，包含手机号、验证码；或者手机号、密码, 方式密码和验证码二选一
     */
    void login(LoginFormDto loginForm);

    /**
     * 注册功能
     * PostMapping("/register")
     *
     * @param registerForm 注册参数，包含手机号、密码
     */
    void register(RegisterFormDto registerForm);

    /**
     * 登出功能
     * PostMapping("/logout")
     */
    void logout();

    /**
     * 获取当前登录的用户并返回
     * GetMapping("/me")
     */
    UserDto me();

    /**
     * UserController 根据id查询用户
     * GetMapping("/{id}")
     *
     * @param userId 用id查询某用户
     */
    UserDto queryUserById(Long userId);

    /**
     * "更新用户信息, 也是用身份证实名, 实名之后可确认权限-病人/医生",
     * notes = "没有更新的部分就传null或空字符串,不用传ID"
     * PutMapping("/update")
     */
    void update(UserDto userDTO);


}