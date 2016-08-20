package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * * 作者：keke on 2016/8/20 13:20
 */
public class EntertainExpenseCreateListResponseBean extends BaseResponseBean{
    /**
     * errorcode : 0
     * entityInfo : [{"Id":"95b18cbd-5a59-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000011","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"客户来了","Number":5,"Amount":9830,"Status":3,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470215695000)/"},{"Id":"b5ee613b-c541-e611-9105-085700e64e0f","ApplyNo":"ZDBX201607000002","AccountId":"1040c2e6-5516-e611-ac23-085700e64e0f","AccountName":"巴州区红十字医院（巴中红十字医院）","Reason":"招待费测试","Number":1,"Amount":0,"Status":3,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1467622605000)/"}]
     */

    private int errorcode;
    /**
     * Id : 95b18cbd-5a59-e611-92fc-085700e64e0f
     * ApplyNo : ZDBX201608000011
     * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
     * AccountName : 襄城区余家湖社区卫生服务中心
     * Reason : 客户来了
     * Number : 5
     * Amount : 9830
     * Status : 3
     * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
     * OwnerName : 姓名
     * CreatedOn : /Date(1470215695000)/
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
}
