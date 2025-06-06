package org.harvey.respiratory.handler.test;


import org.harvey.respiratory.handler.MedicalProviderFormHandler;
import org.harvey.respiratory.pojo.entity.clinic.MedicalProviderForm;

import java.util.List;

/**
 * 医疗提供者和医疗提供机构
 * /medical/form/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public class TestMedicalProviderFormHandler implements TestHandler, MedicalProviderFormHandler {
    private final TestHandlerBind bind;

    public TestMedicalProviderFormHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Integer register(MedicalProviderForm form) {
        bind.info("TestMedicalProviderFormHandler#register", form);
        return bind.randomIntId();
    }

    @Override
    public void update(MedicalProviderForm form) {
        bind.info("TestMedicalProviderFormHandler#update", form);
    }

    @Override
    public void del(Long id) {
        bind.info("TestMedicalProviderFormHandler#del", id);
    }

    @Override
    public MedicalProviderForm querySelf() {
        return buildEntity();
    }

    private MedicalProviderForm buildEntity() {
        return new MedicalProviderForm(
        );
    }

    @Override
    public List<MedicalProviderForm> query(Integer page, Integer limit) {
        return bind.list(this::buildEntity, limit);
    }

    @Override
    public List<MedicalProviderForm> query(Integer page) {
        return query(page, 10);
    }

    @Override
    public List<MedicalProviderForm> query() {
        return query(1, 10);
    }

    @Override
    public MedicalProviderForm queryOne(Integer form) {
        MedicalProviderForm entity = buildEntity();
        entity.setId(form);
        return entity;
    }

    @Override
    public List<MedicalProviderForm> queryByName(String name) {
        List<MedicalProviderForm> list = bind.list(this::buildEntity);
        list.forEach(e -> e.setName(name));
        return list;
    }

    @Override
    public List<MedicalProviderForm> queryByAddress(String address) {
        List<MedicalProviderForm> list = bind.list(this::buildEntity);
        list.forEach(e -> e.setAddress(address));
        return list;
    }
}
