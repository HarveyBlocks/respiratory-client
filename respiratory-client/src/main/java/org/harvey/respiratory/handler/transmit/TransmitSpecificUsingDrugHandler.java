package org.harvey.respiratory.handler.transmit;


import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.handler.SpecificUsingDrugHandler;
import org.harvey.respiratory.pojo.dto.DrugDto;
import org.harvey.respiratory.pojo.entity.clinic.SpecificUsingDrugRecord;
import org.harvey.respiratory.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

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
public class TransmitSpecificUsingDrugHandler implements TransmitHandler, SpecificUsingDrugHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("special-using-drug", "api");

    public TransmitSpecificUsingDrugHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public void del(Long id) {
        bind.executeSimply(HttpMethod.DELETE, uriJoin.add(id), new TypeReference<RestfulResult<NullPlaceholder>>() {
        });
    }


    @Override
    public void del(Long visitDoctorId, Long drugId) {
        bind.executeSimply(HttpMethod.DELETE, uriJoin.add(visitDoctorId, drugId),
                new TypeReference<RestfulResult<NullPlaceholder>>() {
                }
        );
    }


    @Override
    public Long updatePatientDrugHistory(SpecificUsingDrugRecord specificUsing) {
        return bind.executeSimply(HttpMethod.PUT, uriJoin.add(), specificUsing, new TypeReference<>() {
        });
    }


    @Override
    public List<DrugDto> queryDrugInVisit(Long visitId) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("visit", visitId), new TypeReference<>() {
        });
    }


    @Override
    public List<DrugDto> queryPatientDrugHistoryByDrug(Long patientId, String name) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("history", "drug", patientId, name),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId, Date startDate, Date endDate) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("history", "date", patientId, bind.formatDate(startDate), bind.formatDate(endDate)),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId, Date startDate) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("history", "date", patientId, bind.formatDate(startDate)),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<DrugDto> queryPatientDrugHistoryByDate(Long patientId) {
        return bind.executeSimply(
                HttpMethod.GET,
                uriJoin.add("history", "date", patientId),
                new TypeReference<>() {
                }
        );
    }
}
