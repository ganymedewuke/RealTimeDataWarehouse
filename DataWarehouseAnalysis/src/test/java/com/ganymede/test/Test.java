package com.ganymede.test;

import com.ganymede.business.OrderInfo;
import com.ganymede.constant.Constants;
import org.apache.commons.lang3.StringUtils;

public class Test {
    public static void main(String[] args) {
        OrderInfo orderInfo = new OrderInfo();

        String[] splitArrays = "".split(Constants.SPLIT_STRING);

        String tmp = null;

        orderInfo.setOrderAmount(tmp == null ? -1 : Integer.valueOf(tmp));
        System.out.println(orderInfo.getOrderAmount());


        boolean flag = StringUtils.isEmpty("null");
        System.out.println(flag);

    }
}
