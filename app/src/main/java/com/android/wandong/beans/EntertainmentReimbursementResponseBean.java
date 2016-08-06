package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class EntertainmentReimbursementResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"Id":"6c733482-df5a-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000018","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"12344567890123456789234567890123456789123456789034567890345678901234567890234567890","Number":11,"Amount":3531,"Status":4,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470382670000)/"},{"Id":"48532a1a-3c5a-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000017","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"这些是从","Number":5319,"Amount":56726,"Status":4,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470312493000)/"},{"Id":"4a1ae667-325a-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000016","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"有朋自远方来","Number":6,"Amount":8888,"Status":2,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470308322000)/"},{"Id":"e8013dd3-0b5a-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000015","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"Guosr ","Number":887,"Amount":1002551,"Status":2,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470291752000)/"},{"Id":"b964acdf-035a-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000014","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"想吃","Number":88,"Amount":56005,"Status":2,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470288337000)/"},{"Id":"803c3c6f-6c59-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000013","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"呵呵","Number":50,"Amount":1405,"Status":2,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470223294000)/"},{"Id":"aa092e31-6b59-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000012","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"测试","Number":10,"Amount":20540,"Status":2,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470222761000)/"},{"Id":"95b18cbd-5a59-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000011","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"客户来了","Number":5,"Amount":9830,"Status":3,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470215695000)/"},{"Id":"6263d041-4f59-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000009","AccountId":"e23fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"保山仁济医院","Reason":"招待费测试","Number":1,"Amount":0,"Status":1,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470210764000)/"},{"Id":"6663d041-4f59-e611-92fc-085700e64e0f","ApplyNo":"ZDBX201608000010","AccountId":"e23fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"保山仁济医院","Reason":"招待费测试","Number":1,"Amount":0,"Status":2,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470210764000)/"}]
     */

    private int errorcode;
    /**
     * Id : 6c733482-df5a-e611-92fc-085700e64e0f
     * ApplyNo : ZDBX201608000018
     * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
     * AccountName : 襄城区余家湖社区卫生服务中心
     * Reason : 12344567890123456789234567890123456789123456789034567890345678901234567890234567890
     * Number : 11
     * Amount : 3531.0
     * Status : 4
     * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
     * OwnerName : 姓名
     * CreatedOn : /Date(1470382670000)/
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
        private double Amount;
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

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
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
