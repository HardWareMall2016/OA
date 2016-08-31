package com.android.wandong.beans;

import java.io.Serializable;

/**
 * 作者：蒲柯柯 on 2016/8/31 11:50
 * 邮箱：983198505@qq.com
 * 介绍:
 */
public class MarketReimburseDetailReplyContent implements Serializable {

    private String Name;
    private String CampaignName;
    private String CostTypeName;
    private String AccountName;
    private String OwnerName;
    private double Amount;
    private String CreatedOn;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCampaignName() {
        return CampaignName;
    }

    public void setCampaignName(String campaignName) {
        CampaignName = campaignName;
    }

    public String getCostTypeName() {
        return CostTypeName;
    }

    public void setCostTypeName(String costTypeName) {
        CostTypeName = costTypeName;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }
}
