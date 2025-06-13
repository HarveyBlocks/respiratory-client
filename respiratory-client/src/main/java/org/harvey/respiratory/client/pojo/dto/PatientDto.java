package org.harvey.respiratory.client.pojo.dto;

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
public class PatientDto implements Serializable {
    /**
     * 患者的id, 服务端生成, 只可读
     */
    private Long id;
    /**
     * 手机号码(unique, char(11)), 监护人电话, 不可为null
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
     * 医保表id, 可以为null
     */
    private String healthcareCode;

    /**
     * 医保类型, 可以为null, varchar(63)
     */
    private String healthcareType;

    /**
     * 医保余额,单位, 分, 可以为null
     */
    private Integer balance;

}
