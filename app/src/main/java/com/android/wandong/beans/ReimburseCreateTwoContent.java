package com.android.wandong.beans;

import java.io.Serializable;

/**
 * Created by ${keke} on 16/8/16.
 */
public class ReimburseCreateTwoContent implements Serializable {

    private String CampaignId;
    private String ApplyNo;
    private int Status;
    private String Name;
    private int CostType;
    private String CostTypeName;
    private String OccurTime;
    private int Amount;
    private String OwnerName;
    private String CreatedOn;

    public String getCampaignId() {
        return CampaignId;
    }

    public void setCampaignId(String CampaignId) {
        this.CampaignId = CampaignId;
    }

    public String getApplyNo() {
        return ApplyNo;
    }

    public void setApplyNo(String ApplyNo) {
        this.ApplyNo = ApplyNo;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCostType() {
        return CostType;
    }

    public void setCostType(int CostType) {
        this.CostType = CostType;
    }

    public String getCostTypeName() {
        return CostTypeName;
    }

    public void setCostTypeName(String CostTypeName) {
        this.CostTypeName = CostTypeName;
    }

    public String getOccurTime() {
        return OccurTime;
    }

    public void setOccurTime(String OccurTime) {
        this.OccurTime = OccurTime;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String CreatedOn) {
        this.CreatedOn = CreatedOn;
    }
}
