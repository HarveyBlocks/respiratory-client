package org.harvey.respiratory.net.correspondence;


import org.harvey.respiratory.net.vo.RestfulHttpResponse;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 02:29`
 */
public interface HttpClientExecutor {

    /**
     * 阻塞执行
     */
    RestfulHttpResponse execute() throws InterruptedException;
    /**
     * 同步执行
     */
    void execute(ResponseListener listener) throws InterruptedException;
}
