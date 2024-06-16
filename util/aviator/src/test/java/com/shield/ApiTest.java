package com.shield;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.googlecode.aviator.AviatorEvaluator;
import com.sheild.AddFunction;
import org.junit.jupiter.api.Test;

/**
 * @author miller
 * @date 2023/9/4
 * @version 1.0.0
 */
public class ApiTest {
    private static final Log log = LogFactory.get();

    @Test
    void test() {
        Long r = (Long) AviatorEvaluator.execute("2 * (3 + 5)");
        log.info("{}", r);
    }

    @Test
    void test01() {
        Boolean r = (Boolean) AviatorEvaluator.execute("100 < 80 && 30 < 40");
        log.info("{}", r);
    }

    @Test
    void add() {
        // 注册
        AviatorEvaluator.addFunction(new AddFunction());

        // 使用
        long sum = (Long) AviatorEvaluator.getInstance().execute("add(3,4)");
        log.info("{}", sum);
    }

    @Test
    void script() {
        Object r = AviatorEvaluator.execute("if (true) { return 1; } else { return 2; }");
        log.info("{}", r);
    }
}
