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
        bind.info("TestMedicalProviderJobHandler#register", job);
        return bind.randomIntId();
    }

    @Override
    public void update(MedicalProviderJob job) {
        bind.info("TestMedicalProviderJobHandler#update", job);
    }

    @Override
    public void del(Long id) {
        bind.info("TestMedicalProviderJobHandler#del", id);
    }

    @Override
    public MedicalProviderJob querySelf() {
        return buildEntity();
    }

    private MedicalProviderJob buildEntity() {
        return new MedicalProviderJob(
        );
    }

    @Override
    public List<MedicalProviderJob> query(Integer page, Integer limit) {
        return bind.list(this::buildEntity, limit);
    }

    @Override
    public List<MedicalProviderJob> query(Integer page) {
        return query(page, 10);
    }

    @Override
    public List<MedicalProviderJob> query() {
        return query(1, 10);
    }

    @Override
    public MedicalProviderJob queryOne(Integer job) {
        MedicalProviderJob entity = buildEntity();
        entity.setId(job);
        return entity;
    }

    @Override
    public List<MedicalProviderJob> queryByName(String name) {
        List<MedicalProviderJob> list = bind.list(this::buildEntity);
        list.forEach(e -> e.setName(name));
        return list;
    }
}
