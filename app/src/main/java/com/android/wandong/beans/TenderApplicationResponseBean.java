package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class TenderApplicationResponseBean extends BaseResponseBean{
    /**
     * errorcode : 0
     * entityInfo : [{"TenderAuthorizationId":"4921b933-dc69-e611-92fc-085700e64e0f","ProjectName":"测试","ApplyNo":"TBSQ201608000024","Name":"LS-3型","BidStatus":1,"OpenTendersTime":"/Date(1474617600000)/","Quantity":12,"Number":"测试001","AccountName":null,"OwnerName":"檀庭","CreatedOn":"/Date(1472030517000)/","Status":2},{"TenderAuthorizationId":"71b73ec9-1468-e611-92fc-085700e64e0f","ProjectName":"地级市区","ApplyNo":"TBSQ201608000023","Name":"LS-3型","BidStatus":1,"OpenTendersTime":"/Date(1471939200000)/","Quantity":35,"Number":"00000023","AccountName":null,"OwnerName":"檀庭","CreatedOn":"/Date(1471834917000)/","Status":2},{"TenderAuthorizationId":"8a1ced80-ff65-e611-92fc-085700e64e0f","ProjectName":"测试你的人是","ApplyNo":"TBSQ201608000022","Name":"LS-3型","BidStatus":1,"OpenTendersTime":"/Date(1471507200000)/","Quantity":123,"Number":"！？！？！？","AccountName":null,"OwnerName":"檀庭","CreatedOn":"/Date(1471605874000)/","Status":2},{"TenderAuthorizationId":"6eb4b2b3-f265-e611-92fc-085700e64e0f","ProjectName":"fjc ","ApplyNo":"TBSQ201608000021","Name":"LS-3型","BidStatus":1,"OpenTendersTime":"/Date(1476777600000)/","Quantity":5,"Number":"gosh","AccountName":null,"OwnerName":"檀庭","CreatedOn":"/Date(1471600376000)/","Status":3},{"TenderAuthorizationId":"b84d08e3-d865-e611-92fc-085700e64e0f","ProjectName":"我","ApplyNo":"TBSQ201608000020","Name":"LS-3型","BidStatus":1,"OpenTendersTime":"/Date(1474185600000)/","Quantity":12,"Number":"请问我","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1471589288000)/","Status":3},{"TenderAuthorizationId":"6a425ede-d565-e611-92fc-085700e64e0f","ProjectName":"妈妈们","ApplyNo":"TBSQ201608000019","Name":"LS-3型","BidStatus":1,"OpenTendersTime":"/Date(1474185600000)/","Quantity":12,"Number":"0","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1471587993000)/","Status":3},{"TenderAuthorizationId":"68425ede-d565-e611-92fc-085700e64e0f","ProjectName":"妈妈们","ApplyNo":"TBSQ201608000018","Name":"LS-3型","BidStatus":1,"OpenTendersTime":"/Date(1474185600000)/","Quantity":12,"Number":"0","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1471587992000)/","Status":3},{"TenderAuthorizationId":"467d648f-bd63-e611-92fc-085700e64e0f","ProjectName":"aaaaaa","ApplyNo":"TBSQ201608000017","Name":"CGO-2100-01","BidStatus":1,"OpenTendersTime":"/Date(1471248000000)/","Quantity":111,"Number":"bbbbbbb","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1471357649000)/","Status":3},{"TenderAuthorizationId":"5a9bd8c2-8663-e611-92fc-085700e64e0f","ProjectName":"热缤纷多彩v","ApplyNo":"TBSQ201608000016","Name":"LS-3型","BidStatus":1,"OpenTendersTime":"/Date(1479196800000)/","Quantity":180,"Number":"000350","AccountName":null,"OwnerName":"姓名","CreatedOn":"/Date(1471334113000)/","Status":2},{"TenderAuthorizationId":"95ea44e0-b562-e611-92fc-085700e64e0f","ProjectName":"测试","ApplyNo":"TBSQ201608000015","Name":"DM-1型","BidStatus":1,"OpenTendersTime":"/Date(1476864000000)/","Quantity":2,"Number":"x007","AccountName":null,"OwnerName":"檀庭","CreatedOn":"/Date(1471244398000)/","Status":4}]
     */

    private int errorcode;
    /**
     * TenderAuthorizationId : 4921b933-dc69-e611-92fc-085700e64e0f
     * ProjectName : 测试
     * ApplyNo : TBSQ201608000024
     * Name : LS-3型
     * BidStatus : 1
     * OpenTendersTime : /Date(1474617600000)/
     * Quantity : 12
     * Number : 测试001
     * AccountName : null
     * OwnerName : 檀庭
     * CreatedOn : /Date(1472030517000)/
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
        private String ProjectName;
        private String ApplyNo;
        private String Name;
        private int BidStatus;
        private String OpenTendersTime;
        private int Quantity;
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

        public String getProjectName() {
            return ProjectName;
        }

        public void setProjectName(String ProjectName) {
            this.ProjectName = ProjectName;
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

        public String getOpenTendersTime() {
            return OpenTendersTime;
        }

        public void setOpenTendersTime(String OpenTendersTime) {
            this.OpenTendersTime = OpenTendersTime;
        }

        public int getQuantity() {
            return Quantity;
        }

        public void setQuantity(int Quantity) {
            this.Quantity = Quantity;
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
