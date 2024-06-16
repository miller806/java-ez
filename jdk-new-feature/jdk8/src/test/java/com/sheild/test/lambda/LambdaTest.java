package com.sheild.test.lambda;

import com.shild.lambda.Person;
import com.shild.lambda.Something;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author miller
 * @date 2023/9/21
 * @version 1.0.0
 */
public class LambdaTest {
    /**
     * Predicate
     */
    @Test
    void test3() {
        Predicate<String> predicate = (s) -> s.length() > 1;
        boolean foo0 = predicate.test("foo");
        boolean foo1 = predicate.negate().test("foo");
        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

    /**
     * Function
     */
    @Test
    void test4() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        Function<String, String> afterToStartsWith = backToString.andThen(new Something()::startsWith);
        String apply = afterToStartsWith.apply("123");// "123"
        System.out.println(apply);
    }

    /**
     * Suppliers
     */
    @Test
    void test5() {
        Supplier<Person> personSupplier0 = Person::new;
        personSupplier0.get();   // new Person
        Supplier<String> personSupplier1 = Something::test01;  //这个test方法是静态的，且无入参
        personSupplier1.get();   // hi

        Supplier<String> personSupplier2 = new Something()::test02;
    }

    @Test
    void test6() {
        // 参照物，方便知道下面的Lamdba表达式写法
        Consumer<Person> greeter01 = p -> System.out.println("Hello, " + p.getFirstName());
        Consumer<Person> greeter02 = (p) -> System.out.println("Hello, " + p.getFirstName());
        greeter02.accept(new Person("Luke", "Skywalker"));  //Hello, Luke
        Consumer<Person> greeter03 = new MyConsumer<Person>()::accept;    // 也可以通过定义类和方法的方式去调用，这样才是实际开发的姿势
        greeter03.accept(new Person("Luke", "Skywalker"));  //Hello, Luke
    }

    /**
     * Comparators
     */
    @Test
    void test7() {
        Comparator<Person> comparator01 = Comparator.comparing(Person::getSecondName);
        Comparator<Person> comparator02 = Comparator.comparing(Person::getFirstName);           //等同于上面的方式
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        comparator01.compare(p1, p2);             // > 0
        comparator02.reversed().compare(p1, p2);  // < 0
    }
}
