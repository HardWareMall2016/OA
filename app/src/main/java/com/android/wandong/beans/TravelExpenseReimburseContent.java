package com.android.wandong.beans;

import java.io.Serializable;

/**
 * Created by ${keke} on 16/8/7.
 */
public class TravelExpenseReimburseContent implements Serializable {

    private String AuditStatus;
    private String StepNumber ;
    private String TravelCostId ;

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
