package org.harvey.respiratory.net.correspondence;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.concurrent.DefaultPromise;

import java.util.Map;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-05-08 11:41
 */
class CorrespondenceTask {
    final Channel channel;

    final DefaultPromise<String> contentPromise;
    final DefaultPromise<Iterable<Map.Entry<String, String>>> headerPromise;

    CorrespondenceTask(Channel channel) {
        this.channel = channel;
         this.contentPromise = new DefaultPromise<>(channel.eventLoop());
         this.headerPromise = new DefaultPromise<>(channel.eventLoop());
    }


}
