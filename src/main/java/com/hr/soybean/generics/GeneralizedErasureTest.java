package com.hr.soybean.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GeneralizedErasureTest {

    private static class Base<T> {
        T type;

        @Override
        public String toString() {
            System.out.println(type);
            return super.toString();
        }
    }

    private static class Son1<T> extends Base<T> {

        @Override
        public String toString() {
//            System.out.println("son1 = " + type);
            return super.toString();
        }
    }

    private static class Son2 extends Base<String> {
        @Override
        public String toString() {
            return super.toString();
        }
    }



    public static void main(String[] args) {
        Son1<String> son1 = new Son1<>();

        ParameterizedType type = (ParameterizedType)son1.getClass().getGenericSuperclass();
        System.out.println("pType = " + type);
        Type actualType = type.getActualTypeArguments()[0];
        System.out.println("actualType = " + actualType);
        Son2 son2 = new Son2();
        type = (ParameterizedType) son2.getClass().getGenericSuperclass();
        System.out.println("pType = " + type);
        actualType = type.getActualTypeArguments()[0];
        System.out.println("actualType = " + actualType);


    }

}
