package com.ganymede.mock;


import com.alibaba.fastjson.JSONObject;
import com.ganymede.eums.LogType;
import com.ganymede.input.WeChatCartLog;

import java.util.Random;

public class WeChatCartGenerateData {
    private static int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private static Random random = new Random();

    private static String[] weChatAccoutInfos = new String[]{"zhangsan==张三==男==上海", "lisi==李四==男==北京", "wangwu==王五==女==广州"};
    private static String[] userIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private static String[] deviceIds = new String[]{"deviceId1", "deviceId2", "deviceId3"};
    private static String[] operatorTypes = new String[]{"1", "0"}; //购物车操作类型

    private static String[] ips = new String[]{"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7", "192.168.1.8"}; //用户app访问的ip
    private static String[] countrys = new String[]{"China", "Japan", "Korea", "Singapore", "Germany", "England", "France", "Russia", "America"};// 国家
    private static String[] provinces = new String[]{"Beijing", "Shanghai", "GuangDong", "Guangxi", "Jiangsu"}; //省
    private static String[] citys = new String[]{"Nanjing", "Wuxi", "Guangzhou", "Shenzhen", "Nanning"}; //市

    private static String[] channelIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //频道ID
    private static String[] productTypeIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};//类别ID
    private static String[] productIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //产品ID


    private static WeChatCartLog genernateData() {
        WeChatCartLog weChatCartLog = new WeChatCartLog();
        weChatCartLog.setUserId(userIds[random.nextInt(userIds.length)]);

        String weChatInfo = weChatAccoutInfos[random.nextInt(weChatAccoutInfos.length)];
        String[] info = weChatInfo.split("==");

        weChatCartLog.setWeChatAccount(info[0]);
        weChatCartLog.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);
        weChatCartLog.setOperatorType(operatorTypes[random.nextInt(operatorTypes.length)]);
        weChatCartLog.setIp(ips[random.nextInt(ips.length)]);
        weChatCartLog.setCountry(countrys[random.nextInt(countrys.length)]);
        weChatCartLog.setProvince(provinces[random.nextInt(provinces.length)]);
        weChatCartLog.setCity(citys[random.nextInt(citys.length)]);

        weChatCartLog.setChannelId(channelIds[random.nextInt(channelIds.length)]);
        weChatCartLog.setProductId(productIds[random.nextInt(productIds.length)]);
        weChatCartLog.setProductTypeId(productTypeIds[random.nextInt(productTypeIds.length)]);


        long open = GenerateDataUtil.genernateDateData(days, random);
        weChatCartLog.setOpenTime(open + "");
        weChatCartLog.setOperatorTime(open + 5 * 1000l + "");
        weChatCartLog.setLeaveTime(open + 10 * 1000l + "");
        weChatCartLog.setLogType(LogType.WECHAT_CART);
        return weChatCartLog;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 88; i++) {
            WeChatCartLog weChatCartLog = genernateData();
            String str = JSONObject.toJSONString(weChatCartLog);
            System.out.println(str);
            GenerateDataUtil.postHttpMethod("http://localhost:8081/dwCollect/collectAppData", str);
        }

    }
}
