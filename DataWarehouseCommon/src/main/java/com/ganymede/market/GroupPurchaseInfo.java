package com.ganymede.market;

public class GroupPurchaseInfo {
    private int id;
    private String groupPurchaseName;
    private long groupPurchaseTotalNum; //团购的总数量
    private long groupPurchaseNum; //团购成功的数量
    private String startTime;
    private String endTime;
    private int productId;
    private int merchantId;
    private int shopId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupPurchaseName() {
        return groupPurchaseName;
    }

    public void setGroupPurchaseName(String groupPurchaseName) {
        this.groupPurchaseName = groupPurchaseName;
    }

    public long getGroupPurchaseTotalNum() {
        return groupPurchaseTotalNum;
    }

    public void setGroupPurchaseTotalNum(long groupPurchaseTotalNum) {
        this.groupPurchaseTotalNum = groupPurchaseTotalNum;
    }

    public long getGroupPurchaseNum() {
        return groupPurchaseNum;
    }

    public void setGroupPurchaseNum(long groupPurchaseNum) {
        this.groupPurchaseNum = groupPurchaseNum;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
