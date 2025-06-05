package org.harvey.respiratory.handler.transmit;

import com.fasterxml.jackson.core.type.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import org.harvey.respiratory.handler.DoctorInterviewHandler;
import org.harvey.respiratory.pojo.dto.InterviewDto;
import org.harvey.respiratory.pojo.vo.NullPlaceholder;
import org.harvey.respiratory.transmit.vo.RestfulResult;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-06 01:07
 */
public class TransmitDoctorInterviewHandler implements TransmitHandler, DoctorInterviewHandler {

    private final TransmitHandlerBind bind;
    private final UriJoiner uriJoin = new UriJoiner("interview", "api");

    public TransmitDoctorInterviewHandler(TransmitHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public void interview(InterviewDto interviewDto) {
        bind.executeSimply(HttpMethod.POST, uriJoin.add("execute"), interviewDto,
                new TypeReference<RestfulResult<NullPlaceholder>>() {
                }
        );
    }
}
