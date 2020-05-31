package com.ganymede;

import com.ganymede.eums.LogType;

import java.util.Random;

public class Test1 {
    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            int temp = random.nextInt(2);
            System.out.println(temp);
        }

        System.out.println(LogType.APP_PRODUCT);

    }
}
