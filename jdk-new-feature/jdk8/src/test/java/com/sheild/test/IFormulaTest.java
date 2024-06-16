package com.sheild.test;

import cn.hutool.core.lang.Console;
import com.shild.IFormula;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author miller
 * @date 2023/9/20
 * @version 1.0.0
 */
public class IFormulaTest {
    @Test
    void test(){
        IFormula iFormula = a -> a * a;
        Console.log(iFormula.calculate(1));
        Console.log(iFormula.sqrt(2));
    }
    @Test
    void order(){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        names.sort(Comparator.reverseOrder());
        Console.log(names);
    }
}
