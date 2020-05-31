package com.ganymede.mock;


import com.alibaba.fastjson.JSONObject;
import com.ganymede.eums.LogType;
import com.ganymede.input.AppProductActivity;
import com.ganymede.input.AppProductLog;

import java.util.Random;

public class AppProductActivityGenerateData {
    private static int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private static Random random = new Random();

    private static String[] userIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private static String[] deviceIds = new String[]{"deviceId1", "deviceId2", "deviceId3"};

    private static String[] activityIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //活动ID

    private static String[] appPlatforms = new String[]{"android", "ios"}; //平台，安卓，IOS
    private static String[] deviceStyles = new String[]{"红米8", "小米8", "华为P30"}; //型号
    private static String[] brands = new String[]{"华为", "小米", "苹果"}; //品牌
    private static String[] screenSizes = new String[]{"200*400", "600*800", "1024*1080"}; // 分辨率
    private static String[] osTypes = new String[]{"android4.1", "android8", "android9", "ios10", "ios9"}; //操作系统版本

    private static String[] ips = new String[]{"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7", "192.168.1.8"}; //用户app访问的ip
    private static String[] countrys = new String[]{"China", "Japan", "Korea", "Singapore", "Germany", "England", "France", "Russia", "America"};// 国家
    private static String[] provinces = new String[]{"Beijing", "Shanghai", "GuangDong", "Guangxi", "Jiangsu"}; //省
    private static String[] citys = new String[]{"Nanjing", "Wuxi", "Guangzhou", "Shenzhen", "Nanning"}; //市
    private static String[] networks = new String[]{"WIFI", "4G", "5G"};//网络方式
    private static String[] operators = new String[]{"联通", "移动", "电信"};//运营商
    private static String[] appVersions = new String[]{"4.5.1", "4.5.6", "3.5.6", "8.5.8"};//app版本
    private static String[] appChannels = new String[]{"安卓市场", "小米市场"}; //渠道


    private static AppProductActivity genernateData() {
        AppProductActivity appProductActivity = new AppProductActivity();
        appProductActivity.setUserId(userIds[random.nextInt(userIds.length)]);
        appProductActivity.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);
        appProductActivity.setAppPlatform(appPlatforms[random.nextInt(appPlatforms.length)]);
        appProductActivity.setDeviceStyle(deviceStyles[random.nextInt(deviceStyles.length)]);
        appProductActivity.setBrand(brands[random.nextInt(brands.length)]);
        appProductActivity.setScreenSize(screenSizes[random.nextInt(screenSizes.length)]);
        appProductActivity.setOsType(osTypes[random.nextInt(osTypes.length)]);
        appProductActivity.setActivityId(activityIds[random.nextInt(activityIds.length)]);

        appProductActivity.setIp(ips[random.nextInt(ips.length)]);
        appProductActivity.setCountry(countrys[random.nextInt(countrys.length)]);
        appProductActivity.setProvince(provinces[random.nextInt(provinces.length)]);
        appProductActivity.setCity(citys[random.nextInt(citys.length)]);
        appProductActivity.setNetwork(networks[random.nextInt(networks.length)]);
        appProductActivity.setOperator(operators[random.nextInt(operators.length)]);
        appProductActivity.setAppVersion(appVersions[random.nextInt(appVersions.length)]);
        appProductActivity.setAppChannel(appChannels[random.nextInt(appChannels.length)]);

        long open = GenerateDataUtil.genernateDateData(days, random);
        appProductActivity.setOpenTimeStamp(open + "");
        appProductActivity.setScanTime(open + 5 * 1000l + "");
        appProductActivity.setJumpTime(open + 10 * 1000l + "");
        appProductActivity.setLeaveTimeStamp(open + 15 * 1000l + "");
        appProductActivity.setLogType(LogType.APP_ACTIVITY);
        return appProductActivity;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 88; i++) {
            AppProductActivity appProductActivity = genernateData();
            String str = JSONObject.toJSONString(appProductActivity);
            System.out.println(str);
            GenerateDataUtil.postHttpMethod("http://localhost:8081/dwCollect/collectAppData", str);
        }
    }
}
