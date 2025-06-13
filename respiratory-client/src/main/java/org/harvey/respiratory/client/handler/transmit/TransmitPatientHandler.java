package org.harvey.respiratory.client.handler.transmit;


import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.client.handler.PatientHandler;
import org.harvey.respiratory.client.pojo.dto.PatientDto;
import org.harvey.respiratory.client.pojo.entity.clinic.Patient;
import org.harvey.respiratory.client.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

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
public class TransmitPatientHandler implements TransmitHandler, PatientHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("patient", "api");

    public TransmitPatientHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public Long registerPatientInformation(PatientDto patientDto) {
        return bind.executeSimply(HttpMethod.POST, uriJoin.add("register"), patientDto, new TypeReference<>() {
        });
    }


    @Override
    public void delPatientInformation(Long patientId) {
        bind.executeSimply(
                HttpMethod.DELETE, uriJoin.add(patientId), new TypeReference<RestfulResult<NullPlaceholder>>() {
                });
    }


    @Override
    public void update(Patient patient) {
        bind.executeSimply(HttpMethod.PUT, uriJoin.add(), patient, new TypeReference<RestfulResult<NullPlaceholder>>() {
        });
    }


    @Override
    public List<PatientDto> querySelfPatients(Integer page, Integer limit) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("self", page, limit), new TypeReference<>() {
        });
    }


    @Override
    public List<PatientDto> querySelfPatients(Integer page) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("self", page), new TypeReference<>() {
        });
    }


    @Override
    public List<PatientDto> querySelfPatients() {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("self"), new TypeReference<>() {
        });
    }


    @Override
    public PatientDto queryPatientByHealthcareId(String healthcareCode) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("healthcare", healthcareCode), new TypeReference<>() {
        });
    }


    @Override
    public PatientDto queryPatientByPatientId(Long patientId) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add(patientId), new TypeReference<>() {
        });
    }


    @Override
    public PatientDto queryByIdentity(String cardId) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("identityCardId", cardId), new TypeReference<>() {
        });
    }
}
