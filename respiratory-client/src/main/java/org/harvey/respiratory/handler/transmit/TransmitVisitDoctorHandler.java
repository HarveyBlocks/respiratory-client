package org.harvey.respiratory.handler.transmit;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.ServerHandler;
import org.harvey.respiratory.handler.VisitDoctorHandler;
import org.harvey.respiratory.pojo.dto.TakeVisitNumberDto;
import org.harvey.respiratory.pojo.entity.clinic.VisitDoctor;

import java.util.Date;
import java.util.List;

/**
 * 医生进行问诊,就诊
 * /visit/api/
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-12 23:40
 */
public class TransmitVisitDoctorHandler implements ServerHandler, VisitDoctorHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("visit", "api");

    public TransmitVisitDoctorHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Long createVisitDoctorId(TakeVisitNumberDto takeVisitNumberDto) {
        return bind.executeSimply(HttpMethod.POST, uriJoin.add("take-number"), takeVisitNumberDto,
                new TypeReference<>() {
                }
        );
    }

    @Override
    public VisitDoctor getById(Long id) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add(id), new TypeReference<>() {
        });
    }

    @Override
    public List<VisitDoctor> doctorQuery(Date startDate, Date endDate, Integer page, Integer limit) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("doctor", "any", bind.formatDate(startDate), bind.formatDate(endDate), page, limit),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<VisitDoctor> doctorQuery(Date startDate, Date endDate, Integer page) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("doctor", "any", bind.formatDate(startDate), bind.formatDate(endDate), page),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<VisitDoctor> doctorQuery(Date startDate, Date endDate) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("doctor", "any", bind.formatDate(startDate), bind.formatDate(endDate)),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<VisitDoctor> userQuery(Date startDate, Date endDate, Integer page, Integer limit) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("user", "any", bind.formatDate(startDate), bind.formatDate(endDate), page, limit),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<VisitDoctor> userQuery(Date startDate, Date endDate, Integer page) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("user", "any", bind.formatDate(startDate), bind.formatDate(endDate), page),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<VisitDoctor> userQuery(Date startDate, Date endDate) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("user", "any", bind.formatDate(startDate), bind.formatDate(endDate)),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<VisitDoctor> userQueryUnPay(Long patientId) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("user", "un-pay", patientId),
                new TypeReference<>() {
                }
        );
    }
}
