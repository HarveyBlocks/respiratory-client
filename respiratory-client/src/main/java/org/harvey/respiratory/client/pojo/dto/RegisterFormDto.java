package org.harvey.respiratory.client.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 注册时需要的参数
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-01 14:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterFormDto implements Serializable {
    /**
     * 用户的电话号码,会在后端做正则的校验
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;
}

