package com.sheild.test.stream;

import cn.hutool.core.lang.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author miller
 * @date 2023/9/21
 * @version 1.0.0
 */
public class StreamTest {
    List<String> stringCollection = new ArrayList<>();


    @BeforeEach
    void init() {
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
    }

    /**
     * filter 过滤
     */
    @Test
    void test1() {
        stringCollection.stream().filter(s -> s.startsWith("b")).forEach(Console::log);
    }

    /**
     * sorted 排序
     */
    @Test
    void test2() {
        stringCollection.stream().sorted().filter(s -> s.startsWith("a")).forEach(Console::log);
        Console.log(stringCollection);
    }

    /**
     * map 转换
     */
    @Test
    void map() {
        List<String> after = stringCollection.stream().filter(s -> s.startsWith("b")).map(String::toUpperCase).collect(Collectors.toList());
        Console.log(after);
    }

    /**
     * match 匹配
     */
    @Test
    void match() {
// anyMatch：验证 list 中 string 是否有以 a 开头的, 匹配到第一个，即返回 true
        boolean anyStartsWithA =
                stringCollection
                        .stream()
                        .anyMatch((s) -> s.startsWith("a"));
        System.out.println(anyStartsWithA);      // true
        // allMatch：验证 list 中 string 是否都是以 a 开头的
        boolean allStartsWithA =
                stringCollection
                        .stream()
                        .allMatch((s) -> s.startsWith("a"));
        System.out.println(allStartsWithA);      // false
        // noneMatch：验证 list 中 string 是否都不是以 z 开头的
        boolean noneStartsWithZ =
                stringCollection
                        .stream()
                        .noneMatch((s) -> s.startsWith("z"));
        System.out.println(noneStartsWithZ);
    }

    /**
     * 计数
     */
    @Test
    void count() {
        // count：先对 list 中字符串开头为 b 进行过滤，让后统计数量
        long startsWithB =
                stringCollection
                        .stream()
                        .filter((s) -> s.startsWith("b"))
                        .count();
        System.out.println(startsWithB);    // 3
    }

    /**
     * 缩小
     */
    @Test
    void reduce() {
        Optional<String> reduced =
                stringCollection
                        .stream()
                        .sorted()
                        .reduce((s1, s2) -> s1 + "#" + s2);
        reduced.ifPresent(System.out::println);
        // aaa1#aaa2#bbb1#bbb2#bbb3#ccc#ddd1#ddd2
    }
}
