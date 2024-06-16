package com.sheild.test.lambda;

import com.shild.lambda.Person;

/**
 * @author miller
 * @date 2023/9/21
 * @version 1.0.0
 */
public class MyConsumer<T> {
    public void accept(Person person) {
        System.out.println("hello," + person.getFirstName());
    }
}
