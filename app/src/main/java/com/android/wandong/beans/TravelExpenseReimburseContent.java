package com.android.wandong.beans;

import java.io.Serializable;

/**
 * Created by ${keke} on 16/8/7.
 */
public class TravelExpenseReimburseContent implements Serializable {

    private String AuditStatus;
    private String StepNumber ;
    private String TravelCostId ;
    private String ApprovalPrice ;
    private String CreatedOn ;

    public String getApprovalPrice() {
        return ApprovalPrice;
    }

    public void setApprovalPrice(String approvalPrice) {
        ApprovalPrice = approvalPrice;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }


    public String getAuditStatus() {
        return AuditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        AuditStatus = auditStatus;
    }

    public String getStepNumber() {
        return StepNumber;
    }

    public void setStepNumber(String stepNumber) {
        StepNumber = stepNumber;
    }

    public String getTravelCostId() {
        return TravelCostId;
    }

    public void setTravelCostId(String travelCostId) {
        TravelCostId = travelCostId;
    }

}
