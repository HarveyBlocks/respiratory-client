package org.harvey.respiratory.client.handler.transmit;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.client.handler.DiseaseHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.Disease;
import org.harvey.respiratory.client.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

import java.util.List;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-05 23:05
 */
public class TransmitDiseaseHandler implements DiseaseHandler, TransmitHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("disease", "api");

    public TransmitDiseaseHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public Integer register(Disease disease) {
        return bind.executeSimply(HttpMethod.POST, uriJoin.add("save"), disease, new TypeReference<>() {
        });
    }

    @Override
    public void del(Integer diseaseId) {
        TypeReference<RestfulResult<NullPlaceholder>> typeReference = new TypeReference<>() {
        };
        bind.executeSimply(HttpMethod.DELETE, uriJoin.add(diseaseId), typeReference);
    }

    @Override
    public List<Disease> queryDiseases(Long visitId) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("visit", visitId), new TypeReference<>() {
        });
    }

    @Override
    public Disease queryById(Integer id) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add(id), new TypeReference<>() {
        });
    }

    @Override
    public List<Disease> queryByName(String name, Integer page, Integer limit) {

        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("name", name, page, limit), new TypeReference<>() {
                });
    }

    @Override
    public List<Disease> queryByName(String name, Integer page) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("name", name, page), new TypeReference<>() {
        });
    }

    @Override
    public List<Disease> queryByName(String name) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("name", name), new TypeReference<>() {
        });
    }
}
