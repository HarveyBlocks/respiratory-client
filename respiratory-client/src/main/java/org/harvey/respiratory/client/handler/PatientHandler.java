package org.harvey.respiratory.client.handler;


import org.harvey.respiratory.client.ServerHandler;
import org.harvey.respiratory.client.pojo.dto.PatientDto;
import org.harvey.respiratory.client.pojo.entity.clinic.Patient;

import java.util.List;

/**
 * 患者与医保
 * 如果一个系统的使用者含有多个患者的记录
 * /patient/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 22:07
 */
public interface PatientHandler extends ServerHandler {

    /**
     * 登记患者信息+医保信息, 响应患者id
     * PostMapping("/register")
     *
     * @param patientDto 新增时, 除id, 和医保相关外, 字段都不得为null.
     * @return 患者id
     */
    Long registerPatientInformation(PatientDto patientDto);

    /**
     * 删除Patient, 实际上是删除这个用户和patient的联系
     * DeleteMapping("/{id}")
     *
     * @param patientId 病患 id
     */
    void delPatientInformation(Long patientId);

    /**
     * 更新患者信息, 不会更新医保信息
     * PutMapping("/")
     *
     * @param patient 更新字段可以为null, 表示保留原有; 也可以不为null, 即使字段值没有发生变化. 一般不把非null字段重新更新为null.
     */
    void update(Patient patient);

    /**
     * 查询当前用户的所有患者
     * GetMapping(value = {"/self/{page}/{limit}"})
     *
     * @param page  查询页码
     * @param limit 查询页长
     */
    List<PatientDto> querySelfPatients(Integer page, Integer limit);

    /**
     * 查询当前用户的所有患者
     * GetMapping(value = { "/self/{page}"})
     *
     * @param page 查询页码
     */
    List<PatientDto> querySelfPatients(Integer page);

    /**
     * 查询当前用户的所有患者
     * GetMapping(value = {"/self"})
     */
    List<PatientDto> querySelfPatients();

    /**
     * 依据医保号查询
     * GetMapping("/healthcare/{code}")
     *
     * @param healthcareCode 医保号
     */
    PatientDto queryPatientByHealthcareId(String healthcareCode);

    /**
     * 依据患者id查询
     * GetMapping("/{id}")
     *
     * @param patientId 病患id
     */
    PatientDto queryPatientByPatientId(Long patientId);

    /**
     * 依据身份证号吗查询
     * GetMapping("/identityCardId/{cardId}")
     *
     * @param cardId 身份证号
     */
    PatientDto queryByIdentity(String cardId);


}
