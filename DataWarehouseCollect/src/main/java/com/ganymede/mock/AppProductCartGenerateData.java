package com.ganymede.mock;


import com.alibaba.fastjson.JSONObject;
import com.ganymede.eums.LogType;
import com.ganymede.input.AppProductCartLog;
import com.ganymede.input.AppProductLog;

import java.util.Random;

public class AppProductCartGenerateData {
    private static int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private static Random random = new Random();

    private static String[] userIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};
    private static String[] deviceIds = new String[]{"deviceId1", "deviceId2", "deviceId3"};
    private static String[] appPlatforms = new String[]{"android", "ios"}; //平台，安卓，IOS
    private static String[] deviceStyles = new String[]{"红米8", "小米8", "华为P30"}; //型号
    private static String[] brands = new String[]{"华为", "小米", "苹果"}; //品牌
    private static String[] screenSizes = new String[]{"200*400", "600*800", "1024*1080"}; // 分辨率
    private static String[] osTypes = new String[]{"android4.1", "android8", "android9", "ios10", "ios9"}; //操作系统版本

    private static String[] operatorTypes = new String[]{"1", "0"}; //购物车操作类型

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


    private static AppProductCartLog genernateData() {
        AppProductCartLog appProductCartLog = new AppProductCartLog();
        appProductCartLog.setUserId(userIds[random.nextInt(userIds.length)]);
        appProductCartLog.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);
        appProductCartLog.setAppPlatform(appPlatforms[random.nextInt(appPlatforms.length)]);
        appProductCartLog.setDeviceStyle(deviceStyles[random.nextInt(deviceStyles.length)]);
        appProductCartLog.setBrand(brands[random.nextInt(brands.length)]);
        appProductCartLog.setScreenSize(screenSizes[random.nextInt(screenSizes.length)]);
        appProductCartLog.setOsType(osTypes[random.nextInt(osTypes.length)]);

        appProductCartLog.setOperatorType(operatorTypes[random.nextInt(operatorTypes.length)]);

        appProductCartLog.setChannelId(channelIds[random.nextInt(channelIds.length)]);
        appProductCartLog.setProductId(productIds[random.nextInt(productIds.length)]);
        appProductCartLog.setProductTypeId(productTypeIds[random.nextInt(productTypeIds.length)]);
        appProductCartLog.setIp(ips[random.nextInt(ips.length)]);
        appProductCartLog.setCountry(countrys[random.nextInt(countrys.length)]);
        appProductCartLog.setProvince(provinces[random.nextInt(provinces.length)]);
        appProductCartLog.setCity(citys[random.nextInt(citys.length)]);
        appProductCartLog.setNetwork(networks[random.nextInt(networks.length)]);
        appProductCartLog.setOperator(operators[random.nextInt(operators.length)]);
        appProductCartLog.setAppVersion(appVersions[random.nextInt(appVersions.length)]);
        appProductCartLog.setAppChannel(appChannels[random.nextInt(appChannels.length)]);

        long open = GenerateDataUtil.genernateDateData(days, random);
        appProductCartLog.setOpenTimeStamp(open + "");
        appProductCartLog.setOperatorTime(open + 15 * 1000l + "");
        appProductCartLog.setLeaveTimeStamp(open + 35 * 1000l + "");
        appProductCartLog.setLogType(LogType.APP_CART );
        return appProductCartLog;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 88; i++) {
            AppProductCartLog appProductCartLog = genernateData();
            String str = JSONObject.toJSONString(appProductCartLog);
            System.out.println(str);
            GenerateDataUtil.postHttpMethod("http://localhost:8081/dwCollect/collectAppData", str);
        }
    }
}
