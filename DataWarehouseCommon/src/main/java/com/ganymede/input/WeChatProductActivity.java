package com.ganymede.input;

public class WeChatProductActivity extends WeChatDeviceLog {
    private String activityId; //活动ID
    private String scanTime; //浏览的时间
    private String jumpTime; //跳出商品的时间
    private String ip; //用户app访问的ip

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getScanTime() {
        return scanTime;
    }

    public void setScanTime(String scanTime) {
        this.scanTime = scanTime;
    }

    public String getJumpTime() {
        return jumpTime;
    }

    public void setJumpTime(String jumpTime) {
        this.jumpTime = jumpTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
