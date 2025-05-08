package org.harvey.respiratory.net.correspondence;


import org.harvey.respiratory.net.vo.RestfulHttpResponse;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 02:29`
 */
public interface HttpClientExecutor {

    RestfulHttpResponse execute();

    void execute(ResponseListener listener);
}
