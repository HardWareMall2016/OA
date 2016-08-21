package com.android.wandong.beans;

import java.io.Serializable;

/**
 * * 作者：keke on 2016/8/20 15:04
 */
public class EntertainmentReimbursementCreateDetailContent implements Serializable {
    private String EntertainId;
    private String ApplyNo;
    private int EstimateTotal;
    private String AccountId;
    private String AccountName;
    private String Reason;
    private int Number;
    private String PersonalImage;
    private String OwnerName;
    private String CreatedOn;
    private int Status;

    public String getEntertainId() {
        return EntertainId;
    }

    public void setEntertainId(String EntertainId) {
        this.EntertainId = EntertainId;
    }

    public String getApplyNo() {
        return ApplyNo;
    }

    public void setApplyNo(String ApplyNo) {
        this.ApplyNo = ApplyNo;
    }

    public int getEstimateTotal() {
        return EstimateTotal;
    }

    public void setEstimateTotal(int EstimateTotal) {
        this.EstimateTotal = EstimateTotal;
    }

    public String getAccountId() {
        return AccountId;
    }

    public void setAccountId(String AccountId) {
        this.AccountId = AccountId;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String AccountName) {
        this.AccountName = AccountName;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String Reason) {
        this.Reason = Reason;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public String getPersonalImage() {
        return PersonalImage;
    }

    public void setPersonalImage(String PersonalImage) {
        this.PersonalImage = PersonalImage;
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
}
