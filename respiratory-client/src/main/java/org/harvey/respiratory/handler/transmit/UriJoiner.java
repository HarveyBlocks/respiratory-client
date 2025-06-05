package org.harvey.respiratory.handler.transmit;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-06 01:15
 */
public class UriJoiner {
    private final String prefix;

    public UriJoiner(String... prefix) {
        if (prefix == null || prefix.length == 0) {
            this.prefix = "/";
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Object o : prefix) {
            sb.append("/").append(o);
        }
        this.prefix = sb.toString();
    }

    public String add(Object... part) {
        return union(prefix, part);
    }

    private String union(String prefix, Object[] part) {
        if (part == null || part.length == 0) {
            return prefix;
        }
        StringBuilder sb = new StringBuilder();
        for (Object o : part) {
            sb.append("/").append(o);
        }
        return prefix + sb;
    }
}
