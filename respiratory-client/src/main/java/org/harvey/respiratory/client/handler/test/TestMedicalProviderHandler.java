package org.harvey.respiratory.client.handler.test;


import org.harvey.respiratory.client.handler.MedicalProviderHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.MedicalProvider;

import java.util.List;

/**
 * 医疗提供者和医疗提供机构
 * medical/provider/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public class TestMedicalProviderHandler implements TestHandler, MedicalProviderHandler {
    private final TestHandlerBind bind;

    public TestMedicalProviderHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Long register(MedicalProvider medicalProvider) {
        return bind.randomLongId();
    }

    @Override
    public void update(MedicalProvider medicalProvider) {
        bind.info("TestMedicalProviderHandler#update{}", medicalProvider);
    }

    @Override
    public void del(Long id) {
        bind.info("TestMedicalProviderHandler#del{}", id);
    }

    @Override
    public MedicalProvider querySelf() {
        return buildEntity();
    }

    private MedicalProvider buildEntity() {
        return new MedicalProvider();
    }

    @Override
    public MedicalProvider queryOne(Long id) {
        MedicalProvider entity = buildEntity();
        entity.setId(id);
        return entity;
    }

    @Override
    public MedicalProvider queryByPhone(String phoneNumber) {
        return buildEntity();
    }

    @Override
    public List<MedicalProvider> query(String name, Integer form, Integer page, Integer limit) {
        List<MedicalProvider> list = bind.list(this::buildEntity, limit);
        list.forEach(e -> {
            e.setName(name);
            e.setDepartmentId(form);
        });
        return list;
    }

    @Override
    public List<MedicalProvider> query(String name, Integer form, Integer page) {
        return query(name, form, page, 10);
    }

    @Override
    public List<MedicalProvider> query(String name, Integer form) {
        return query(name, form, 1, 10);
    }

    @Override
    public List<MedicalProvider> query(String name) {
        return query(name, null, 1, 10);
    }

    @Override
    public List<MedicalProvider> query() {
        return query(null, null, 1, 10);
    }
}
