package org.harvey.respiratory.client.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 充值
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 23:54
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RechargeDto implements Serializable {
    /**
     * 充值的查询依据
     */
    private QueryBalanceDto queryBalanceDto;

    /**
     * 充值金额, 单位, 分, 必正
     */
    private Integer amount;
}
