package org.harvey.respiratory.pojo.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.harvey.respiratory.pojo.enums.clinic.Severity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 问诊一次会上传的信息, 医生问诊信息
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 13:30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class InterviewDto implements Serializable {

    /**
     * 就诊号/就诊表id
     */
    private Long visitDoctorId;

    /**
     * 简要介绍(varchar(255)), 如果医生不提供, 就是病症名的list
     */
    private String briefDescription;

    /**
     * 其他辅助治疗
     */
    private String otherAdjuvantTherapy;

    /**
     * 症状表, 可以为empty, 不可为null
     */
    private List<InterviewSymptomaticPresentation> symptomaticPresentationList;

    /**
     * 药物具体使用表, 可以为empty, 不可为null
     */
    private List<SpecificUsingDrugRecordDto> specificUsingDrugRecordDtoList;

    /**
     * 疾病诊断, 可以为empty, 不可为null
     */
    private List<Integer> diseaseIds;

    /**
     * 药物具体使用
     */
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SpecificUsingDrugRecordDto {
        /**
         * 药品表id, 指向药品表中的药品
         */
        private Integer drugId;

        /**
         * 药品数量, 和费用计算相关
         */
        private Integer count;

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

    /**
     * 症状
     */
    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InterviewSymptomaticPresentation {

        /**
         * 症状具体, 主键, int, 具体症状而不是症状表现!
         */
        private Integer id;

        /**
         * 严重程度(enum-轻度/中度/重度)
         */
        private Severity severity;

        /**
         * 频率(varchar(63)), 由于不知道单位
         */
        private String frequency;

        /**
         * 开始时间(date)
         */
        @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
        private Date startTime;

        /**
         * 诱因(varchar(63))
         */
        private String incentive;

        /**
         * 环境因素(varchar(63))
         */
        private String environmentalFactor;

        /**
         * 体征描述(varchar(63))
         */
        private String signDescription;

        /**
         * 描述(TEXT)
         */
        private String description;

    }
}
