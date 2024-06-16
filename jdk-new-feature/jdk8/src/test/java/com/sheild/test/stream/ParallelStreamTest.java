package com.sheild.test.stream;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author miller
 * @date 2023/9/21
 * @version 1.0.0
 */
public class ParallelStreamTest {
    int max = 1000000;
    List<String> values = new ArrayList<>(max);

//    @BeforeEach
    void init() {
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
    }

    /**
     * 顺序
     */
    @Test
    void test1() {
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        TimeInterval timeInterval = DateUtil.timer();
        long count = values.stream().sorted().count();
        Console.log("【顺序流】数量：{}，时间：{}", count, timeInterval.interval());
    }

    /**
     * 并行
     */
    @Test
    void test2() {
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        TimeInterval timeInterval1 = DateUtil.timer();
        long count1 = values.parallelStream().sorted().count();
        Console.log("【并行流】数量：{}，时间：{}", count1, timeInterval1.interval());
    }
}
