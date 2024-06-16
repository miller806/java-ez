package com.shild;

/**
 * @author miller
 * @date 2023/9/20
 * @version 1.0.0
 */
public interface IFormula {
    double calculate(int a);

    default double sqrt(int a) {
        return a * a;
    }
}
