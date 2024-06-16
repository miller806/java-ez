package com.sheild.test.optional;

import cn.hutool.core.lang.Console;
import com.shild.lambda.Person;
import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * @author miller
 * @date 2023/9/21
 * @version 1.0.0
 */
public class OptionalTest {
    @Test
    void test1() {
        Optional<String> optional = Optional.of("bam");
        Console.log(optional.isPresent());             // true
        optional.get();                        // "bam"
        optional.orElse("fallback");    // "bam"
        optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
        Optional<Person> optionalPerson = Optional.of(new Person());
        optionalPerson.ifPresent(s -> System.out.println(s.firstName));
    }
}
