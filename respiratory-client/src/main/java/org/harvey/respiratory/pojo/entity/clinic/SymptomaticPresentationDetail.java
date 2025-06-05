package org.harvey.respiratory.pojo.entity.clinic;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.harvey.respiratory.pojo.enums.clinic.SymptomaticPresentationType;

import java.io.Serializable;

/**
 * 具体症状
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 00:26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SymptomaticPresentationDetail implements Serializable {
    /**
     * 症状id
     */
    private Integer id;
    /**
     * 名字varchar
     */
    private String name;
    /**
     * 类型enum(int)
     */
    private SymptomaticPresentationType type;
}
