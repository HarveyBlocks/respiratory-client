package org.harvey.respiratory.handler;

import org.harvey.respiratory.ServerHandler;
import org.harvey.respiratory.pojo.dto.SymptomaticPresentationDto;
import org.harvey.respiratory.pojo.entity.clinic.SymptomaticPresentation;
import org.harvey.respiratory.pojo.entity.clinic.SymptomaticPresentationDetail;
import org.harvey.respiratory.pojo.enums.clinic.SymptomaticPresentationType;

import java.util.List;

/**
 * 症状
 * /symptomatic-presentation/api
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-14 21:57
 */
public interface SymptomaticPresentationHandler extends ServerHandler {
    /**
     * 删除某一问诊的某一具体用药
     * DeleteMapping("/{id}")
     *
     * @param id 症状id
     */
    void del(Long id);

    /**
     * 更新症状
     * PutMapping("/")
     *
     * @return 对症状更新后的新ID
     */
    Long updatePatientSymptomaticPresentation(SymptomaticPresentation symptomaticPresentation);

    /**
     * 依据类型查询症状
     * GetMapping("detail/{type}")
     *
     * @param type 类型
     */
    List<SymptomaticPresentationDetail> queryDetailsByType(SymptomaticPresentationType type);

    /**
     * 查询该问诊的有关症状
     * GetMapping("visit/{id}")
     *
     * @param visitId 问诊号
     */
    List<SymptomaticPresentationDto> queryVisitDrug(Long visitId);
}
