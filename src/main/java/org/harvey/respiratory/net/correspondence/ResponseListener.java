package org.harvey.respiratory.net.correspondence;


import org.harvey.respiratory.net.vo.RestfulHttpResponse;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 10:39
 */
@FunctionalInterface
public interface ResponseListener {
     void listen(RestfulHttpResponse response);
}
