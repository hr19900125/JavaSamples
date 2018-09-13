package com.hr.soybean.reflect.test;

import com.hr.soybean.reflect.Reflect;

public class Test {

    private static class Person {
        private int age = 18;

        private String name = "HuangRui";

        private void sayHello() {
            System.out.println("Hello !");
        }

        public void walk() {
            System.out.println("Walk 100m");
        }

        private static void sayGoodBye() {
            System.out.println("GoodBye !");
        }

    }

    public static void main(String[] args) {
        Person p = new Person();

        Reflect.on(p).callDeclared("sayHello");

        Reflect.on(p).call("walk");
    }

}
