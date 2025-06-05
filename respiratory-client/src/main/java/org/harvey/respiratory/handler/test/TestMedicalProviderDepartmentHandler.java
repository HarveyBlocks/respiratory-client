package org.harvey.respiratory.handler.test;


import org.harvey.respiratory.handler.MedicalProviderDepartmentHandler;
import org.harvey.respiratory.pojo.entity.clinic.MedicalProviderDepartment;

import java.util.List;

/**
 * 医疗提供者和医院科室
 * /medical/department/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public class TestMedicalProviderDepartmentHandler implements TestHandler, MedicalProviderDepartmentHandler {
    private final TestHandlerBind bind;

    public TestMedicalProviderDepartmentHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Integer register(MedicalProviderDepartment department) {
        return null;
    }

    @Override
    public void update(MedicalProviderDepartment department) {

    }

    @Override
    public void del(Long id) {

    }

    @Override
    public MedicalProviderDepartment querySelf() {
        return null;
    }

    @Override
    public List<MedicalProviderDepartment> query(Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<MedicalProviderDepartment> query(Integer page) {
        return null;
    }

    @Override
    public List<MedicalProviderDepartment> query() {
        return null;
    }

    @Override
    public MedicalProviderDepartment queryOne(Integer department) {
        return null;
    }

    @Override
    public List<MedicalProviderDepartment> queryByName(String name) {
        return null;
    }
}
