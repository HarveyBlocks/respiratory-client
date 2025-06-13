package org.harvey.respiratory.client.handler;


import org.harvey.respiratory.client.ServerHandler;
import org.harvey.respiratory.client.pojo.dto.QueryBalanceDto;
import org.harvey.respiratory.client.pojo.dto.RechargeDto;

/**
 * 医保, 也包含医保付费
 * /healthcare/order/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 20:05
 */
public interface HealthcarePayHandler extends ServerHandler {
    /**
     * 付款
     * PutMapping("pay")
     *
     * @param visitId 付款的目标问诊
     */
    void pay(Long visitId);

    /**
     * 用查询医保后, 然后充值
     * PutMapping("recharge/healthcare/")
     *
     * @param rechargeDto 充值信息
     * @return 返回是充值之后的余额
     */
    Integer rechargeByHealthcare(RechargeDto rechargeDto);

    /**
     * 用病号查询余额
     * PutMapping("balance/healthcare")
     *
     * @param queryBalanceDto 查询余额的依据
     * @return 返回余额
     */
    Integer queryBalance(QueryBalanceDto queryBalanceDto);
}
