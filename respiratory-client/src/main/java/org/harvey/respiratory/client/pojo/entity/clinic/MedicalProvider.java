package org.harvey.respiratory.client.pojo.entity.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 00:42
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MedicalProvider implements Serializable {
    /**
     * 新增时需要为null, 更新时不能为null, 就是依据id更新
     */
    private Long id;
    /**
     * 医疗提供者身份证号, char(11) 不可为null
     */
    private String identityCardId;
    /**
     * 名称(varchar(63))
     */
    private String name;
    /**
     * 医疗服务机构表id, 不可以为null
     */
    private Integer formId;
    /**
     * 科室的id, 不可以为null
     */
    private Integer departmentId;
    /**
     * 职位的id, 不可以为null
     */
    private Integer jobId;
}
