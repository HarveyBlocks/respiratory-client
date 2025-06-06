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
        bind.info("TestMedicalProviderDepartmentHandler#register", department);
        return bind.randomIntId();
    }

    @Override
    public void update(MedicalProviderDepartment department) {
        bind.info("TestMedicalProviderDepartmentHandler#update", department);
    }

    @Override
    public void del(Long id) {
        bind.info("TestMedicalProviderDepartmentHandler#del", id);
    }

    @Override
    public MedicalProviderDepartment querySelf() {
        return buildEntity();
    }

    private MedicalProviderDepartment buildEntity() {
        return new MedicalProviderDepartment(
        );
    }

    @Override
    public List<MedicalProviderDepartment> query(Integer page, Integer limit) {
        return bind.list(this::buildEntity, limit);
    }

    @Override
    public List<MedicalProviderDepartment> query(Integer page) {
        return query(page, 10);
    }

    @Override
    public List<MedicalProviderDepartment> query() {
        return query(1, 10);
    }

    @Override
    public MedicalProviderDepartment queryOne(Integer department) {
        MedicalProviderDepartment entity = buildEntity();
        entity.setId(department);
        return entity;
    }

    @Override
    public List<MedicalProviderDepartment> queryByName(String name) {
        List<MedicalProviderDepartment> list = bind.list(this::buildEntity);
        list.forEach(e -> e.setName(name));
        return list;
    }
}
