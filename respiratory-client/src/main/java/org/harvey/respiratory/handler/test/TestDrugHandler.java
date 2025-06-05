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
        /*ignore*/
    }

    @Override
    public void del(Long drugId) {
        /*ignore*/
    }

    @Override
    public Drug queryById(Long id) {
        return null;
    }

    @Override
    public List<Drug> queryByName(String name, Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<Drug> queryByName(String name, Integer page) {
        return null;
    }

    @Override
    public List<Drug> queryByName(String name) {
        return null;
    }
}
