package com.hr.soybean.generics;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class TypeVariableTest<T extends Number & Serializable & Comparable> {

    private T t;

    public static void testGetBounds() throws NoSuchFieldException {
        Field fieldT = TypeVariableTest.class.getDeclaredField("t");
        TypeVariable typeVariable = (TypeVariable) fieldT.getGenericType();
        Type[] types = typeVariable.getBounds();
        for (Type type : types) {
            System.out.println(type);
        }
    }

    public static void testGetGenericDeclaration() {
        
    }

    public static void main(String[] args) throws NoSuchFieldException {
        testGetBounds();
    }


}
