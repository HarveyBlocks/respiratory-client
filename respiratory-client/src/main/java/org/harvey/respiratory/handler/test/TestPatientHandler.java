package org.harvey.respiratory.handler.test;


import org.harvey.respiratory.handler.PatientHandler;
import org.harvey.respiratory.pojo.dto.PatientDto;
import org.harvey.respiratory.pojo.entity.clinic.Patient;

import java.util.List;

/**
 * 患者与医保
 * 如果一个系统的使用者含有多个患者的记录
 * /patient/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 22:07
 */
public class TestPatientHandler implements TestHandler, PatientHandler {
    private final TestHandlerBind bind;

    public TestPatientHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Long registerPatientInformation(PatientDto patientDto) {
        return null;
    }

    @Override
    public void delPatientInformation(Long patientId) {

    }

    @Override
    public void update(Patient patient) {

    }

    @Override
    public List<PatientDto> querySelfPatients(Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<PatientDto> querySelfPatients(Integer page) {
        return null;
    }

    @Override
    public List<PatientDto> querySelfPatients() {
        return null;
    }

    @Override
    public PatientDto queryPatientByHealthcareId(String healthcareCode) {
        return null;
    }

    @Override
    public PatientDto queryPatientByPatientId(Long patientId) {
        return null;
    }

    @Override
    public PatientDto queryByIdentity(String cardId) {
        return null;
    }
}
