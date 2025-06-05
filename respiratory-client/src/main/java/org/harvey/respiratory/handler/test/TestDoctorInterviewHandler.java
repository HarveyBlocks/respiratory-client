package org.harvey.respiratory.handler.test;


import org.harvey.respiratory.handler.DoctorInterviewHandler;
import org.harvey.respiratory.pojo.dto.InterviewDto;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-06 01:07
 */
public class TestDoctorInterviewHandler implements TestHandler, DoctorInterviewHandler {
    private final TestHandlerBind bind;

    public TestDoctorInterviewHandler(TestHandlerBind bind) {
        this.bind = bind;
    }

    @Override
    public void interview(InterviewDto interviewDto) {
        /*ignore*/
    }
}
