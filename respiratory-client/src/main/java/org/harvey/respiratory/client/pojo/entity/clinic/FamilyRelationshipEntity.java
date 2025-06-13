package org.harvey.respiratory.client.pojo.entity.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 用户权限表
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-16 19:35
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRelationshipEntity implements Serializable {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 关系名, 英文
     */
    private String name;
    /**
     * 关系描述, 中文
     */
    private String description;
    /**
     * 一代亲属, 二代亲属, 大概, true 表 一代亲属
     */
    private Boolean closeLevel;
}
