package org.harvey.respiratory.handler;


import org.harvey.respiratory.ServerHandler;
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
public interface ExpenseRecordHandler extends ServerHandler {

    /**
     * GetMapping("/visit/{visit-id}")
     * "查询该问诊下的医疗费用记录"
     *
     * @param visitId 问诊号
     */
    List<ExpenseRecord> querySelfExpenseRecord(Long visitId);

}
