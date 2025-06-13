package org.harvey.respiratory.client.pojo.entity.clinic;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 问诊表
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-12 23:47
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class VisitDoctor implements Serializable {
    /**
     * 就诊号
     */
    private Long id;
    /**
     * 患者id, 不应该为null
     */
    private Long patientId;
    /**
     * 医疗服务者id, 不可以为null
     */
    private Long medicalProviderId;
    /**
     * 简要介绍(varchar(255)), 如果医生不提供, 就是病症名的list
     */
    private String briefDescription;
    /**
     * 其他辅助治疗
     */
    private String otherAdjuvantTherapy;

    /**
     * 就诊时间, 只读
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime visitTime;
    /**
     * 总费用, 单位分
     * 医生职业+医生科室+(药品*数量)*for-each
     * 只读
     */
    private Integer totalExpense;

    /**
     * 是否已经interviewed, 是外界只读的字段
     */
    private boolean interviewed = false;

    /**
     * 是否已付款, 是外界只读的字段
     */
    private boolean paid = false;
    /**
     * 随访表, 可以为null
     */
    private Long followupId;
}
