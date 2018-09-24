package com.hr.soybean.generics;

import java.io.Serializable;
import java.lang.reflect.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ParameterizedTypeTest<T> {

    private List<T> list = null;
    private Set<T> set = null;
    private Map<String, Integer> map = null;
    private Map.Entry<String, Integer> mapEntry = null;
    private T[] array;
    private List<String>[] listArray;

    public static void main(String[] args) throws NoSuchFieldException {
        testGetGenericType();
        testGetActualTypeArguments();
        testGetRawType();
        testGetOwnerType();
        testGenericArrayType();
        testGetGenericComponentType();
        testTypeVariable();
    }

    public static void testGetGenericType() throws NoSuchFieldException {
        System.out.println("--- testGetGenericType ---");

        Field fieldList = ParameterizedTypeTest.class.getDeclaredField("list");

        Type typeList = fieldList.getGenericType();

        System.out.println("typeName = " + typeList.getTypeName() + ", className = " + typeList.getClass().getName());

        Field fieldSet = ParameterizedTypeTest.class.getDeclaredField("set");

        Type typeSet = fieldSet.getGenericType();

        System.out.println("typeName = " + typeSet.getTypeName() + ", className = " + typeSet.getClass().getName());
    }

    public static void testGetActualTypeArguments() throws NoSuchFieldException {
        System.out.println("--- testGetActualTypeArguments ---");

        Field fieldMap = ParameterizedTypeTest.class.getDeclaredField("map");

        Type typeMap = fieldMap.getGenericType();

        ParameterizedType ptMap = (ParameterizedType) typeMap;

        Type[] types = ptMap.getActualTypeArguments();

        System.out.println(ptMap);
        System.out.println(types[0]);
        System.out.println(types[1]);
    }

    public static void testGetRawType() throws NoSuchFieldException {
        System.out.println("--- testGetRawType ---");
        Field fieldMap = ParameterizedTypeTest.class.getDeclaredField("map");
        Type typeMap = fieldMap.getGenericType();
        ParameterizedType ptMap = (ParameterizedType) typeMap;
        Type type = ptMap.getRawType();
        System.out.println(type);
    }

    public static void testGetOwnerType() throws NoSuchFieldException {
        System.out.println("--- testGetOwnerType ---");
        Field fieldMapEntry = ParameterizedTypeTest.class.getDeclaredField("mapEntry");
        Type typeMapEntry = fieldMapEntry.getGenericType();
        ParameterizedType ptType = (ParameterizedType) typeMapEntry;
        Type type = ptType.getOwnerType();
        System.out.println("getOwnerType = " + type);
    }

    public static void testGenericArrayType() throws NoSuchFieldException {
        System.out.println("--- testGenericArrayType ---");
        Field fieldListArray = ParameterizedTypeTest.class.getDeclaredField("listArray");
        Type typeListArray = fieldListArray.getGenericType();
        System.out.println(typeListArray.getClass().getName());

        Field fieldArray = ParameterizedTypeTest.class.getDeclaredField("array");
        Type typeArray = fieldArray.getGenericType();
        System.out.println(typeArray.getClass().getName());

    }

    public static void testGetGenericComponentType() throws NoSuchFieldException {
        System.out.println("--- testGetGenericComponentType ---");
        Field fieldListArray = ParameterizedTypeTest.class.getDeclaredField("listArray");
        Type typeListArray = fieldListArray.getGenericType();
        GenericArrayType type = (GenericArrayType) typeListArray;
        Type cType = type.getGenericComponentType();
        System.out.println(cType.getClass().getName() + ", " + cType);
    }

    public static void testTypeVariable() throws NoSuchFieldException {
        System.out.println("--- testTypeVariable ---");
        Field fieldList = ParameterizedTypeTest.class.getDeclaredField("list");
        Type typeList = fieldList.getGenericType();
        ParameterizedType parameterizedTypeList = (ParameterizedType) typeList;
        Type[] type = parameterizedTypeList.getActualTypeArguments();
        System.out.println(type[0].getClass().getName() + ", " + type[0]);
    }


}
