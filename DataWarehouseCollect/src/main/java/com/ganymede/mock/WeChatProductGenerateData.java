package com.ganymede.mock;


import com.alibaba.fastjson.JSONObject;
import com.ganymede.eums.LogType;
import com.ganymede.input.WeChatProductLog;

import java.util.Random;

public class WeChatProductGenerateData {
    private static int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private static Random random = new Random();

    private static String[] weChatAccoutInfos = new String[]{"zhangsan==张三==男==上海", "lisi==李四==男==北京", "wangwu==王五==女==广州"};

    private static String[] userIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private static String[] deviceIds = new String[]{"deviceId1", "deviceId2", "deviceId3"};
    private static String[] channelIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //频道ID
    private static String[] productTypeIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};//类别ID
    private static String[] productIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //产品ID

    private static String[] ips = new String[]{"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7", "192.168.1.8"}; //用户app访问的ip
    private static String[] countrys = new String[]{"China", "Japan", "Korea", "Singapore", "Germany", "England", "France", "Russia", "America"};// 国家
    private static String[] provinces = new String[]{"Beijing", "Shanghai", "GuangDong", "Guangxi", "Jiangsu"}; //省
    private static String[] citys = new String[]{"Nanjing", "Wuxi", "Guangzhou", "Shenzhen", "Nanning"}; //市


    private static WeChatProductLog genernateData() {
        WeChatProductLog weChatProductLog = new WeChatProductLog();
        weChatProductLog.setUserId(userIds[random.nextInt(userIds.length)]);

        String weChatInfo = weChatAccoutInfos[random.nextInt(weChatAccoutInfos.length)];
        String[] info = weChatInfo.split("==");

        weChatProductLog.setWeChatAccount(info[0]);
        weChatProductLog.setWeChatName(info[1]);
        weChatProductLog.setWeChatSex(info[2]);
        weChatProductLog.setWeChatArea(info[3]);


        weChatProductLog.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);

        weChatProductLog.setChannelId(channelIds[random.nextInt(channelIds.length)]);
        weChatProductLog.setProductId(productIds[random.nextInt(productIds.length)]);
        weChatProductLog.setProductTypeId(productTypeIds[random.nextInt(productTypeIds.length)]);
        weChatProductLog.setIp(ips[random.nextInt(ips.length)]);
        weChatProductLog.setCountry(countrys[random.nextInt(countrys.length)]);
        weChatProductLog.setProvince(provinces[random.nextInt(provinces.length)]);
        weChatProductLog.setCity(citys[random.nextInt(citys.length)]);

        long open = GenerateDataUtil.genernateDateData(days, random);
        weChatProductLog.setOpenTime(open + "");
        weChatProductLog.setScanTime(open + 5 * 1000l + "");
        weChatProductLog.setJumpTime(open + 10 * 1000l + "");
        weChatProductLog.setLeaveTime(open + 15 * 1000l + "");
        weChatProductLog.setLogType(LogType.WECHAT_PRODUCT);
        return weChatProductLog;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 88; i++) {
            WeChatProductLog weChatProductLog = genernateData();
            String str = JSONObject.toJSONString(weChatProductLog);
            System.out.println(str);
            GenerateDataUtil.postHttpMethod("http://localhost:8081/dwCollect/collectAppData", str);
        }

    }
}
