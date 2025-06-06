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
        List<ExpenseRecord> list = bind.list(this::buildEntity);
        list.forEach(e -> e.setVisitDoctorId(visitId));
        return list;
    }

    private ExpenseRecord buildEntity() {
        return new ExpenseRecord(
                bind.randomLongId(),
                bind.randomLongId(),
                bind.randomLongString(),
                bind.uniform(200,20000),
                bind.uniform(1,5),
                bind.randomLongString()
        );
    }
}
