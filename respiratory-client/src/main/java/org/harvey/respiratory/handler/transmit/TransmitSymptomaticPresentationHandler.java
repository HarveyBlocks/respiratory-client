package org.harvey.respiratory.handler.transmit;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.handler.SymptomaticPresentationHandler;
import org.harvey.respiratory.pojo.dto.SymptomaticPresentationDto;
import org.harvey.respiratory.pojo.entity.clinic.SymptomaticPresentation;
import org.harvey.respiratory.pojo.entity.clinic.SymptomaticPresentationDetail;
import org.harvey.respiratory.pojo.enums.clinic.SymptomaticPresentationType;
import org.harvey.respiratory.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

import java.util.List;

/**
 * 症状
 * /symptomatic-presentation/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 21:57
 */
public class TransmitSymptomaticPresentationHandler implements TransmitHandler, SymptomaticPresentationHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("symptomatic-presentation", "api");

    public TransmitSymptomaticPresentationHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public void del(Long id) {
        bind.executeSimply(
                HttpMethod.DELETE, uriJoin.add(id), new TypeReference<RestfulResult<NullPlaceholder>>() {
                });
    }


    @Override
    public Long updatePatientSymptomaticPresentation(SymptomaticPresentation symptomaticPresentation) {
        return bind.executeSimply(HttpMethod.PUT, uriJoin.add(), symptomaticPresentation, new TypeReference<>() {
        });
    }


    @Override
    public List<SymptomaticPresentationDetail> queryDetailsByType(SymptomaticPresentationType type) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("detail", type), new TypeReference<>() {
                });
    }


    @Override
    public List<SymptomaticPresentationDto> queryVisitDrug(Long visitId) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("visit", visitId), new TypeReference<>() {
                });
    }
}
