package com.ganymede.input;

public class PcProductActivity extends PcInputDeviceLog{
    private String activityId; //活动ID
    private String scanTime; //浏览的时间
    private String jumpTime; //跳出的时间
    private String openTime; //打开时间
    private String leaveTime; //离线时间
    private String ip ; //用户app访问的ip

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
}
