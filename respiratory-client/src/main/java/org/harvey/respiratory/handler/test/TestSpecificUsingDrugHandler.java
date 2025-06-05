package org.harvey.respiratory.handler.test;


import org.harvey.respiratory.handler.SpecificUsingDrugHandler;
import org.harvey.respiratory.pojo.dto.DrugDto;
import org.harvey.respiratory.pojo.entity.clinic.SpecificUsingDrugRecord;

import java.util.Date;
import java.util.List;

/**
 * 药物使用
 * /special-using-drug/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 20:57
 */
public class TestSpecificUsingDrugHandler implements TestHandler, SpecificUsingDrugHandler {
    private final TestHandlerBind bind;

    public TestSpecificUsingDrugHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public void del(Long id) {

    }

    @Override
    public void del(Long visitDoctorId, Long drugId) {

    }

    @Override
    public Long updatePatientDrugHistory(SpecificUsingDrugRecord specificUsing) {
        return null;
    }

    @Override
    public List<DrugDto> queryDrugInVisit(Long visitId) {
        return null;
    }

    @Override
    public List<DrugDto> queryPatientDrugHistoryByDrug(Long patientId, String name) {
        return null;
    }

    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId, Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId, Date startDate) {
        return null;
    }

    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId) {
        return null;
    }
}
