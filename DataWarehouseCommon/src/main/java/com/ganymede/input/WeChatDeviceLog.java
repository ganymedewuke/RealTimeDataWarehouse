package com.ganymede.input;

public class WeChatDeviceLog extends LogParent {
    private String userId;
    private String deviceId; // 设备ID
    private String weChatAccount; //微信号
    private String weChatName;//微信昵称
    private String weChatSex; //微信性别信息
    private String weChatArea; //微信地区
    private String openTime; //打开小程序时间
    private String leaveTime;//离开小程序时间
    private String country;// 国家
    private String province; //省
    private String city; //市

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getWeChatAccount() {
        return weChatAccount;
    }

    public void setWeChatAccount(String weChatAccount) {
        this.weChatAccount = weChatAccount;
    }

    public String getWeChatName() {
        return weChatName;
    }

    public void setWeChatName(String weChatName) {
        this.weChatName = weChatName;
    }

    public String getWeChatSex() {
        return weChatSex;
    }

    public void setWeChatSex(String weChatSex) {
        this.weChatSex = weChatSex;
    }

    public String getWeChatArea() {
        return weChatArea;
    }

    public void setWeChatArea(String weChatArea) {
        this.weChatArea = weChatArea;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }
}
