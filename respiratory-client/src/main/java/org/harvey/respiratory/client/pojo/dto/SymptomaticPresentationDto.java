package org.harvey.respiratory.client.pojo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.harvey.respiratory.client.pojo.enums.clinic.Severity;
import org.harvey.respiratory.client.pojo.enums.clinic.SymptomaticPresentationType;

import java.io.Serializable;
import java.util.Date;


/**
 * 症状表现
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-03 22:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SymptomaticPresentationDto implements Serializable {
    /**
     * 症状具体, 具体症状而不是症状表现!
     */
    private String detailName;

    /**
     * 症状具体的类型
     */
    private SymptomaticPresentationType type;

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
