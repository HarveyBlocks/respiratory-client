package org.harvey.respiratory.client.handler.test;


import org.harvey.respiratory.client.handler.SymptomaticPresentationHandler;
import org.harvey.respiratory.client.pojo.dto.SymptomaticPresentationDto;
import org.harvey.respiratory.client.pojo.entity.clinic.SymptomaticPresentation;
import org.harvey.respiratory.client.pojo.entity.clinic.SymptomaticPresentationDetail;
import org.harvey.respiratory.client.pojo.enums.clinic.SymptomaticPresentationType;

import java.util.List;

/**
 * 症状
 * /symptomatic-presentation/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 21:57
 */
public class TestSymptomaticPresentationHandler implements TestHandler, SymptomaticPresentationHandler {
    private final TestHandlerBind bind;

    public TestSymptomaticPresentationHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public void del(Long id) {

    }

    @Override
    public Long updatePatientSymptomaticPresentation(SymptomaticPresentation symptomaticPresentation) {
        return null;
    }

    @Override
    public List<SymptomaticPresentationDetail> queryDetailsByType(SymptomaticPresentationType type) {
        return null;
    }

    @Override
    public List<SymptomaticPresentationDto> queryVisitDrug(Long visitId) {
        return null;
    }
}
