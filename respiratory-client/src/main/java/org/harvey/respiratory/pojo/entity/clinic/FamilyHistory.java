package org.harvey.respiratory.pojo.entity.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 家庭病史
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 00:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FamilyHistory implements Serializable {
    /**
     * 家族史记录id, 冗余, 不然就要全属性主键了, 这不好
     */
    private Long id;
    /**
     * 患者本人在患者表中id
     */
    private Long patientId;
    /**
     * 家族成员关系enum(有很多)
     */
    private Integer familyRelationshipId;
    /**
     * 疾病表id
     */
    private Integer diseaseId;

    /**
     * 家族居住环境共同暴露因素,varchar
     */
    private String livingEnvironmentCommonFactor;

    /**
     * 居住在吸烟环境
     */
    private Boolean livingInSmokingEnvironment;
}
