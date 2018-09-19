package com.hr.soybean.stacktrace;

public class GetStackTraceTest {


    public static void f() throws Exception {
        throw new Exception("出问题啦！");
    }

    public static void g() throws Exception {
        f();
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("--------------");
            StackTraceElement[] stacks = e.getStackTrace();
            for (StackTraceElement element : stacks) {
                System.out.println(element);
            }
        }
    }

}
