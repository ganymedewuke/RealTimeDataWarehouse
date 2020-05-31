package com.ganymede.market;

public class RedEnvelopeNameInfo {
    private int id;
    private String redEnvelopeName;
    private double amount;
    private int userId;
    private String startTime;
    private String endTime;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRedEnvelopeName() {
        return redEnvelopeName;
    }

    public void setRedEnvelopeName(String redEnvelopeName) {
        this.redEnvelopeName = redEnvelopeName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
