package org.harvey.respiratory.handler;


import org.harvey.respiratory.ServerHandler;
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
public interface MedicalProviderHandler extends ServerHandler {
    /**
     * 登记医疗提供者信息
     * PostMapping("/register")
     *
     * @param medicalProvider 新增时, 除id, 和医保相关外, 字段都不得为null.
     * @return 返回插入后的id
     */
    Long register(MedicalProvider medicalProvider);

    /**
     * 更新医疗提供者信息
     * PutMapping("/")
     *
     * @param medicalProvider 更新字段可以为null, 表示保留原有; 也可以不为null, 即使字段值没有发生变化
     */
    void update(MedicalProvider medicalProvider);

    /**
     * 删除医疗提供者信息
     * DeleteMapping("/{id}")
     *
     * @param id 医疗提供者 id
     */
    void del(Long id);

    /**
     * 查询医疗提供者自己的信息
     * GetMapping("/self")
     */
    MedicalProvider querySelf();

    /**
     * GetMapping("/one/id/{id}")
     * "查询医疗提供者信息"
     *
     * @param id 医疗提供者 id
     */
    MedicalProvider queryOne(Long id);

    /**
     * 查询医疗提供者信息
     * GetMapping("/one/phone/{phoneNumber}")
     *
     * @param phoneNumber 医疗提供者电话
     */
    MedicalProvider queryByPhone(String phoneNumber);

    /**
     * 查询医疗提供者信息
     * GetMapping(value = {"/all/{form}/{name}/{page}/{limit}"})
     *
     * @param name  医生名, 模糊查询, 缺省则全查
     * @param form  医疗提供机构的id, 缺省则全查
     * @param page  页码, 从1开始, 缺省则是1
     * @param limit 页面长度
     */
    List<MedicalProvider> query(String name, Integer form, Integer page, Integer limit);

    /**
     * 查询医疗提供者信息
     * GetMapping(value = {"/all/{form}/{name}/{page}"})
     *
     * @param name 医生名, 模糊查询, 缺省则全查
     * @param form 医疗提供机构的id, 缺省则全查
     * @param page 页码, 从1开始, 缺省则是1
     */
    List<MedicalProvider> query(String name, Integer form, Integer page);

    /**
     * 查询医疗提供者信息
     * GetMapping(value = { "/all/{form}/{name}"})
     *
     * @param name 医生名, 模糊查询, 缺省则全查
     * @param form 医疗提供机构的id, 缺省则全查
     */
    List<MedicalProvider> query(String name, Integer form);

    /**
     * 查询医疗提供者信息
     * GetMapping(value = {
     * "/all/{form}"})
     *
     * @param name 医生名, 模糊查询, 缺省则全查
     */
    List<MedicalProvider> query(String name);

    /**
     * 查询医疗提供者信息
     * GetMapping(value = { "/all"})
     */
    List<MedicalProvider> query();

}
