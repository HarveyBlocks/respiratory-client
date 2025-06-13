package org.harvey.respiratory.client.handler;


import org.harvey.respiratory.client.ServerHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.MedicalProviderDepartment;

import java.util.List;

/**
 * 医疗提供者和医院科室
 * /medical/department/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public interface MedicalProviderDepartmentHandler extends ServerHandler {

    /**
     * 登记医院科室信息
     * PostMapping("/register")
     *
     * @param department 新增时, 除id, 和医保相关外, 字段都不得为null.
     */
    Integer register(MedicalProviderDepartment department);

    /**
     * 更新医院科室信息
     * PutMapping("/")
     *
     * @param department 更新字段可以为null, 表示保留原有; 也可以不为null, 即使字段值没有发生变化
     */
    void update(MedicalProviderDepartment department);

    /**
     * 删除医疗提供者信息
     * DeleteMapping("/{id}")
     *
     * @param id 医疗提供科室 id
     */
    void del(Long id);

    /**
     * 查询医疗提供者自己的科室信息
     * GetMapping("/self")
     */
    MedicalProviderDepartment querySelf();

    /**
     * 查询医院科室信息
     * GetMapping({"/all/{page}/{limit}"})
     *
     * @param page  页码, 从1开始
     * @param limit 页面长度
     */
    List<MedicalProviderDepartment> query(Integer page, Integer limit);

    /**
     * 查询医院科室信息
     * GetMapping({ "/all/{page}/"})
     *
     * @param page 页码, 从1开始
     */
    List<MedicalProviderDepartment> query(Integer page);

    /**
     * 查询医院科室信息
     * GetMapping({"/all"})
     */
    List<MedicalProviderDepartment> query();

    /**
     * 查询医院科室信息
     * GetMapping("/one/{id}")
     *
     * @param department 医院科室的id
     */
    MedicalProviderDepartment queryOne(Integer department);

    /**
     * 依据名字查询医院科室信息
     * GetMapping("/name/{name}")
     *
     * @param name 依据姓名模糊查询医院科室
     */
    List<MedicalProviderDepartment> queryByName(String name);
}
