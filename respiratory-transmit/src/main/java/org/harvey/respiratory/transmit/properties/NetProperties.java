package org.harvey.respiratory.transmit.properties;

import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Map;
import java.util.Properties;

/**
 * 导入配置文件
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 12:51
 */
@Slf4j
public class NetProperties {
    public static final NetProperties DEFAULT;

    static {
        NetProperties defaultProperties;
        try (Reader reader = new FileReader("src/main/resources/net.properties")) {
            defaultProperties = new NetProperties(reader);
        } catch (IOException e) {
            defaultProperties = new NetProperties(Map.of("response.field.code", "code",
                    "response.field.message", "msg",
                    "response.field.data", "data",
                    "server.host", "localhost",
                    "server.port", "8080"));
            log.warn("打开配置文件失败, 使用默认配置");
        }
        DEFAULT = defaultProperties;
    }

    private final Properties properties;

    NetProperties(Reader reader) throws IOException {
        this.properties = new Properties();
        properties.load(reader);
    }

    NetProperties(InputStream inputStream) throws IOException {
        this.properties = new Properties();
        properties.load(inputStream);
    }

    public NetProperties(Map<String, String> t) {
        this.properties = new Properties();
        properties.putAll(t);
    }

    public String get(PropertyName propertyName) {
        return properties.getProperty(propertyName.name);
    }

    public static enum PropertyName {
        CODE_FIELD("response.field.code"),
        MESSAGE_FIELD("response.field.message"),
        DATA_FIELD("response.field.data"),
        HOST("server.host"),
        PORT("server.port"),
        ;
        final String name;

        PropertyName(String name) {
            this.name = name;
        }
    }
}
