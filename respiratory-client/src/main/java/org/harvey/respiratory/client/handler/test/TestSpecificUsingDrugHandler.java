package org.harvey.respiratory.client.handler.test;


import org.harvey.respiratory.client.handler.SpecificUsingDrugHandler;
import org.harvey.respiratory.client.pojo.dto.DrugDto;
import org.harvey.respiratory.client.pojo.entity.clinic.SpecificUsingDrugRecord;

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
        bind.info("TestSpecificUsingDrugHandler#del{}", id);
    }

    @Override
    public void del(Long visitDoctorId, Long drugId) {
        bind.info("TestSpecificUsingDrugHandler#del{}{}", visitDoctorId, drugId);
    }

    @Override
    public Long updatePatientDrugHistory(SpecificUsingDrugRecord specificUsing) {
        return bind.randomLongId();
    }

    @Override
    public List<DrugDto> queryDrugInVisit(Long visitId) {
        List<DrugDto> list = bind.list(this::buildEntity);
        list.forEach(e -> e.getSpecificUsingDrugRecord().setVisitDoctorId(visitId));
        return list;
    }

    private DrugDto buildEntity() {
        return new DrugDto();
    }

    @Override
    public List<DrugDto> queryPatientDrugHistoryByDrug(Long patientId, String name) {
        List<DrugDto> list = bind.list(this::buildEntity);
        list.forEach(e -> {
            e.getSpecificUsingDrugRecord().setPatientId(patientId);
            e.getDrug().setName(name);
        });
        return list;
    }

    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId, Date startDate, Date endDate) {
        List<DrugDto> list = bind.list(this::buildEntity);
        list.forEach(e -> {
            SpecificUsingDrugRecord record = e.getSpecificUsingDrugRecord();
            record.setPatientId(patientId);
            java.util.Date start = bind.randomDate(startDate, endDate);
            record.setTreatStart(start);
            record.setTreatEnd(bind.randomDate(start, endDate));
        });
        return list;
    }

    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId, Date startDate) {
        return queryPatientDrugHistoryByDate(patientId, startDate, null);
    }

    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId) {
        return queryPatientDrugHistoryByDate(patientId, null, null);
    }
}
