package org.harvey.respiratory.handler;

import org.harvey.respiratory.ServerHandler;
import org.harvey.respiratory.pojo.dto.InterviewDto;

/**
 * 医生问诊
 * /interview/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 13:27
 */
public interface DoctorInterviewHandler extends ServerHandler {

    /**
     * /execute
     * POST
     * 问诊. 1. 更新就诊信息 2. 生成多条费用单 3. 计算费用价格 4. 插入多条具体药物使用 5. 插入多个症状的一系列操作具有原子性
     *
     * @param interviewDto interview
     */
    void interview(InterviewDto interviewDto);

}
