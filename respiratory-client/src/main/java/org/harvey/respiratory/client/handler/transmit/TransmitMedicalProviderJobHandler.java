package org.harvey.respiratory.client.handler.transmit;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.client.handler.MedicalProviderJobHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.MedicalProviderJob;
import org.harvey.respiratory.client.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

import java.util.List;

/**
 * 医生职务
 * /medical/job/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public class TransmitMedicalProviderJobHandler implements TransmitHandler, MedicalProviderJobHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("medical", "job", "api");

    public TransmitMedicalProviderJobHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public Integer register(MedicalProviderJob job) {
        return bind.executeSimply(HttpMethod.POST, uriJoin.add("register"), job, new TypeReference<>() {
        });
    }


    @Override
    public void update(MedicalProviderJob job) {
        bind.executeSimply(HttpMethod.PUT, uriJoin.add(), job, new TypeReference<RestfulResult<NullPlaceholder>>() {
        });
    }


    @Override
    public void del(Long id) {
        bind.executeSimply(HttpMethod.DELETE, uriJoin.add(id), new TypeReference<RestfulResult<NullPlaceholder>>() {
        });
    }


    @Override
    public MedicalProviderJob querySelf() {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("self"), new TypeReference<>() {
        });
    }


    @Override
    public List<MedicalProviderJob> query(Integer page, Integer limit) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("all", page, limit), new TypeReference<>() {
        });
    }


    @Override
    public List<MedicalProviderJob> query(Integer page) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("all", page), new TypeReference<>() {
        });
    }


    @Override
    public List<MedicalProviderJob> query() {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("all"), new TypeReference<>() {
        });
    }


    @Override
    public MedicalProviderJob queryOne(Integer job) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("one", job), new TypeReference<>() {
        });
    }


    @Override
    public List<MedicalProviderJob> queryByName(String name) {
        return bind.executeSimply(HttpMethod.GET, uriJoin.add("name", name), new TypeReference<>() {
        });
    }
}
