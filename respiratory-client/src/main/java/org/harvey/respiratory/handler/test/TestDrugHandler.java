package org.harvey.respiratory.handler.test;


import org.harvey.respiratory.handler.DrugHandler;
import org.harvey.respiratory.pojo.entity.clinic.Drug;

import java.util.List;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-06 01:23
 */
public class TestDrugHandler implements DrugHandler, TestHandler {
    private final TestHandlerBind bind;

    public TestDrugHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public void register(Drug drug) {
        bind.info("TestDrugHandler#register{}", drug);
    }

    @Override
    public void del(Integer drugId) {
        bind.info("TestDrugHandler#del{}", drugId);
    }

    @Override
    public Drug queryById(Integer id) {
        Drug drug = buildDrug();
        drug.setId(id);
        return drug;
    }

    private Drug buildDrug() {
        return new Drug(
                bind.uniform(1, Integer.MAX_VALUE),
                bind.randomString(20, 50),
                bind.randomString(20, 50),
                bind.uniform(200, 10000),
                bind.randomString(50, 250),
                bind.randomString(20, 250),
                bind.randomString(20, 250),
                bind.randomString(20, 250),
                bind.randomString(20, 250),
                bind.uniform(20, 1000)
        );
    }

    @Override
    public List<Drug> queryByName(String name, Integer page, Integer limit) {
        List<Drug> list = bind.list(this::buildDrug, limit);
        list.forEach(d -> d.setName(name));
        return list;
    }

    @Override
    public List<Drug> queryByName(String name, Integer page) {
        return queryByName(name, page, 10);
    }

    @Override
    public List<Drug> queryByName(String name) {
        return queryByName(name, 2, 10);
    }
}
