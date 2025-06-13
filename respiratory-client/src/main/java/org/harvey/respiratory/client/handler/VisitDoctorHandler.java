package org.harvey.respiratory.client.handler;

import org.harvey.respiratory.client.ServerHandler;
import org.harvey.respiratory.client.pojo.dto.TakeVisitNumberDto;
import org.harvey.respiratory.client.pojo.entity.clinic.VisitDoctor;

import java.util.Date;
import java.util.List;

/**
 * 医生进行问诊,就诊
 * /visit/api/
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-12 23:40
 */
public interface VisitDoctorHandler extends ServerHandler {
    /**
     * PostMapping("/take-number")
     * 取号
     *
     * @param takeVisitNumberDto 取号需要的信息
     */
    Long createVisitDoctorId(TakeVisitNumberDto takeVisitNumberDto);


    /**
     * GetMapping("/{id}")
     * 获取就诊信息
     *
     * @param id 就诊表的id
     */
    VisitDoctor getById(Long id);

    /**
     * GetMapping(value = {"/doctor/any/{start-date}/{end-date}/{page}/{limit}"})
     * 查询当前医生相关就诊信息
     *
     * @param startDate 查询范围, 开始时间
     * @param endDate   查询范围, 结束时间
     * @param page      页码, 从1开始
     * @param limit     页面长度
     */

    List<VisitDoctor> doctorQuery(Date startDate, Date endDate, Integer page, Integer limit);

    /**
     * GetMapping(value = {"/doctor/any/{start-date}/{end-date}/{page}"})
     * 查询当前医生相关就诊信息
     *
     * @param startDate 查询范围, 开始时间
     * @param endDate   查询范围, 结束时间
     * @param page      页码, 从1开始
     */

    List<VisitDoctor> doctorQuery(Date startDate, Date endDate, Integer page);

    /**
     * GetMapping(value = { "/doctor/any/{start-date}/{end-date}"})
     * 查询当前医生相关就诊信息
     *
     * @param startDate 查询范围, 开始时间
     * @param endDate   查询范围, 结束时间
     */
    List<VisitDoctor> doctorQuery(Date startDate, Date endDate);


    /**
     * GetMapping(value = {"/user/any/{start-date}/{end-date}/{page}/{limit}"})
     * 查询当前用户持有患者相关就诊信息
     *
     * @param startDate 查询范围, 开始时间
     * @param endDate   查询范围, 结束时间
     * @param page      页码, 从1开始
     * @param limit     页面长度
     */
    List<VisitDoctor> userQuery(Date startDate, Date endDate, Integer page, Integer limit);


    /**
     * GetMapping(value = { "/user/any/{start-date}/{end-date}/{page}"})
     * 查询当前用户持有患者相关就诊信息
     *
     * @param startDate 查询范围, 开始时间
     * @param endDate   查询范围, 结束时间
     * @param page      页码, 从1开始
     */
    List<VisitDoctor> userQuery(Date startDate, Date endDate, Integer page);


    /**
     * GetMapping(value = {"/user/any/{start-date}/{end-date}"})
     * 查询当前用户持有患者相关就诊信息
     *
     * @param startDate 查询范围, 开始时间
     * @param endDate   查询范围, 结束时间
     */
    List<VisitDoctor> userQuery(Date startDate, Date endDate);

    /**
     * GetMapping(value = {"/user/un-pay/{patient_id}",})
     * 查询当前用户持有患者相关就诊信息,未支付
     *
     * @param patientId 病患id. 依据病患查询
     */
    List<VisitDoctor> userQueryUnPay(Long patientId);

}
