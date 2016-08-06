package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class TravelExpenseReimburseResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"TravelCostId":"69503dbf-e45a-e611-92fc-085700e64e0f","Name":"CLBX201608000021","AuditStatus":3,"StepNumber":1,"SubmitTime":"/Date(1470356120000)/","ApprovalPrice":900,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470384919000)/"},{"TravelCostId":"04c5b786-ba5a-e611-92fc-085700e64e0f","Name":"CLBX201608000020","AuditStatus":2,"StepNumber":1,"SubmitTime":"/Date(1470337986000)/","ApprovalPrice":1443,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470366786000)/"},{"TravelCostId":"f40eacce-3b5a-e611-92fc-085700e64e0f","Name":"CLBX201608000019","AuditStatus":3,"StepNumber":1,"SubmitTime":"/Date(1470283560000)/","ApprovalPrice":240,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470312360000)/"},{"TravelCostId":"3e17997e-335a-e611-92fc-085700e64e0f","Name":"CLBX201608000018","AuditStatus":2,"StepNumber":1,"SubmitTime":"/Date(1470279990000)/","ApprovalPrice":366711,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470308790000)/"},{"TravelCostId":"d507c9c1-285a-e611-92fc-085700e64e0f","Name":"CLBX201608000017","AuditStatus":2,"StepNumber":1,"SubmitTime":"/Date(1470275378000)/","ApprovalPrice":560,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470304178000)/"},{"TravelCostId":"2b90d3c9-275a-e611-92fc-085700e64e0f","Name":"CLBX201608000016","AuditStatus":2,"StepNumber":1,"SubmitTime":"/Date(1470274962000)/","ApprovalPrice":685,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470303762000)/"},{"TravelCostId":"8afe1c4c-f259-e611-92fc-085700e64e0f","Name":"CLBX201608000015","AuditStatus":2,"StepNumber":1,"SubmitTime":"/Date(1470251988000)/","ApprovalPrice":1446,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470280788000)/"},{"TravelCostId":"72e517d5-4259-e611-92fc-085700e64e0f","Name":"CLBX201608000014","AuditStatus":4,"StepNumber":0,"SubmitTime":"/Date(1470176627000)/","ApprovalPrice":3532850,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470205426000)/"},{"TravelCostId":"429babc0-9d58-e611-92fc-085700e64e0f","Name":"CLBX201608000013","AuditStatus":4,"StepNumber":0,"SubmitTime":"/Date(1470105725000)/","ApprovalPrice":50588,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470134525000)/"},{"TravelCostId":"965faf8e-8b58-e611-92fc-085700e64e0f","Name":"CLBX201608000012","AuditStatus":3,"StepNumber":1,"SubmitTime":"/Date(1470097910000)/","ApprovalPrice":1900,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470126710000)/"}]
     */

    private int errorcode;
    /**
     * TravelCostId : 69503dbf-e45a-e611-92fc-085700e64e0f
     * Name : CLBX201608000021
     * AuditStatus : 3
     * StepNumber : 1
     * SubmitTime : /Date(1470356120000)/
     * ApprovalPrice : 900.0
     * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
     * OwnerName : 姓名
     * CreatedOn : /Date(1470384919000)/
     */

    private List<EntityInfoBean> entityInfo;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public List<EntityInfoBean> getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(List<EntityInfoBean> entityInfo) {
        this.entityInfo = entityInfo;
    }

    public static class EntityInfoBean {
        private String TravelCostId;
        private String Name;
        private int AuditStatus;
        private int StepNumber;
        private String SubmitTime;
        private double ApprovalPrice;
        private String OwnerId;
        private String OwnerName;
        private String CreatedOn;

        public String getTravelCostId() {
            return TravelCostId;
        }

        public void setTravelCostId(String TravelCostId) {
            this.TravelCostId = TravelCostId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getAuditStatus() {
            return AuditStatus;
        }

        public void setAuditStatus(int AuditStatus) {
            this.AuditStatus = AuditStatus;
        }

        public int getStepNumber() {
            return StepNumber;
        }

        public void setStepNumber(int StepNumber) {
            this.StepNumber = StepNumber;
        }

        public String getSubmitTime() {
            return SubmitTime;
        }

        public void setSubmitTime(String SubmitTime) {
            this.SubmitTime = SubmitTime;
        }

        public double getApprovalPrice() {
            return ApprovalPrice;
        }

        public void setApprovalPrice(double ApprovalPrice) {
            this.ApprovalPrice = ApprovalPrice;
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
}
