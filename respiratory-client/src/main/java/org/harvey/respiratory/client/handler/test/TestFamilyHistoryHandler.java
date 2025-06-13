package org.harvey.respiratory.client.handler.test;

import org.harvey.respiratory.client.handler.FamilyHistoryHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.FamilyHistory;
import org.harvey.respiratory.client.pojo.entity.clinic.FamilyRelationshipEntity;
import org.harvey.respiratory.client.pojo.enums.clinic.FamilyRelationship;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return bind.randomLongId();
    }

    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId, Integer page, Integer limit) {
        List<FamilyHistory> list = bind.list(this::buildEntity, limit);
        list.forEach(e -> e.setPatientId(patientId));
        return list;
    }

    private FamilyHistory buildEntity() {
        return new FamilyHistory();
    }

    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId, Integer page) {
        return queryFamilyHistory(patientId, page, 10);
    }

    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId) {
        return queryFamilyHistory(patientId, 1, 10);
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(
            Long patientId, String diseaseName, Integer page, Integer limit) {
        List<FamilyHistory> list = bind.list(this::buildEntity, limit);
        list.forEach(e -> {
            e.setPatientId(patientId);
        });
        return list;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName, Integer page) {
        return queryFamilyHistoryByName(patientId, diseaseName, page, 10);
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName) {
        return queryFamilyHistoryByName(patientId, diseaseName, 1, 10);
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(
            Long patientId, Integer diseaseId, Integer page, Integer limit) {
        List<FamilyHistory> list = bind.list(this::buildEntity, limit);
        list.forEach(e -> {
            e.setPatientId(patientId);
            e.setDiseaseId(diseaseId);
        });
        return list;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId, Integer page) {
        return queryFamilyHistoryByDiseaseId(patientId, diseaseId, page, 10);
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId) {
        return queryFamilyHistoryByDiseaseId(patientId, diseaseId, 1, 10);
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId, Set<FamilyRelationship> relationships, Integer page, Integer limit) {
        List<FamilyHistory> list = bind.list(this::buildEntity, limit);
        FamilyRelationship[] array = relationships.toArray(FamilyRelationship[]::new);
        list.forEach(e -> {
            e.setPatientId(patientId);
            e.setFamilyRelationshipId(bind.chose(array).ordinal());
        });
        return list;
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId, Set<FamilyRelationship> relationships, Integer page) {
        return queryFamilyHistoryByRelationship(patientId, relationships, page, 10);
    }

    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(Long patientId, Set<FamilyRelationship> relationships) {
        return queryFamilyHistoryByRelationship(patientId, relationships, 1, 10);
    }

    @Override
    public List<FamilyRelationshipEntity> queryFamilyRelationship(Integer page, Integer limit) {

        return IntStream.range(0, limit).mapToObj(i -> buildRelationshipEntity()).collect(Collectors.toList());
    }

    private FamilyRelationshipEntity buildRelationshipEntity() {
        FamilyRelationship chose = bind.chose(FamilyRelationship.values());
        return new FamilyRelationshipEntity(bind.randomIntId(), chose.name(), bind.randomShortString(),
                chose.isFirstDegreeRelative()
        );
    }
}
