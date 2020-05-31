package com.ganymede;

import java.util.UUID;

public class Test2 {
    public static void main(String[] args) {
        System.out.println(MyParent3.str);
    }
}

class MyParent3{
    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("abc 123");
    }
}