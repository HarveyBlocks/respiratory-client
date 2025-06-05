package org.harvey.respiratory.transmit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.harvey.respiratory.transmit.properties.NetProperties;

/**
 * Restful风格的数据
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-29 23:17
 */
@Getter
@NoArgsConstructor
@Data
@AllArgsConstructor
public class RestfulResult<T> {
    public static final String CODE_FIELD = NetProperties.DEFAULT.get(NetProperties.PropertyName.CODE_FIELD);
    public static final String DATA_FIELD = NetProperties.DEFAULT.get(NetProperties.PropertyName.DATA_FIELD);
    public static final String MESSAGE_FIELD = NetProperties.DEFAULT.get(NetProperties.PropertyName.MESSAGE_FIELD);

    private Integer code;
    private String msg;
    private T data;

    public boolean succeed() {
        return code == 200;
    }


}
