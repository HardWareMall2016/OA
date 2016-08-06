package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class MarketActivityResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"CampaignId":"ad465fe2-e15a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000016","Status":3,"Name":"100","CostType":2,"OccurTime":"/Date(1470816000000)/","Amount":200,"OwnerName":"姓名","CreatedOn":"/Date(1470383690000)/"},{"CampaignId":"2aec136e-e15a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000015","Status":4,"Name":"名","CostType":2,"OccurTime":"/Date(1470470400000)/","Amount":1000,"OwnerName":"姓名","CreatedOn":"/Date(1470383495000)/"},{"CampaignId":"0f8e1f89-aa5a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000014","Status":2,"Name":"shichanghuodong","CostType":2,"OccurTime":"/Date(1470470400000)/","Amount":40,"OwnerName":"tanting","CreatedOn":"/Date(1470359918000)/"},{"CampaignId":"eb59defd-3a5a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000013","Status":4,"Name":"你就","CostType":2,"OccurTime":"/Date(1470211200000)/","Amount":236589,"OwnerName":"tanting","CreatedOn":"/Date(1470312010000)/"},{"CampaignId":"fb9500e0-3a5a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000012","Status":3,"Name":"测试结果显示","CostType":2,"OccurTime":"/Date(1470211200000)/","Amount":2365,"OwnerName":"tanting","CreatedOn":"/Date(1470311960000)/"},{"CampaignId":"7756bead-265a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000011","Status":3,"Name":"活动又一个","CostType":2,"OccurTime":"/Date(1475481600000)/","Amount":9000,"OwnerName":"tanting","CreatedOn":"/Date(1470303286000)/"},{"CampaignId":"bd8da077-265a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000010","Status":1,"Name":"活动中心","CostType":2,"OccurTime":"/Date(1475481600000)/","Amount":500,"OwnerName":"tanting","CreatedOn":"/Date(1470303195000)/"},{"CampaignId":"46e0eeec-255a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000009","Status":2,"Name":"哟哟哟","CostType":2,"OccurTime":"/Date(1475308800000)/","Amount":58800,"OwnerName":"姓名","CreatedOn":"/Date(1470302962000)/"},{"CampaignId":"51dd6b96-255a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000008","Status":1,"Name":"举办活动","CostType":2,"OccurTime":"/Date(1475481600000)/","Amount":500896,"OwnerName":"tanting","CreatedOn":"/Date(1470302821000)/"},{"CampaignId":"50dd6b96-255a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000007","Status":1,"Name":"举办活动","CostType":2,"OccurTime":"/Date(1475481600000)/","Amount":500896,"OwnerName":"tanting","CreatedOn":"/Date(1470302817000)/"}]
     */

    private int errorcode;
    /**
     * CampaignId : ad465fe2-e15a-e611-92fc-085700e64e0f
     * ApplyNo : SCSQ201608000016
     * Status : 3
     * Name : 100
     * CostType : 2
     * OccurTime : /Date(1470816000000)/
     * Amount : 200.0
     * OwnerName : 姓名
     * CreatedOn : /Date(1470383690000)/
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
        private String CampaignId;
        private String ApplyNo;
        private int Status;
        private String Name;
        private int CostType;
        private String OccurTime;
        private double Amount;
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

        public String getOccurTime() {
            return OccurTime;
        }

        public void setOccurTime(String OccurTime) {
            this.OccurTime = OccurTime;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
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
}
