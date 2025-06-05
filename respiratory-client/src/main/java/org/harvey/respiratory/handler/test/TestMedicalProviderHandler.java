package org.harvey.respiratory.handler.test;


import org.harvey.respiratory.handler.MedicalProviderHandler;
import org.harvey.respiratory.pojo.entity.clinic.MedicalProvider;

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
        return null;
    }

    @Override
    public void update(MedicalProvider medicalProvider) {

    }

    @Override
    public void del(Long id) {

    }

    @Override
    public MedicalProvider querySelf() {
        return null;
    }

    @Override
    public MedicalProvider queryOne(Long id) {
        return null;
    }

    @Override
    public MedicalProvider queryByPhone(String phoneNumber) {
        return null;
    }

    @Override
    public List<MedicalProvider> query(String name, Integer form, Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<MedicalProvider> query(String name, Integer form, Integer page) {
        return null;
    }

    @Override
    public List<MedicalProvider> query(String name, Integer form) {
        return null;
    }

    @Override
    public List<MedicalProvider> query(String name) {
        return null;
    }

    @Override
    public List<MedicalProvider> query() {
        return null;
    }
}
