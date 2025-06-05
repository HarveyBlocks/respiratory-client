package org.harvey.respiratory.handler.transmit;


import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.handler.MedicalProviderHandler;
import org.harvey.respiratory.pojo.entity.clinic.MedicalProvider;
import org.harvey.respiratory.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

import java.util.List;

/**
 * 医疗提供者和医疗提供机构
 * medical/provider/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public class TransmitMedicalProviderHandler implements TransmitHandler, MedicalProviderHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("medical", "provider", "api");

    public TransmitMedicalProviderHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public Long register(MedicalProvider medicalProvider) {
        return bind.executeSimply(
                HttpMethod.POST, uriJoin.add("register"), medicalProvider,
                new TypeReference<>() {
                }
        );
    }


    @Override
    public void update(MedicalProvider medicalProvider) {
        bind.executeSimply(
                HttpMethod.PUT, uriJoin.add(), medicalProvider,
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
    public MedicalProvider querySelf() {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("self"),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public MedicalProvider queryOne(Long id) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("one", "id", id),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public MedicalProvider queryByPhone(String phoneNumber) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("one", "phone", phoneNumber),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProvider> query(String name, Integer form, Integer page, Integer limit) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all", form, name, page, limit),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProvider> query(String name, Integer form, Integer page) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all", form, name, page),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProvider> query(String name, Integer form) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all", form, name),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProvider> query(String name) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all", name),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProvider> query() {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all"),
                new TypeReference<>() {
                }
        );
    }
}
