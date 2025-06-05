package org.harvey.respiratory.handler.transmit;


import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.handler.ExpenseRecordHandler;
import org.harvey.respiratory.pojo.entity.clinic.ExpenseRecord;

import java.util.List;

/**
 * 费用记录
 * /expense-record/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 20:01
 */
public class TransmitExpenseRecordHandler implements TransmitHandler, ExpenseRecordHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("expense-record", "api");

    public TransmitExpenseRecordHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public List<ExpenseRecord> querySelfExpenseRecord(Long visitId) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("visit", visitId),
                new TypeReference<>() {
                }
        );
    }
}
