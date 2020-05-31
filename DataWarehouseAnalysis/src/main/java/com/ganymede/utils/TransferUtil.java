package com.ganymede.utils;

import com.alibaba.fastjson.JSONObject;
import com.ganymede.constant.Constants;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TransferUtil {

    private static Map<String, String> dataDictMap = new HashMap<String, String>();

    static {
        dataDictMap.put("orderinfo", "com.ganymede.business.OrderInfo");
        dataDictMap.put("merchant", "com.ganymede.product.Merchant");
        dataDictMap.put("product", "com.ganymede.product.Product");
        dataDictMap.put("productdetail", "com.ganymede.product.Productdetail");
        dataDictMap.put("producttype", "com.ganymede.product.ProductType");
        dataDictMap.put("shopinfo", "com.ganymede.product.ShopInfo");
        dataDictMap.put("userinfo", "com.ganymede.product.UserInfo");
        dataDictMap.put("activityinfo", "com.ganymede.market.ActivityInfo");
        dataDictMap.put("coupongetinfo", "com.ganymede.market.CouponGetInfo");
        dataDictMap.put("couponinfo", "com.ganymede.market.CouponInfo");
        dataDictMap.put("grouppurchaseinfo", "com.ganymede.market.GroupPurchaseInfo");
        dataDictMap.put("redenvelopenameinfo", "com.ganymede.market.RedEnvelopeNameInfo");
        dataDictMap.put("seckillnameinfo", "com.ganymede.market.SeckillNameInfo");

    }

    public static String transferData(String topicName, JSONObject data) {
        String resultFianl = "";
        try {
            String className = dataDictMap.get(topicName);
            Class orderinfo = Class.forName(className);
            Field[] fields = orderinfo.getDeclaredFields();

            for (Field field : fields) {
                String name = field.getName();
                String result = data.getString(name) == null ? null : data.getString(name);
                resultFianl += result + Constants.SPLIT_STRING;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        resultFianl = resultFianl.substring(0, resultFianl.length() - 1);
        return resultFianl;
    }

    public static void main(String[] args) throws Exception {
        String className = "com.ganymede.business.OrderInfo";

        Class orderinfo = Class.forName(className);
        Field[] fields = orderinfo.getDeclaredFields();

        for (Field field : fields) {
            String name = field.getName();
            System.out.println(name);
        }

    }
}
