package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * * 作者：keke on 2016/8/20 13:20
 */
public class EntertainExpenseCreateListResponseBean extends BaseResponseBean{
    /**
     * errorcode : 0
     * entityInfo : [{"EntertainId":"49983671-a65e-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000026","EstimateTotal":1554,"AccountId":"5e40c2e6-5516-e611-ac23-085700e64e0f","AccountName":"高平武承谋骨伤专科医院","Reason":"Tgro","Number":3,"PersonalImage":"UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg","OwnerName":"姓名","CreatedOn":"/Date(1470797964000)/","Status":3}]
     */

    private int errorcode;
    /**
     * EntertainId : 49983671-a65e-e611-92fc-085700e64e0f
     * ApplyNo : ZDSQ201608000026
     * EstimateTotal : 1554
     * AccountId : 5e40c2e6-5516-e611-ac23-085700e64e0f
     * AccountName : 高平武承谋骨伤专科医院
     * Reason : Tgro
     * Number : 3
     * PersonalImage : UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg
     * OwnerName : 姓名
     * CreatedOn : /Date(1470797964000)/
     * Status : 3
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
        private String EntertainId;
        private String ApplyNo;
        private int EstimateTotal;
        private String AccountId;
        private String AccountName;
        private String Reason;
        private int Number;
        private String PersonalImage;
        private String OwnerName;
        private String CreatedOn;
        private int Status;

        public String getEntertainId() {
            return EntertainId;
        }

        public void setEntertainId(String EntertainId) {
            this.EntertainId = EntertainId;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public int getEstimateTotal() {
            return EstimateTotal;
        }

        public void setEstimateTotal(int EstimateTotal) {
            this.EstimateTotal = EstimateTotal;
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

        public String getPersonalImage() {
            return PersonalImage;
        }

        public void setPersonalImage(String PersonalImage) {
            this.PersonalImage = PersonalImage;
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

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }
    }
}
