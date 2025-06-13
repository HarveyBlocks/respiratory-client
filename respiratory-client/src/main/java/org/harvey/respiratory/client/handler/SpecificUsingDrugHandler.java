package org.harvey.respiratory.client.handler;


import org.harvey.respiratory.client.ServerHandler;
import org.harvey.respiratory.client.pojo.dto.DrugDto;
import org.harvey.respiratory.client.pojo.entity.clinic.SpecificUsingDrugRecord;

import java.util.Date;
import java.util.List;

/**
 * 药物使用
 * /special-using-drug/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 20:57
 */
public interface SpecificUsingDrugHandler extends ServerHandler {

    /**
     * 删除某一问诊的某一具体用药
     * DeleteMapping("{id}")
     *
     * @param id 使用方法id
     */
    void del(Long id);

    /**
     * 删除某一问诊的某一具体用药
     * DeleteMapping("{visitDoctorId}/{drugId}")
     *
     * @param visitDoctorId 问诊id
     * @param drugId        药品id
     */
    void del(Long visitDoctorId, Long drugId);

    /**
     * 更新某一问诊的需要用药
     * PutMapping("/")
     *
     * @return 新的记录的id
     */
    Long updatePatientDrugHistory(SpecificUsingDrugRecord specificUsing);

    /**
     * 查询抓药信息
     * GetMapping("/visit/{id}")
     *
     * @param visitId 问诊号
     */
    List<DrugDto> queryDrugInVisit(Long visitId);

    /**
     * 查询病人既往用药史
     * GetMapping(value = {"history/drug/{id}/{name}"})
     *
     * @param patientId 病患id
     * @param name      药品名
     */
    List<DrugDto> queryPatientDrugHistoryByDrug(Long patientId, String name);

    /**
     * 查询病人既往用药史
     * GetMapping(value = "history/date/{id}/{start}/{end}")
     *
     * @param patientId 病患id
     * @param startDate 查询范围, 开始时间 yyyy-MM-dd
     * @param endDate   查询范围, 结束时间 yyyy-MM-dd
     */
    List<DrugDto> queryPatientDrugHistoryByDate(Long patientId, Date startDate, Date endDate);

    /**
     * 查询病人既往用药史
     * GetMapping(value =  "history/date/{id}/{start}")
     *
     * @param patientId 病患id
     * @param startDate 查询范围, 开始时间 yyyy-MM-dd
     */
    List<DrugDto> queryPatientDrugHistoryByDate(Long patientId, Date startDate);

    /**
     * 查询病人既往用药史
     * GetMapping(value = "history/date/{id}")
     *
     * @param patientId 病患id
     */
    List<DrugDto> queryPatientDrugHistoryByDate(Long patientId);


}
