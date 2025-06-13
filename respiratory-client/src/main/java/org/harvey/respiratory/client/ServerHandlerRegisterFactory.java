package org.harvey.respiratory.client;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-06 15:23
 */
public class ServerHandlerRegisterFactory {
    public static final ServerHandlerRegister TEST = new TestServerHandlerRegister();
    public static final ServerHandlerRegister DEV = new TransmitServerHandlerRegister();
}
