package com.ganymede.mock;


import com.alibaba.fastjson.JSONObject;
import com.ganymede.eums.LogType;
import com.ganymede.input.WeChatProductActivity;

import java.util.Random;

public class WeChatActivityGenerateData {
    private static int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private static Random random = new Random();

    private static String[] weChatAccoutInfos = new String[]{"zhangsan==张三==男==上海", "lisi==李四==男==北京", "wangwu==王五==女==广州"};
    private static String[] userIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private static String[] deviceIds = new String[]{"deviceId1", "deviceId2", "deviceId3"};
    private static String[] activityIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //活动ID
    private static String[] ips = new String[]{"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7", "192.168.1.8"}; //用户app访问的ip
    private static String[] countrys = new String[]{"China", "Japan", "Korea", "Singapore", "Germany", "England", "France", "Russia", "America"};// 国家
    private static String[] provinces = new String[]{"Beijing", "Shanghai", "GuangDong", "Guangxi", "Jiangsu"}; //省
    private static String[] citys = new String[]{"Nanjing", "Wuxi", "Guangzhou", "Shenzhen", "Nanning"}; //市


    private static WeChatProductActivity genernateData() {
        WeChatProductActivity weChatProductActivity = new WeChatProductActivity();
        weChatProductActivity.setUserId(userIds[random.nextInt(userIds.length)]);

        String weChatInfo = weChatAccoutInfos[random.nextInt(weChatAccoutInfos.length)];
        String[] info = weChatInfo.split("==");

        weChatProductActivity.setWeChatAccount(info[0]);
        weChatProductActivity.setWeChatName(info[1]);
        weChatProductActivity.setWeChatSex(info[2]);
        weChatProductActivity.setWeChatArea(info[3]);

        weChatProductActivity.setWeChatAccount(info[0]);
        weChatProductActivity.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);

        weChatProductActivity.setActivityId(activityIds[random.nextInt(activityIds.length)]);

        weChatProductActivity.setIp(ips[random.nextInt(ips.length)]);
        weChatProductActivity.setCountry(countrys[random.nextInt(countrys.length)]);
        weChatProductActivity.setProvince(provinces[random.nextInt(provinces.length)]);
        weChatProductActivity.setCity(citys[random.nextInt(citys.length)]);

        long open = GenerateDataUtil.genernateDateData(days, random);
        weChatProductActivity.setOpenTime(open + "");
        weChatProductActivity.setScanTime(open + 5 * 1000l + "");
        weChatProductActivity.setJumpTime(open + 10 * 1000l + "");
        weChatProductActivity.setLeaveTime(open + 15 * 1000l + "");
        weChatProductActivity.setLogType(LogType.WECHAT_ACTIVITY);
        return weChatProductActivity;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 88; i++) {
            WeChatProductActivity weChatProductActivity = genernateData();
            String str = JSONObject.toJSONString(weChatProductActivity);
            System.out.println(str);
            GenerateDataUtil.postHttpMethod("http://localhost:8081/dwCollect/collectAppData", str);
        }

    }
}
