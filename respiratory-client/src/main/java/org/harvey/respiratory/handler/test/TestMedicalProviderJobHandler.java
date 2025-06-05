package org.harvey.respiratory.handler.test;

import org.harvey.respiratory.handler.MedicalProviderJobHandler;
import org.harvey.respiratory.pojo.entity.clinic.MedicalProviderJob;

import java.util.List;

/**
 * 医生职务
 * /medical/job/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public class TestMedicalProviderJobHandler implements TestHandler, MedicalProviderJobHandler {
    private final TestHandlerBind bind;

    public TestMedicalProviderJobHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Integer register(MedicalProviderJob job) {
        return null;
    }

    @Override
    public void update(MedicalProviderJob job) {

    }

    @Override
    public void del(Long id) {

    }

    @Override
    public MedicalProviderJob querySelf() {
        return null;
    }

    @Override
    public List<MedicalProviderJob> query(Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<MedicalProviderJob> query(Integer page) {
        return null;
    }

    @Override
    public List<MedicalProviderJob> query() {
        return null;
    }

    @Override
    public MedicalProviderJob queryOne(Integer job) {
        return null;
    }

    @Override
    public List<MedicalProviderJob> queryByName(String name) {
        return null;
    }
}
