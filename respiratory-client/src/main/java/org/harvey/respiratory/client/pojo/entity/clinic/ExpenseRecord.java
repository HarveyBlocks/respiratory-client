package org.harvey.respiratory.client.pojo.entity.clinic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 费用产生记录
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 00:22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRecord implements Serializable {
    /**
     * 费用表id
     */
    private Long id;
    /**
     * 就诊号/就诊表id
     */
    private Long visitDoctorId;
    /**
     * 类别(varchar(63))
     */
    private String category;

    /**
     * 金额/分(int)
     */
    private Integer amount;
    /**
     * 数量(int)
     */
    private Integer count;
    /**
     * 描述(varchar(255))
     */
    private String description;
}
