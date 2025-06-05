package org.harvey.respiratory.handler.transmit;


import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.handler.MedicalProviderFormHandler;
import org.harvey.respiratory.pojo.entity.clinic.MedicalProviderForm;
import org.harvey.respiratory.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

import java.util.List;

/**
 * 医疗提供者和医疗提供机构
 * /medical/form/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public class TransmitMedicalProviderFormHandler implements TransmitHandler, MedicalProviderFormHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("medical", "form", "api");

    public TransmitMedicalProviderFormHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public Integer register(MedicalProviderForm form) {
        return bind.executeSimply(
                HttpMethod.POST, uriJoin.add("register"), form,
                new TypeReference<>() {
                }
        );
    }


    @Override
    public void update(MedicalProviderForm form) {
        bind.executeSimply(
                HttpMethod.PUT, uriJoin.add(), form,
                new TypeReference<RestfulResult<NullPlaceholder>>() {
                }
        );
    }


    @Override
    public void del(Long id) {
        bind.executeSimply(
                HttpMethod.DELETE, uriJoin.add(id),
                new TypeReference<RestfulResult<NullPlaceholder>>() {
                }
        );
    }


    @Override
    public MedicalProviderForm querySelf() {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("self"),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderForm> query(Integer page, Integer limit) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all", page, limit),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderForm> query(Integer page) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all", page),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderForm> query() {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all"),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public MedicalProviderForm queryOne(Integer form) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("one", form),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderForm> queryByName(String name) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("name", name),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderForm> queryByAddress(String address) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("address", address),
                new TypeReference<>() {
                }
        );
    }
}
