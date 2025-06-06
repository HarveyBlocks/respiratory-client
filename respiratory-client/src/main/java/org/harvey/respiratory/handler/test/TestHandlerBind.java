package org.harvey.respiratory.handler.test;

import lombok.extern.slf4j.Slf4j;
import org.harvey.respiratory.RandomUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2025-06-06 03:48
 */
@Slf4j
public class TestHandlerBind extends RandomUtil {
    private final RandomUtil randomUtil;

    public TestHandlerBind(RandomUtil randomUtil) {
        this.randomUtil = randomUtil;
    }

    @Override
    public int uniform(int left, int right) {
        return randomUtil.uniform(left, right);
    }

    @Override
    public String randomString(int shortest, int longest) {
        return randomUtil.randomString(shortest, longest);
    }

    @Override
    public <T> T chose(List<T> list) {
        return randomUtil.chose(list);
    }

    @Override
    public <T> T chose(T[] array) {
        return randomUtil.chose(array);
    }

    @Override
    public boolean bit(double probability) {
        return randomUtil.bit(probability);
    }

    public <T> List<T> list(Supplier<T> supplier) {
        return list(supplier, randomUtil.uniform(2, 20));
    }

    public <T> List<T> list(Supplier<T> supplier, int length) {
        List<T> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    public Integer randomIntId() {
        return randomUtil.uniform(1, Integer.MAX_VALUE);
    }

    public Long randomLongId() {
        long upper = randomUtil.uniform(1, Integer.MAX_VALUE);
        long lower = randomUtil.uniform(1, Integer.MAX_VALUE);
        return upper << 32 | lower;
    }

    public void info(String msg, Object... arg) {
        log.info(msg, arg);
    }

    public String randomShortString() {
        return randomUtil.randomString(5, 50);
    }

    public String randomLongString() {
        return randomUtil.randomString(5, 250);
    }

    public Date randomDate(Date startDate, Date endDate) {
        long start = 0;
        if (startDate != null) {
            start = startDate.getTime();
        }
        long end = System.currentTimeMillis();
        if (endDate != null) {
            end = endDate.getTime();
        }
        Long date = randomLongId();
        return new Date(date % (end - start) + start);
    }
}
