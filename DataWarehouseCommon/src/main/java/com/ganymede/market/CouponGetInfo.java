package com.ganymede.market;

public class CouponGetInfo {
    private int id;
    private int userid;
    private int couponId;
    private String couponCreateTime;
    private String couponGetTime;
    private int useStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCouponCreateTime() {
        return couponCreateTime;
    }

    public void setCouponCreateTime(String couponCreateTime) {
        this.couponCreateTime = couponCreateTime;
    }

    public String getCouponGetTime() {
        return couponGetTime;
    }

    public void setCouponGetTime(String couponGetTime) {
        this.couponGetTime = couponGetTime;
    }

    public int getUseStatus() {
        return useStatus;
    }

    public void setUseStatus(int useStatus) {
        this.useStatus = useStatus;
    }
}
