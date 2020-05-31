package com.ganymede;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(MyParent2.i);
    }
}

class MyParent2 {
    public static  int i = 1;

    public static final Integer i2 = 5;

    public static String str = "8";

    static {
        System.out.println("abc 123");
    }
}