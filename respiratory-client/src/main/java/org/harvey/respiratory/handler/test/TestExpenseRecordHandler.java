package org.harvey.respiratory.handler.test;


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
public class TestExpenseRecordHandler implements TestHandler, ExpenseRecordHandler {
    private final TestHandlerBind bind;

    public TestExpenseRecordHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public List<ExpenseRecord> querySelfExpenseRecord(Long visitId) {
        return null;
    }
}
