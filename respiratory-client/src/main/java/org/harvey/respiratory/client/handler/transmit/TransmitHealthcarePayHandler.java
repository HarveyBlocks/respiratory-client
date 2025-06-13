package org.harvey.respiratory.client.handler.transmit;


import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.client.handler.HealthcarePayHandler;
import org.harvey.respiratory.client.pojo.dto.QueryBalanceDto;
import org.harvey.respiratory.client.pojo.dto.RechargeDto;
import org.harvey.respiratory.client.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

/**
 * 医保, 也包含医保付费
 * /healthcare/order/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 20:05
 */
public class TransmitHealthcarePayHandler implements TransmitHandler, HealthcarePayHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("healthcare", "order", "api");

    public TransmitHealthcarePayHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public void pay(Long visitId) {
        TypeReference<RestfulResult<NullPlaceholder>> typeReference = new TypeReference<>() {
        };
        bind.executeSimply(HttpMethod.PUT, uriJoin.add("pay"), visitId, typeReference);
    }


    @Override
    public Integer rechargeByHealthcare(RechargeDto rechargeDto) {
        return bind.executeSimply(HttpMethod.PUT, uriJoin.add("recharge", "healthcare"), rechargeDto,
                new TypeReference<>() {
                }
        );
    }


    @Override
    public Integer queryBalance(QueryBalanceDto queryBalanceDto) {
        return bind.executeSimply(HttpMethod.PUT, uriJoin.add("balance", "healthcare"), queryBalanceDto,
                new TypeReference<>() {
                }
        );
    }
}
