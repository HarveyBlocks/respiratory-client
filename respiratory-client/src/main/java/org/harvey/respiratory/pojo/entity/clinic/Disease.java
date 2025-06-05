package org.harvey.respiratory.pojo.entity.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 疾病具体信息
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-12 23:55
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class Disease implements Serializable {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 名称varchar(63)
     */
    private String name;
    /**
     * 描述TEXT
     */
    private String description;

}
