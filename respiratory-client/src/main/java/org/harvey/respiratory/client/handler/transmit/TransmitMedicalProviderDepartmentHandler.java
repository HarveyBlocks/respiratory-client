package org.harvey.respiratory.client.handler.transmit;


import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.client.handler.MedicalProviderDepartmentHandler;
import org.harvey.respiratory.client.pojo.entity.clinic.MedicalProviderDepartment;

import java.util.List;

/**
 * 医疗提供者和医院科室
 * /medical/department/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 23:20
 */
public class TransmitMedicalProviderDepartmentHandler implements TransmitHandler, MedicalProviderDepartmentHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("medical", "department", "api");

    public TransmitMedicalProviderDepartmentHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }


    @Override
    public Integer register(MedicalProviderDepartment department) {
        return bind.executeSimply(
                HttpMethod.POST, uriJoin.add("register"), department,
                new TypeReference<>() {
                }
        );
    }


    @Override
    public void update(MedicalProviderDepartment department) {
        bind.executeSimply(
                HttpMethod.PUT, uriJoin.add(), department,
                new TypeReference<>() {
                }
        );
    }


    @Override
    public void del(Long id) {
        bind.executeSimply(
                HttpMethod.DELETE, uriJoin.add(id),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public MedicalProviderDepartment querySelf() {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("self"),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderDepartment> query(Integer page, Integer limit) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all", page, limit),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderDepartment> query(Integer page) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all", page),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderDepartment> query() {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("all"),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public MedicalProviderDepartment queryOne(Integer department) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("one", department),
                new TypeReference<>() {
                }
        );
    }


    @Override
    public List<MedicalProviderDepartment> queryByName(String name) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("name", name),
                new TypeReference<>() {
                }
        );
    }
}
