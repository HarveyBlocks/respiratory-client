package org.harvey.respiratory.handler.transmit;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.handler.DrugHandler;
import org.harvey.respiratory.pojo.entity.clinic.Drug;
import org.harvey.respiratory.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

import java.util.List;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-06 01:23
 */
public class TransmitDrugHandler implements DrugHandler, TransmitHandler {
    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("drug", "api");

    public TransmitDrugHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public void register(Drug drug) {
        bind.executeSimply(
                HttpMethod.POST, uriJoin.add(), drug,
                new TypeReference<RestfulResult<NullPlaceholder>>() {
                }
        );
    }

    @Override
    public void del(Integer drugId) {
        bind.executeSimply(
                HttpMethod.DELETE, uriJoin.add(drugId),
                new TypeReference<RestfulResult<NullPlaceholder>>() {
                }
        );
    }

    @Override
    public Drug queryById(Integer id) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add(id),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<Drug> queryByName(String name, Integer page, Integer limit) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("name", name, page, limit),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<Drug> queryByName(String name, Integer page) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("name", name, page),
                new TypeReference<>() {
                }
        );
    }

    @Override
    public List<Drug> queryByName(String name) {
        return bind.executeSimply(
                HttpMethod.GET, uriJoin.add("name", name),
                new TypeReference<>() {
                }
        );
    }
}
