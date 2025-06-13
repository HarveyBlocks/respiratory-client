package org.harvey.respiratory.client.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 取号需要的信息
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 00:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TakeVisitNumberDto implements Serializable {

    /**
     * 患者id, 不可以null,让用户在自己的系统上选择自己注册的几位病人
     */
    private Long patientId;

    /**
     * 医疗服务者id, 不可以null,让用户在自己的系统上选择中意的医疗提供者
     */
    private Long medicalProviderId;
}
