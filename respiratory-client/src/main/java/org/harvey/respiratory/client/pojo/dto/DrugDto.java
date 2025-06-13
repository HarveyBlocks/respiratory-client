package org.harvey.respiratory.client.pojo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.harvey.respiratory.client.pojo.entity.clinic.Drug;
import org.harvey.respiratory.client.pojo.entity.clinic.SpecificUsingDrugRecord;

import java.io.Serializable;

/**
 * 药品信息
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-20 23:01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class DrugDto implements Serializable {
    /**
     * 用药指南
     */
    private SpecificUsingDrugRecord specificUsingDrugRecord;

    /**
     * 具体药物
     */
    private Drug drug;
}
