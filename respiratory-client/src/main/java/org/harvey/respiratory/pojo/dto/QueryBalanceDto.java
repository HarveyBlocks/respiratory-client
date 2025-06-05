package org.harvey.respiratory.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 充值的查询依据, 或医保id,或医保号,或病患号, 或身份证, 四选一
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-21 23:13
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QueryBalanceDto implements Serializable {
    /**
     * 医保id优先级最高
     */
    private Long healthcareId;
    /**
     * 医保号次之
     */
    private String healthcareCode;
    /**
     * 病患id再次之
     */
    private Long patientId;
    /**
     * 身份证优先级最低
     */
    private String identifierCardId;
}
