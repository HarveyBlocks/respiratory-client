package org.harvey.respiratory.handler.test;

import org.harvey.respiratory.handler.FamilyHistoryHandler;
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
public class TestFamilyHistoryHandler implements TestHandler, FamilyHistoryHandler {
    private final TestHandlerBind bind;

    public TestFamilyHistoryHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Long register(FamilyHistory familyHistory) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId, Integer page, Integer limit) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId, Integer page) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(
            Long patientId,
            String diseaseName,
            Integer page,
            Integer limit) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName, Integer page) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(
            Long patientId,
            Integer diseaseId,
            Integer page,
            Integer limit) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId, Integer page) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId,
            Set<FamilyRelationship> relationships,
            Integer page,
            Integer limit) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId,
            Set<FamilyRelationship> relationships,
            Integer page) {
        return null;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(Long patientId, Set<FamilyRelationship> relationships) {
        return null;
    }

    @Override
    public List<FamilyRelationshipEntity> queryFamilyRelationship(Integer page, Integer limit) {
        return null;
    }
}
