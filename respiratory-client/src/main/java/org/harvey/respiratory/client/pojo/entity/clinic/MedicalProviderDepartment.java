package org.harvey.respiratory.client.pojo.entity.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 医疗科室
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 00:04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MedicalProviderDepartment implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 科室名
     */
    private String name;
    /**
     * 外面的大类, null for 没有外面的大类了
     */
    private Integer outerDepartment;
    /**
     * 单位, 分, 不能为null
     */
    private Integer expenseEveryVisit;

    /**
     * 描述, varchar(255)
     */
    private String description;

}
