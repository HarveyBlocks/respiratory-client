package org.harvey.respiratory.pojo.entity.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 药品具体信息
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 00:16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Drug implements Serializable {
    /**
     * 药品id
     */
    private Integer id;
    /**
     * 药物名称(varchar(63))
     */
    private String name;

    /**
     * 治疗目标(varchar(255))
     */
    private String treatTarget;
    /**
     * 药物单价, 单位, 分
     */
    private Integer expenseEach;
    /**
     * 药物规格(varchar(63))
     */
    private String specification;
    /**
     * 给药途径(varchar(63))
     */
    private String administrationRoute;
    /**
     * 用药部位(varchar(63))
     */
    private String medicationSite;
    /**
     * 用药注意事项(varchar(255))
     */
    private String medicationPrecaution;
    /**
     * 用药指导(TEXT)
     */
    private String guidance;
    /**
     * 药品库存
     */
    private Integer storage;
}
