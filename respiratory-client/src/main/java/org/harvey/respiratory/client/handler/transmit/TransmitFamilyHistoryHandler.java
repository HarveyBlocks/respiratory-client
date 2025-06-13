package org.harvey.respiratory.client.handler.transmit;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.client.handler.FamilyHistoryHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.FamilyHistory;
import org.harvey.respiratory.client.pojo.entity.clinic.FamilyRelationshipEntity;
import org.harvey.respiratory.client.pojo.enums.clinic.FamilyRelationship;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 家族史接口
 * /history/family/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 22:34
 */
public class TransmitFamilyHistoryHandler implements TransmitHandler, FamilyHistoryHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("history", "family", "api");

    public TransmitFamilyHistoryHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public Long register(FamilyHistory familyHistory) {
        return bind.executeSimply(HttpMethod.POST, uriJoin.add("register"), familyHistory, new TypeReference<>() {
        });
    }


    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId, Integer page, Integer limit) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add(patientId, page, limit), new TypeReference<>() {
        });
    }


    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId, Integer page) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add(patientId, page), new TypeReference<>() {
        });
    }


    @Override
    public List<FamilyHistory> queryFamilyHistory(Long patientId) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add(patientId), new TypeReference<>() {
        });
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(
            Long patientId, String diseaseName, Integer page, Integer limit) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("disease-name", patientId, diseaseName, page, limit),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName, Integer page) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("disease-name", patientId, diseaseName, page),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByName(Long patientId, String diseaseName) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("disease-name", patientId, diseaseName),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(
            Long patientId, Integer diseaseId, Integer page, Integer limit) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("disease-id", patientId, diseaseId, page, limit),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId, Integer page) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("disease-id", patientId, diseaseId, page),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByDiseaseId(Long patientId, Integer diseaseId) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("disease-id", patientId, diseaseId),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId, Set<FamilyRelationship> relationships, Integer page, Integer limit) {
        return bind.executeSimply(HttpMethod.GET,
                uriJoin.add("relationship", patientId, toParam(relationships), page, limit), new TypeReference<>() {
                }
        );
    }

    private String toParam(Set<FamilyRelationship> relationships) {
        return relationships.stream()
                .map(FamilyRelationship::ordinal)
                .map(Object::toString)
                .collect(Collectors.joining(","));
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(
            Long patientId, Set<FamilyRelationship> relationships, Integer page) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("relationship", patientId, toParam(relationships), page),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<FamilyHistory> queryFamilyHistoryByRelationship(Long patientId, Set<FamilyRelationship> relationships) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("relationship", patientId, toParam(relationships)),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<FamilyRelationshipEntity> queryFamilyRelationship(Integer page, Integer limit) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("relationship", "enum", page, limit),
                new TypeReference<>() {
                }
        );
    }
}
