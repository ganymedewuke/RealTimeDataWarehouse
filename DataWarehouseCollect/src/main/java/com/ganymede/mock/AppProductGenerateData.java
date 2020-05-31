package com.ganymede.mock;


import com.alibaba.fastjson.JSONObject;
import com.ganymede.eums.LogType;
import com.ganymede.input.AppProductLog;

import java.util.Random;

public class AppProductGenerateData {

    private static int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private static Random random = new Random();

    private static String[] userIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private static String[] deviceIds = new String[]{"deviceId1", "deviceId2", "deviceId3"};
    private static String[] appPlatforms = new String[]{"android", "ios"}; //平台，安卓，IOS
    private static String[] deviceStyles = new String[]{"红米8", "小米8", "华为P30"}; //型号
    private static String[] brands = new String[]{"华为", "小米", "苹果"}; //品牌
    private static String[] screenSizes = new String[]{"200*400", "600*800", "1024*1080"}; // 分辨率
    private static String[] osTypes = new String[]{"android4.1", "android8", "android9", "ios10", "ios9"}; //操作系统版本

    private static String[] channelIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //频道ID
    private static String[] productTypeIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};//类别ID
    private static String[] productIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //产品ID

    private static String[] ips = new String[]{"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7", "192.168.1.8"}; //用户app访问的ip
    private static String[] countrys = new String[]{"China", "Japan", "Korea", "Singapore", "Germany", "England", "France", "Russia", "America"};// 国家
    private static String[] provinces = new String[]{"Beijing", "Shanghai", "GuangDong", "Guangxi", "Jiangsu"}; //省
    private static String[] citys = new String[]{"Nanjing", "Wuxi", "Guangzhou", "Shenzhen", "Nanning"}; //市
    private static String[] networks = new String[]{"WIFI", "4G", "5G"};//网络方式
    private static String[] operators = new String[]{"联通", "移动", "电信"};//运营商
    private static String[] appVersions = new String[]{"4.5.1", "4.5.6", "3.5.6", "8.5.8"};//app版本
    private static String[] appChannels = new String[]{"安卓市场", "小米市场"}; //渠道


    private static AppProductLog genernateData() {
        AppProductLog appProductLog = new AppProductLog();
        appProductLog.setUserId(userIds[random.nextInt(userIds.length)]);
        appProductLog.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);
        appProductLog.setAppPlatform(appPlatforms[random.nextInt(appPlatforms.length)]);
        appProductLog.setDeviceStyle(deviceStyles[random.nextInt(deviceStyles.length)]);
        appProductLog.setBrand(brands[random.nextInt(brands.length)]);
        appProductLog.setScreenSize(screenSizes[random.nextInt(screenSizes.length)]);
        appProductLog.setOsType(osTypes[random.nextInt(osTypes.length)]);

        appProductLog.setChannelId(channelIds[random.nextInt(channelIds.length)]);
        appProductLog.setProductId(productIds[random.nextInt(productIds.length)]);
        appProductLog.setProductTypeId(productTypeIds[random.nextInt(productTypeIds.length)]);
        appProductLog.setIp(ips[random.nextInt(ips.length)]);
        appProductLog.setCountry(countrys[random.nextInt(countrys.length)]);
        appProductLog.setProvince(provinces[random.nextInt(provinces.length)]);
        appProductLog.setCity(citys[random.nextInt(citys.length)]);
        appProductLog.setNetwork(networks[random.nextInt(networks.length)]);
        appProductLog.setOperator(operators[random.nextInt(operators.length)]);
        appProductLog.setAppVersion(appVersions[random.nextInt(appVersions.length)]);
        appProductLog.setAppChannel(appChannels[random.nextInt(appChannels.length)]);

        long open = GenerateDataUtil.genernateDateData(days, random);
        appProductLog.setOpenTimeStamp(open + "");
        appProductLog.setScanTime(open + 5 * 1000l + "");
        appProductLog.setJumpTime(open + 10 * 1000l + "");
        appProductLog.setLeaveTimeStamp(open + 15 * 1000l + "");
        appProductLog.setLogType(LogType.APP_PRODUCT);
        return appProductLog;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 88; i++) {
            AppProductLog appProductLog = genernateData();
            String str = JSONObject.toJSONString(appProductLog);
            System.out.println(str);
            GenerateDataUtil.postHttpMethod("http://localhost:8081/dwCollect/collectAppData", str);
        }
    }
}
