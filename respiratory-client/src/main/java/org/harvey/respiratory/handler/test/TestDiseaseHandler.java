package org.harvey.respiratory.handler.test;

import org.harvey.respiratory.handler.DiseaseHandler;
import org.harvey.respiratory.pojo.entity.clinic.Disease;

import java.util.List;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-05 23:05
 */
public class TestDiseaseHandler implements DiseaseHandler, TestHandler {
    private final TestHandlerBind bind;

    public TestDiseaseHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Integer register(Disease disease) {
        return null;
    }

    @Override
    public void del(Integer diseaseId) {
        /*ignore*/
    }

    private Disease buildDisease() {
        return new Disease(bind.randomIntId(), bind.randomString(13, 50), bind.randomString(50, 250));
    }

    @Override
    public List<Disease> queryDiseases(Long visitId) {
        return bind.list(this::buildDisease);
    }


    @Override
    public Disease queryById(Integer id) {
        Disease disease = buildDisease();
        disease.setId(id);
        return disease;
    }

    @Override
    public List<Disease> queryByName(String name, Integer page, Integer limit) {
        return bind.list(() -> {
            Disease disease = this.buildDisease();
            disease.setName(name);
            return disease;
        }, limit);
    }

    @Override
    public List<Disease> queryByName(String name, Integer page) {
        return bind.list(() -> {
            Disease disease = this.buildDisease();
            disease.setName(name);
            return disease;
        }, 10);
    }

    @Override
    public List<Disease> queryByName(String name) {
        return bind.list(() -> {
            Disease disease = this.buildDisease();
            disease.setName(name);
            return disease;
        }, 10);
    }
}
