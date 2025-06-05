package org.harvey.respiratory;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-05 19:37
 */
public interface ServerHandlerRegister {

    <T extends ServerHandler> T get(Class<T> type);
}
