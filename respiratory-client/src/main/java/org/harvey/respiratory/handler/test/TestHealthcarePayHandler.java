package org.harvey.respiratory.handler.test;


import org.harvey.respiratory.handler.HealthcarePayHandler;
import org.harvey.respiratory.pojo.dto.QueryBalanceDto;
import org.harvey.respiratory.pojo.dto.RechargeDto;

/**
 * 医保, 也包含医保付费
 * /healthcare/order/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 20:05
 */
public class TestHealthcarePayHandler implements TestHandler, HealthcarePayHandler {
    private final TestHandlerBind bind;

    public TestHealthcarePayHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public void pay(Long visitId) {
        bind.info("TestHealthcarePayHandler#pay{}", visitId);
    }

    @Override
    public Integer rechargeByHealthcare(RechargeDto rechargeDto) {
        return bind.uniform(rechargeDto.getAmount(), rechargeDto.getAmount() + 10000);
    }

    @Override
    public Integer queryBalance(QueryBalanceDto queryBalanceDto) {
        return bind.uniform(0, 100000);
    }
}
