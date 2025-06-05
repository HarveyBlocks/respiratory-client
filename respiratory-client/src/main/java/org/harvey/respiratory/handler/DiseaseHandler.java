package org.harvey.respiratory.handler;

import org.harvey.respiratory.ServerHandler;
import org.harvey.respiratory.pojo.entity.clinic.Disease;

import java.util.List;

/**
 * 疾病
 * /disease/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 22:26
 */
public interface DiseaseHandler extends ServerHandler {

    /**
     * 添加某一疾病
     * /save
     * POST
     *
     * @param disease 疾病
     * @return 插入后的id
     */
    Integer register(Disease disease);

    /**
     * 删除某一疾病
     * /{id}
     * DELETE
     *
     * @param diseaseId 疾病id
     */
    void del(Integer diseaseId);

    /**
     * 查询问诊号下所有疾病信息
     * GET
     * /visit/{id}
     *
     * @param visitId 问诊号
     */
    List<Disease> queryDiseases(Long visitId);


    /**
     * /{id}
     * 查询疾病具体信息
     * GET
     *
     * @param id 药物id
     */
    Disease queryById(Integer id);

    /**
     * "/name/{name}/{page}/{limit}"
     * 用名字模糊查询疾病具体信息
     * GET
     *
     * @param name  疾病名
     * @param page  页码, 从1开始, 默认1
     * @param limit 页长, 默认10
     */
    List<Disease> queryByName(String name, Integer page, Integer limit);


    /**
     * "/name/{name}/{page}"
     * 用名字模糊查询疾病具体信息
     * GET
     *
     * @param name 疾病名
     * @param page 页码, 从1开始, 默认1
     */
    List<Disease> queryByName(String name, Integer page);


    /**
     * "/name/{name}"
     * 用名字模糊查询疾病具体信息
     * GET
     *
     * @param name 疾病名
     */
    List<Disease> queryByName(String name);


}
