package org.harvey.respiratory.client.handler.test;


import org.harvey.respiratory.client.ServerHandler;
import org.harvey.respiratory.client.handler.VisitDoctorHandler;
import org.harvey.respiratory.client.pojo.dto.TakeVisitNumberDto;
import org.harvey.respiratory.client.pojo.entity.clinic.VisitDoctor;

import java.util.Date;
import java.util.List;

/**
 * 医生进行问诊,就诊
 * /visit/api/
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-12 23:40
 */
public class TestVisitDoctorHandler implements ServerHandler, VisitDoctorHandler {
    private final TestHandlerBind bind;

    public TestVisitDoctorHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Long createVisitDoctorId(TakeVisitNumberDto takeVisitNumberDto) {
        return null;
    }

    @Override
    public VisitDoctor getById(Long id) {
        return null;
    }

    @Override
    public List<VisitDoctor> doctorQuery(Date startDate, Date endDate, Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<VisitDoctor> doctorQuery(Date startDate, Date endDate, Integer page) {
        return null;
    }

    @Override
    public List<VisitDoctor> doctorQuery(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<VisitDoctor> userQuery(Date startDate, Date endDate, Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<VisitDoctor> userQuery(Date startDate, Date endDate, Integer page) {
        return null;
    }

    @Override
    public List<VisitDoctor> userQuery(Date startDate, Date endDate) {
        return null;
    }

    @Override
    public List<VisitDoctor> userQueryUnPay(Long patientId) {
        return null;
    }
}
