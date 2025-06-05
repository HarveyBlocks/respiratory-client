package org.harvey.respiratory.pojo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.harvey.respiratory.pojo.enums.clinic.Role;

import java.io.Serializable;

/**
 * 用户简要信息
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-01 14:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    /**
     * 用户主键. 对于更新, 用户只能更新自己. 所以更新的业务上这个字段没有意义
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 会被服务器set, 每次请求都会set一下, 而不以用户的为准
     */
    private Role role;

    /**
     * 用户身份证
     */
    private String identityCardId;


}
