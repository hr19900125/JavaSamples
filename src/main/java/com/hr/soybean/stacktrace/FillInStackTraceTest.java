package com.hr.soybean.stacktrace;

public class FillInStackTraceTest {

    public static void f() throws Exception {
        throw new Exception("出问题啦！");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
            e.printStackTrace();
//            throw e;
            throw (Exception) e.fillInStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
