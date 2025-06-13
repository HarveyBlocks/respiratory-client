package org.harvey.respiratory.client.pojo.entity.clinic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 医疗服务机构表
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-13 00:46
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MedicalProviderForm implements Serializable {

    /**
     * 医疗提供机构id
     */
    private Integer id;

    /**
     * 名称(varchar(63))
     */
    private String name;

    /**
     * 地址(varchar(255))
     */
    private String address;

}
