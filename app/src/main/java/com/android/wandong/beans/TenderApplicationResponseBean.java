package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class TenderApplicationResponseBean extends BaseResponseBean{
    /**
     * errorcode : 0
     * entityInfo : [{"TenderAuthorizationId":"f1630972-db5a-e611-92fc-085700e64e0f","ApplyNo":"TBSQ201608000007","Name":"i_Open 0.3T","BidStatus":1,"Number":"001","AccountName":null,"OwnerName":"tanting","CreatedOn":"/Date(1470380924000)/","Status":2},{"TenderAuthorizationId":"04a45c87-275a-e611-92fc-085700e64e0f","ApplyNo":"TBSQ201608000006","Name":"i_Magnate 1.5T-进口磁体","BidStatus":1,"Number":"1001","AccountName":null,"OwnerName":"tanting","CreatedOn":"/Date(1470303651000)/","Status":4},{"TenderAuthorizationId":"76e5d2b5-095a-e611-92fc-085700e64e0f","ApplyNo":"TBSQ201608000005","Name":"CGO-2100-01","BidStatus":1,"Number":"2222","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1470290844000)/","Status":4},{"TenderAuthorizationId":"db379b65-7159-e611-92fc-085700e64e0f","ApplyNo":"TBSQ201608000004","Name":"i_Magnate 1.5T-进口磁体","BidStatus":1,"Number":"500","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1470225426000)/","Status":2},{"TenderAuthorizationId":"7c8f23bf-7059-e611-92fc-085700e64e0f","ApplyNo":"TBSQ201608000003","Name":"DM-1型","BidStatus":1,"Number":"编号666","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1470225146000)/","Status":2},{"TenderAuthorizationId":"f13d5a0a-d457-e611-92fc-085700e64e0f","ApplyNo":"TBSQ201608000002","Name":"i_Open 0.3T","BidStatus":1,"Number":"常规化","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1470047890000)/","Status":2},{"TenderAuthorizationId":"956bdd72-c557-e611-92fc-085700e64e0f","ApplyNo":"TBSQ201608000001","Name":"DRF-1C型","BidStatus":1,"Number":"www011","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1470041623000)/","Status":2},{"TenderAuthorizationId":"ceab1a8c-5f55-e611-96a5-085700e64e0f","ApplyNo":"TBSQ201607000009","Name":"F108-V型","BidStatus":1,"Number":"编号111","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1469777955000)/","Status":2},{"TenderAuthorizationId":"abdb8686-5b55-e611-96a5-085700e64e0f","ApplyNo":"TBSQ201607000008","Name":"DRF-1B型","BidStatus":1,"Number":"编号001","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1469776227000)/","Status":2},{"TenderAuthorizationId":"5827dc1f-7754-e611-be6c-085700e64e0f","ApplyNo":"TBSQ201607000007","Name":"DRF-2B型","BidStatus":1,"Number":"000000001","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1469678130000)/","Status":2}]
     */

    private int errorcode;
    /**
     * TenderAuthorizationId : f1630972-db5a-e611-92fc-085700e64e0f
     * ApplyNo : TBSQ201608000007
     * Name : i_Open 0.3T
     * BidStatus : 1
     * Number : 001
     * AccountName : null
     * OwnerName : tanting
     * CreatedOn : /Date(1470380924000)/
     * Status : 2
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
        private String TenderAuthorizationId;
        private String ApplyNo;
        private String Name;
        private int BidStatus;
        private String Number;
        private String AccountName;
        private String OwnerName;
        private String CreatedOn;
        private int Status;

        public String getTenderAuthorizationId() {
            return TenderAuthorizationId;
        }

        public void setTenderAuthorizationId(String TenderAuthorizationId) {
            this.TenderAuthorizationId = TenderAuthorizationId;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getBidStatus() {
            return BidStatus;
        }

        public void setBidStatus(int BidStatus) {
            this.BidStatus = BidStatus;
        }

        public String getNumber() {
            return Number;
        }

        public void setNumber(String Number) {
            this.Number = Number;
        }

        public String getAccountName() {
            return AccountName;
        }

        public void setAccountName(String AccountName) {
            this.AccountName = AccountName;
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
