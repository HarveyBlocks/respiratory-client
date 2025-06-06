package org.harvey.respiratory.handler;


import org.harvey.respiratory.ServerHandler;
import org.harvey.respiratory.pojo.entity.clinic.Drug;

import java.util.List;

/**
 * 具体药物
 * /drug/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 21:01
 */
public interface DrugHandler extends ServerHandler {

    /**
     * 增加某一药品
     * POST
     * /
     *
     * @param drug 药品
     */
    void register(Drug drug);

    /**
     * 删除某一药品
     * DeleteMapping("/{id}")
     *
     * @param drugId 药品id
     */
    void del(Integer drugId);


    /**
     * GetMapping("/{id}")
     * 查询药物具体信息
     *
     * @param id 药物id
     */
    Drug queryById(Integer id);


    /**
     * GetMapping(value = {"/name/{name}/{page}/{limit}"})
     * 用名字模糊查询药物具体信息
     *
     * @param name  药物名
     * @param page  页码, 从1开始  defaultValue = 1
     * @param limit 页长, 默认10
     */
    List<Drug> queryByName(String name, Integer page, Integer limit);


    /**
     * GetMapping(value = { "/name/{name}/{page}"})
     * 用名字模糊查询药物具体信息
     *
     * @param name 药物名
     * @param page 页码, 从1开始  defaultValue = 1
     */
    List<Drug> queryByName(String name, Integer page);


    /**
     * GetMapping(value = {"/name/{name}"})
     * 用名字模糊查询药物具体信息
     *
     * @param name 药物名
     */
    List<Drug> queryByName(String name);


}
