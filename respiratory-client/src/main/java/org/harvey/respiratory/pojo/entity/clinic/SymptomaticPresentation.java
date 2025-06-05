package org.harvey.respiratory.pojo.entity.clinic;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.harvey.respiratory.pojo.enums.clinic.Severity;

import java.io.Serializable;
import java.util.Date;

/**
 * 症状表现表
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 00:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SymptomaticPresentation implements Serializable {
    /**
     * 症状id
     */
    private Long id;
    /**
     * 就诊号/就诊表id
     */
    private Long visitDoctorId;
    /**
     * 具体的症状的id(int)
     */
    private Integer detailId;

    /**
     * 严重程度(enum-轻度/中度/重度)
     */
    private Severity severity;
    /**
     * 频率(varchar(63)), 由于不知道单位, 故字符串
     */
    private String frequency;
    /**
     * 症状开始时间(date)
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

    /**
     * 创建/更新时间,服务器会给出, readonly
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private Date createTime;

}
