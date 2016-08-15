package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/15.
 */
public class MarketReimburseCreateListResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"CampaignId":"7dd1c8ea-0d61-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000028","Status":3,"Name":"11","CostType":2,"CostTypeName":"国内展览费","OccurTime":"/Date(1471075200000)/","Amount":333,"OwnerName":"姓名","CreatedOn":"/Date(1471062310000)/"},{"CampaignId":"c6dafa78-e05d-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000018","Status":3,"Name":"huodong 000123","CostType":4,"CostTypeName":"彩页","OccurTime":"/Date(1475913600000)/","Amount":96352,"OwnerName":"檀庭","CreatedOn":"/Date(1470712937000)/"},{"CampaignId":"0f8e1f89-aa5a-e611-92fc-085700e64e0f","ApplyNo":"SCSQ201608000014","Status":3,"Name":"shichanghuodong","CostType":2,"CostTypeName":"国内展览费","OccurTime":"/Date(1470470400000)/","Amount":40,"OwnerName":"檀庭","CreatedOn":"/Date(1470359918000)/"}]
     */

    private int errorcode;
    /**
     * CampaignId : 7dd1c8ea-0d61-e611-92fc-085700e64e0f
     * ApplyNo : SCSQ201608000028
     * Status : 3
     * Name : 11
     * CostType : 2
     * CostTypeName : 国内展览费
     * OccurTime : /Date(1471075200000)/
     * Amount : 333
     * OwnerName : 姓名
     * CreatedOn : /Date(1471062310000)/
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
}
