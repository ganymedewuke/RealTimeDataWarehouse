package com.ganymede.mock;


import com.alibaba.fastjson.JSONObject;
import com.ganymede.eums.LogType;
import com.ganymede.input.PcProductCartLog;

import java.util.Random;

public class PcCartGenerateData {


    private static int[] days = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private static Random random = new Random();

    private static String[] cookies = new String[]{"cookie1", "cookie2", "cookie3", "cookie4", "cookie5", "cookie6", "cookie7", "cookie8", ""};
    private static String[] remoteNames = new String[]{"客户端1", "客户端2", "客户端3", "客户端4", "客户端5", "客户端6", "客户端7", "客户端8", "客户端9", ""};
    private static String[] deviceTypes = new String[]{"PC", "MOBILE", "PAD", "MAC"};
    private static String[] oses = new String[]{"windows10", "windows8", "ios10", "centos7", "ios11"};
    private static String[] browers = new String[]{"谷歌", "火狐", "IE"};//浏览器信息
    private static String[] resolutions = new String[]{"480*800", "1200*780", "1080*1024"}; // 分辨率
    private static String[] sourceInfos = new String[]{"百度", "谷歌", "360搜索", ""}; //搜索引擎
    private static String[] sourceTypes = new String[]{"内网", "搜索引擎", "直接输入网址"};// 跳转源类型
    private static String[] srcDomains = new String[]{"www.ganymede.com/asw", "www.baidu.com/abc", ""};//跳转地址

    private static String[] macAddresses = new String[]{"50-2B-73-C4-2C-E7", " 65-2B-73-C4-2C-E7", " 78-2B-73-C4-2C-7C", " 50-2B-73-C4-2C-G1", " 69-2B-73-C4-2E-7H"};//mac地址
    private static String[] userIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};

    private static String[] operatorTypes = new String[]{"1", "0"}; //购物车操作类型

    private static String[] channelIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //频道ID
    private static String[] productTypeIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"};//类别ID
    private static String[] productIds = new String[]{"1", "2", "3", "4", "5", "6", "7", "8"}; //产品ID

    private static String[] deviceIds = new String[]{"deviceId1", "deviceId2", "deviceId3"};
    private static String[] ips = new String[]{"192.168.1.1", "192.168.1.2", "192.168.1.3", "192.168.1.4", "192.168.1.5", "192.168.1.6", "192.168.1.7", "192.168.1.8"}; //用户app访问的ip
    private static String[] countrys = new String[]{"China", "Japan", "Korea", "Singapore", "Germany", "England", "France", "Russia", "America"};// 国家
    private static String[] provinces = new String[]{"Beijing", "Shanghai", "GuangDong", "Guangxi", "Jiangsu"}; //省
    private static String[] citys = new String[]{"Nanjing", "Wuxi", "Guangzhou", "Shenzhen", "Nanning"}; //市


    private static PcProductCartLog genernateData() {
        PcProductCartLog pcProductCartLog = new PcProductCartLog();
        pcProductCartLog.setUserId(userIds[random.nextInt(userIds.length)]);

        pcProductCartLog.setRemoteIP(ips[random.nextInt(ips.length)]);
        pcProductCartLog.setCookie(cookies[random.nextInt(cookies.length)]);
        pcProductCartLog.setRemoteName(remoteNames[random.nextInt(remoteNames.length)]);
        pcProductCartLog.setDeviceType(deviceTypes[random.nextInt(deviceTypes.length)]);
        pcProductCartLog.setOs(oses[random.nextInt(oses.length)]);
        pcProductCartLog.setBrower(browers[random.nextInt(browers.length)]);
        pcProductCartLog.setResolution(resolutions[random.nextInt(resolutions.length)]);
        pcProductCartLog.setSourceType(sourceTypes[random.nextInt(sourceTypes.length)]);
        pcProductCartLog.setSourceInfo(sourceInfos[random.nextInt(sourceInfos.length)]);
        pcProductCartLog.setSrcDomain(srcDomains[random.nextInt(srcDomains.length)]);

        int randomSelect = random.nextInt(2);

        if (randomSelect > 0) {
            pcProductCartLog.setMacAddress(macAddresses[random.nextInt(macAddresses.length)]);
        } else {
            pcProductCartLog.setDeviceId(deviceIds[random.nextInt(deviceIds.length)]);
        }

        pcProductCartLog.setOperatorType(operatorTypes[random.nextInt(operatorTypes.length)]);
        pcProductCartLog.setChannelId(channelIds[random.nextInt(channelIds.length)]);
        pcProductCartLog.setProductId(productIds[random.nextInt(productIds.length)]);
        pcProductCartLog.setProductTypeId(productTypeIds[random.nextInt(productTypeIds.length)]);

        pcProductCartLog.setIp(ips[random.nextInt(ips.length)]);
        pcProductCartLog.setCountry(countrys[random.nextInt(countrys.length)]);
        pcProductCartLog.setProvince(provinces[random.nextInt(provinces.length)]);
        pcProductCartLog.setCity(citys[random.nextInt(citys.length)]);

        long operatorTime = GenerateDataUtil.genernateDateData(days, random);
        pcProductCartLog.setOperatorTime(operatorTime + "");
        pcProductCartLog.setLogType(LogType.PC_CART);
        return pcProductCartLog;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 88; i++) {
            PcProductCartLog pcProductCartLog = genernateData();
            String str = JSONObject.toJSONString(pcProductCartLog);
            System.out.println(str);
            GenerateDataUtil.postHttpMethod("http://localhost:8081/dwCollect/collectAppData", str);
        }

    }
}
