package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class MarketActivityReimbursementResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"CampaignId":"591cf439-e75a-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000007","Status":4,"Name":"100","CostType":2,"OccurTime":"/Date(1470816000000)/","Amount":5000,"OwnerName":"姓名","CreatedOn":"/Date(1470385984000)/"},{"CampaignId":"c8bbdda1-aa5a-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000006","Status":2,"Name":"测试结果显示","CostType":2,"OccurTime":"/Date(1470211200000)/","Amount":2366,"OwnerName":"tanting","CreatedOn":"/Date(1470359959000)/"},{"CampaignId":"44532a1a-3c5a-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000005","Status":2,"Name":"tart ","CostType":4,"OccurTime":"/Date(1469779200000)/","Amount":500,"OwnerName":"姓名","CreatedOn":"/Date(1470312487000)/"},{"CampaignId":"87952f14-325a-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000004","Status":2,"Name":"活动又一个","CostType":2,"OccurTime":"/Date(1475481600000)/","Amount":9888,"OwnerName":"tanting","CreatedOn":"/Date(1470308182000)/"},{"CampaignId":"80801079-6859-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000003","Status":3,"Name":"彩页测试","CostType":1,"OccurTime":"/Date(1467532800000)/","Amount":30,"OwnerName":"姓名","CreatedOn":"/Date(1470221593000)/"},{"CampaignId":"e24a1ff5-5d59-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000002","Status":3,"Name":"show","CostType":2,"OccurTime":"/Date(1469779200000)/","Amount":500,"OwnerName":"姓名","CreatedOn":"/Date(1470217077000)/"},{"CampaignId":"3f3f808e-4c59-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000001","Status":4,"Name":"hhgg ","CostType":2,"OccurTime":"/Date(1469779200000)/","Amount":5000,"OwnerName":"姓名","CreatedOn":"/Date(1470209603000)/"},{"CampaignId":"a59ca9f6-5555-e611-96a5-085700e64e0f","ApplyNo":"SCBX201607000016","Status":3,"Name":"SCSQ201607000007","CostType":2,"OccurTime":"/Date(1467594000000)/","Amount":12345,"OwnerName":"姓名","CreatedOn":"/Date(1469773839000)/"},{"CampaignId":"dc01cb81-4c55-e611-96a5-085700e64e0f","ApplyNo":"SCBX201607000015","Status":2,"Name":"陈陈","CostType":1,"OccurTime":"/Date(1467594000000)/","Amount":2335,"OwnerName":"姓名","CreatedOn":"/Date(1469769777000)/"},{"CampaignId":"e72e92b0-4b55-e611-96a5-085700e64e0f","ApplyNo":"SCBX201607000014","Status":2,"Name":"陈陈","CostType":1,"OccurTime":"/Date(1467594000000)/","Amount":23355,"OwnerName":"姓名","CreatedOn":"/Date(1469769426000)/"}]
     */

    private int errorcode;
    /**
     * CampaignId : 591cf439-e75a-e611-92fc-085700e64e0f
     * ApplyNo : SCBX201608000007
     * Status : 4
     * Name : 100
     * CostType : 2
     * OccurTime : /Date(1470816000000)/
     * Amount : 5000.0
     * OwnerName : 姓名
     * CreatedOn : /Date(1470385984000)/
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
