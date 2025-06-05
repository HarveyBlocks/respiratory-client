package org.harvey.respiratory.handler;

import org.harvey.respiratory.ServerHandler;
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
public interface MedicalProviderJobHandler extends ServerHandler {
    /**
     * 登记医生职业信息
     * PostMapping("/register")
     *
     * @param job 新增时, 除id, 和医保相关外, 字段都不得为null.
     * @return 回复新增后的职业id
     */
    Integer register(MedicalProviderJob job);

    /**
     * 更新医生职业信息
     * PutMapping("/")
     *
     * @param job 更新字段可以为null, 表示保留原有; 也可以不为null, 即使字段值没有发生变化
     */
    void update(MedicalProviderJob job);

    /**
     * 删除医疗提供者职业信息
     * DeleteMapping("/{id}")
     *
     * @param id 医疗提供职业 id
     */
    void del(Long id);

    /**
     * 查询医疗提供者自己的职业信息
     * GetMapping("/self")
     */
    MedicalProviderJob querySelf();

    /**
     * 查询医生职业信息
     * GetMapping({"/all/{page}/{limit}"})
     *
     * @param page  页码, 从1开始
     * @param limit 页面长度
     */
    List<MedicalProviderJob> query(Integer page, Integer limit);

    /**
     * 查询医生职业信息
     * GetMapping({ "/all/{page}/"})
     *
     * @param page 页码, 从1开始
     */
    List<MedicalProviderJob> query(Integer page);

    /**
     * 查询医生职业信息
     * GetMapping({"/all"})
     */
    List<MedicalProviderJob> query();

    /**
     * 查询医生职业信息
     * GetMapping("/one/{id}")
     *
     * @param job 医生职业的id
     */
    MedicalProviderJob queryOne(Integer job);

    /**
     * 依据名字查询医生职业信息
     * GetMapping("/name/{name}")
     *
     * @param name 依据姓名模糊查询医生职业
     */
    List<MedicalProviderJob> queryByName(String name);
}
