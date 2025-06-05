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
        return null;
    }

    @Override
    public void update(MedicalProviderForm form) {

    }

    @Override
    public void del(Long id) {

    }

    @Override
    public MedicalProviderForm querySelf() {
        return null;
    }

    @Override
    public List<MedicalProviderForm> query(Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<MedicalProviderForm> query(Integer page) {
        return null;
    }

    @Override
    public List<MedicalProviderForm> query() {
        return null;
    }

    @Override
    public MedicalProviderForm queryOne(Integer form) {
        return null;
    }

    @Override
    public List<MedicalProviderForm> queryByName(String name) {
        return null;
    }

    @Override
    public List<MedicalProviderForm> queryByAddress(String address) {
        return null;
    }
}
