package org.harvey.respiratory.client.pojo.entity.clinic;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.harvey.respiratory.client.pojo.enums.clinic.Sex;

import java.io.Serializable;
import java.util.Date;

/**
 * 患者信息
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 00:48
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable {
    /**
     * 新增时需要为null, 更新时不能为null, 就是依据id更新
     */
    private Long id;

    /**
     * 监护人手机号码(unique, char(11)), 不可为null
     */
    private String phone;

    /**
     * 病患身份证号, char(11) 不可为null
     */
    private String identityCardId;

    /**
     * 名称(varchar(63)), 不可为null
     */
    private String name;

    /**
     * 性别, 不可为null
     */
    private Sex sex;

    /**
     * 出生日期, 不可为null
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthDate;
    /**
     * 家庭住址(varchar(255)), 不可为null
     */
    private String address;

    /**
     * 身高(m) (float), 不可为null
     */
    private float height;

    /**
     * 体重(kg) (float), 不可为null
     */
    private float weight;

    /**
     * 医保表id, 可以为null. 只能在医保接口更新医保, 不能在病患接口更新医保id
     */
    private Long healthcareId;

}
