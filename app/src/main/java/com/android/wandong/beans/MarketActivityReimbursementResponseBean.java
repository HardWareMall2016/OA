package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class MarketActivityReimbursementResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"CampaignId":"09f4c329-1d66-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000022","Status":2,"Name":"活动名称","CostType":4,"CostTypeName":"彩页","OccurTime":"/Date(1471507200000)/","Amount":109,"OwnerName":"姓名","CreatedOn":"/Date(1471618613000)/"},{"CampaignId":"8566c918-0066-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000021","Status":2,"Name":"脱衣舞","CostType":1,"CostTypeName":"广告宣传费","OccurTime":"/Date(1503043200000)/","Amount":10,"OwnerName":"姓名","CreatedOn":"/Date(1471606129000)/"},{"CampaignId":"36e878e9-f365-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000020","Status":2,"Name":"shichanghuodong","CostType":2,"CostTypeName":"国内展览费","OccurTime":"/Date(1470470400000)/","Amount":38,"OwnerName":"檀庭","CreatedOn":"/Date(1471600895000)/"},{"CampaignId":"16b78703-d965-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000019","Status":3,"Name":"11","CostType":2,"CostTypeName":"国内展览费","OccurTime":"/Date(1471075200000)/","Amount":333,"OwnerName":"姓名","CreatedOn":"/Date(1471589343000)/"},{"CampaignId":"dfe63c44-ff62-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000018","Status":3,"Name":"huodong 000123","CostType":4,"CostTypeName":"彩页","OccurTime":"/Date(1475913600000)/","Amount":96352,"OwnerName":"檀庭","CreatedOn":"/Date(1471275919000)/"},{"CampaignId":"75b16025-af62-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000017","Status":3,"Name":"tr ","CostType":2,"CostTypeName":"国内展览费","OccurTime":"/Date(1470988800000)/","Amount":2222,"OwnerName":"姓名","CreatedOn":"/Date(1471241509000)/"},{"CampaignId":"71b16025-af62-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000016","Status":3,"Name":"tr ","CostType":2,"CostTypeName":"国内展览费","OccurTime":"/Date(1470988800000)/","Amount":2222,"OwnerName":"姓名","CreatedOn":"/Date(1471241507000)/"},{"CampaignId":"2588afa1-1e61-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000015","Status":3,"Name":"彩页测试","CostType":4,"CostTypeName":"彩页","OccurTime":"/Date(1467532800000)/","Amount":0,"OwnerName":"姓名","CreatedOn":"/Date(1471069488000)/"},{"CampaignId":"e4981b1a-9a5f-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000014","Status":3,"Name":"一","CostType":2,"CostTypeName":"国内展览费","OccurTime":"/Date(1502265600000)/","Amount":1.25588882E8,"OwnerName":"姓名","CreatedOn":"/Date(1470902615000)/"},{"CampaignId":"c48cada9-9f5e-e611-92fc-085700e64e0f","ApplyNo":"SCBX201608000010","Status":3,"Name":"好的","CostType":2,"CostTypeName":"国内展览费","OccurTime":"/Date(1476000000000)/","Amount":1.2356686E7,"OwnerName":"姓名","CreatedOn":"/Date(1470795059000)/"}]
     */

    private int errorcode;
    /**
     * CampaignId : 09f4c329-1d66-e611-92fc-085700e64e0f
     * ApplyNo : SCBX201608000022
     * Status : 2
     * Name : 活动名称
     * CostType : 4
     * CostTypeName : 彩页
     * OccurTime : /Date(1471507200000)/
     * Amount : 109.0
     * OwnerName : 姓名
     * CreatedOn : /Date(1471618613000)/
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
