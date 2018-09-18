package com.hr.soybean.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 一般情况下，泛型在编译阶段会"擦除"
 * 但是，如果方法中出现了带泛型的匿名内部类，那么泛型依旧会被保留下来
 */
public class GenericsTypeTest {

    private static class Person<T> {

        T temperament;

        int age;

        String name;

    }

    private class Optimistic {

    }

    private class Pessimism {

    }


    public static void main(String[] args) {

        Person p1 = new Person<Optimistic>(){};
        p1.age = 18;
        p1.name = "Huang";

        Person p2 = new Person<Pessimism>();
        p2.age = 19;
        p2.name = "Rui";

        Type superClass = p1.getClass().getGenericSuperclass();
        System.out.println("p1 genericSuperclass " + superClass);

        Type actualType = ((ParameterizedType)superClass).getActualTypeArguments()[0];
        System.out.println("p1 actualTypeArguments " + actualType);
    }

}
