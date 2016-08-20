package com.android.wandong.beans;

import java.io.Serializable;

/**
 * * 作者：keke on 2016/8/20 15:04
 */
public class EntertainmentReimbursementCreateDetailContent implements Serializable {

    private String Id;
    private String ApplyNo;
    private String AccountId;
    private String AccountName;
    private String Reason;
    private int Number;
    private int Amount;
    private int Status;
    private String OwnerId;
    private String OwnerName;
    private String CreatedOn;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getApplyNo() {
        return ApplyNo;
    }

    public void setApplyNo(String ApplyNo) {
        this.ApplyNo = ApplyNo;
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

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String OwnerId) {
        this.OwnerId = OwnerId;
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
