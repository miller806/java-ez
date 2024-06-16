package com.shild.functional;

/**
 * @author miller
 * @date 2023/9/21
 * @version 1.0.0
 */
@FunctionalInterface
public interface IConverter<F, T> {
    T convert(F from);
}
