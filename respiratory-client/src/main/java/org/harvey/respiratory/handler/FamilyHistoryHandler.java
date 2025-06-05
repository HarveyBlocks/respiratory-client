package org.harvey.respiratory.handler;

import org.harvey.respiratory.ServerHandler;
import org.harvey.respiratory.pojo.entity.clinic.FamilyHistory;
import org.harvey.respiratory.pojo.entity.clinic.FamilyRelationshipEntity;
import org.harvey.respiratory.pojo.enums.clinic.FamilyRelationship;

import java.util.List;
import java.util.Set;

/**
 * 家族史接口
 * /history/family/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 22:34
 */
public interface FamilyHistoryHandler extends ServerHandler {

    /**
     * 家族病史, 用疾病名模糊查询
     * PostMapping(value = {"/register"})
     *
     * @param familyHistory 新增的entity
     */
    Long register(FamilyHistory familyHistory);

    /**
     * 家族病史, 用patientId糊查询
     * GetMapping(value = {"/{patientId}/{page}/{limit}"})
     *
     * @param patientId 病患id
     * @param page      页码, 从1开始, 默认1
     * @param limit     页长
     */
    List<FamilyHistory> queryFamilyHistory(Long patientId, Integer page, Integer limit);

    /**
     * 家族病史, 用patientId糊查询
     * GetMapping(value = { "/{patientId/{page}/"})
     *
     * @param patientId 病患id
     * @param page      页码, 从1开始, 默认1
     */
    List<FamilyHistory> queryFamilyHistory(Long patientId, Integer page);

    /**
     * 家族病史, 用patientId糊查询
     * GetMapping(value = { "/{patientId}"})
     *
     * @param patientId 病患id
     */
    List<FamilyHistory> queryFamilyHistory(Long patientId);

    /**
     * 家族病史, 用疾病名模糊查询
     * GetMapping(value = {"/disease-name/{patientId}/{diseaseName}/{page}/{limit}"})
     *
     * @param patientId   病患id
     * @param diseaseName 疾病名模糊查询
     * @param page        页码, 从1开始
     * @param limit       页长
     */
    List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName, Integer page, Integer limit);

    /**
     * 家族病史, 用疾病名模糊查询
     * GetMapping(value = {"/disease-name/{patientId}/{diseaseName}/{page}/"})
     *
     * @param patientId   病患id
     * @param diseaseName 疾病名模糊查询
     * @param page        页码, 从1开始
     */
    List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName, Integer page);

    /**
     * 家族病史, 用疾病名模糊查询
     * GetMapping(value = {"/disease-name/{patientId}/{diseaseName}"})
     *
     * @param patientId   病患id
     * @param diseaseName 疾病名模糊查询
     */
    List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName);

    /**
     * 家族病史, 用疾病id查询
     * GetMapping(value = {"/disease-id/{patientId}/{diseaseId}/{page}/{limit}"})
     *
     * @param patientId 病患id
     * @param diseaseId 疾病id
     * @param page      页码, 从1开始
     * @param limit     页长
     */
    List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId, Integer page, Integer limit);

    /**
     * 家族病史, 用疾病id查询
     * GetMapping(value = {"/disease-id/{patientId}/{diseaseId}/{page}/"})
     *
     * @param patientId 病患id
     * @param diseaseId 疾病id
     * @param page      页码, 从1开始
     */
    List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId, Integer page);

    /**
     * 家族病史, 用疾病id查询
     * GetMapping(value = {"/disease-id/{patientId}/{diseaseId}"})
     *
     * @param patientId 病患id
     * @param diseaseId 疾病id
     */
    List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId);

    /**
     * 家族病史, 用成员关系查询
     * GetMapping(value = {"/relationship/{patientId}/{relationship}/{page}/{limit}"})
     *
     * @param patientId     病患名id
     * @param relationships 病患关系数组的id序列.用逗号分割, 如{@code 1,2,3}
     * @param page          页码, 从1开始
     * @param limit         页长
     */
    List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId, Set<FamilyRelationship> relationships, Integer page, Integer limit);

    /**
     * 家族病史, 用成员关系查询
     * GetMapping(value = {"/relationship/{patientId}/{relationship}/{page}/"})
     *
     * @param patientId     病患名id
     * @param relationships 病患关系数组的id序列.用逗号分割, 如{@code 1,2,3}
     * @param page          页码, 从1开始
     */
    List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId, Set<FamilyRelationship> relationships, Integer page);

    /**
     * 家族病史, 用成员关系查询
     * GetMapping(value = { "/relationship/{patientId}/{relationship}"})
     *
     * @param patientId     病患名id
     * @param relationships 病患关系数组的id序列.用逗号分割, 如{@code 1,2,3}
     */
    List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId, Set<FamilyRelationship> relationships);


    /**
     * 家族病史, 用成员关系查询
     * GetMapping(value = {"relationship/enum/{page}/{limit}"})
     *
     * @param page  页码, 从1开始
     * @param limit 页长
     */
    List<FamilyRelationshipEntity> queryFamilyRelationship(
            Integer page, Integer limit);
}
