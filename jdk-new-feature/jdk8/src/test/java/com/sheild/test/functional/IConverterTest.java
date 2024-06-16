package com.sheild.test.functional;

import com.shild.functional.IConverter;
import org.junit.jupiter.api.Test;

/**
 * @author miller
 * @date 2023/9/21
 * @version 1.0.0
 */
public class IConverterTest {
    @Test
    void test01() {
        IConverter<String, Integer> converter = Integer::parseInt;
    }

    @Test
    void test2() {
        IConverter<Integer, String> converter = String::valueOf;
        String s = converter.convert(2);
        System.out.println(s);
    }
}
