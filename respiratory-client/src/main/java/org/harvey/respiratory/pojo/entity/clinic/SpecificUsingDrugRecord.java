package org.harvey.respiratory.pojo.entity.clinic;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 特定药品使用方式中间表
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-12 23:57
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SpecificUsingDrugRecord implements Serializable {
    private Long id;
    /**
     * 就诊号/就诊表id
     */
    private Long visitDoctorId;

    /**
     * 药品表id
     */
    private Integer drugId;

    /**
     * 药品数量, 和费用计算相关
     */
    private Integer count;

    /**
     * 患者表id(冗余, 为了提高查询效率)
     */
    private Long patientId;

    /**
     * 使用剂量(varchar(63)), 由于单位不确定, 所以是字符串
     */
    private String dosageUsed;

    /**
     * 使用天数(int)
     */
    private Integer dayTimeUsed;

    /**
     * 使用频率(varchar(63)), 同样不知道单位
     */
    private String frequencyUsed;

    /**
     * 治疗开始时间(date)
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date treatStart;

    /**
     * 治疗结束时间(date)
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date treatEnd;


    /**
     * 其他用药指导(TEXT)
     */
    private String otherMedicationGuidance;

}
