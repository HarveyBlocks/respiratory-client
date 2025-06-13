package org.harvey.respiratory.client.pojo.entity.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 医疗提供者的职位
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 00:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MedicalProviderJob implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 职位名
     */
    private String name;

    /**
     * 职位可以持有的权限
     */
    private Integer roleId;
    /**
     * 职位的对每次问诊的消费,单位, 分
     */
    private Integer expenseEveryVisit;
}
