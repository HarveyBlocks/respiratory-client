package org.harvey.respiratory.client.handler;


import org.harvey.respiratory.client.ServerHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.MedicalProviderForm;

import java.util.List;

/**
 * 医疗提供者和医疗提供机构
 * /medical/form/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public interface MedicalProviderFormHandler extends ServerHandler {

    /**
     * 登记医疗提供机构信息
     * PostMapping("/register")
     *
     * @param form 新增时, 除id, 和医保相关外, 字段都不得为null.
     */
    Integer register(MedicalProviderForm form);

    /**
     * 更新医疗提供机构信息
     * PutMapping("/")
     *
     * @param form 更新字段可以为null, 表示保留原有; 也可以不为null, 即使字段值没有发生变化
     */
    void update(MedicalProviderForm form);

    /**
     * 删除医疗提供机构信息
     * DeleteMapping("/{id}")
     *
     * @param id 医疗提供机构id
     */
    void del(Long id);

    /**
     * 查询医疗提供者自己的机构信息
     * GetMapping("/self")
     */
    MedicalProviderForm querySelf();

    /**
     * 查询医疗提供机构信息
     * GetMapping({"/all/{page}/{limit}"})
     *
     * @param page  页码, 从1开始
     * @param limit 页面长度
     */
    List<MedicalProviderForm> query(Integer page, Integer limit);

    /**
     * 查询医疗提供机构信息
     * GetMapping({"/all/{page}/"})
     *
     * @param page 页码, 从1开始
     */
    List<MedicalProviderForm> query(Integer page);

    /**
     * 查询医疗提供机构信息
     * GetMapping({"/all"})
     */
    List<MedicalProviderForm> query();

    /**
     * 查询医疗提供机构信息
     * GetMapping("/one/{id}")
     *
     * @param form 医疗提供机构的id
     */
    MedicalProviderForm queryOne(Integer form);

    /**
     * 依据名字查询医疗提供机构信息
     * GetMapping("/name/{name}")
     *
     * @param name 依据姓名模糊查询医疗提供机构
     */
    List<MedicalProviderForm> queryByName(String name);

    /**
     * 依据地址查询医疗提供机构信息
     * GetMapping("/address/{address}")
     *
     * @param address 依据地址模糊查询医疗提供机构
     */
    List<MedicalProviderForm> queryByAddress(String address);
}
