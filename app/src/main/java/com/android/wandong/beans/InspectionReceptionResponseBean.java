package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class InspectionReceptionResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"ReceptionId":"5112ec76-dd5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000021","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"名称：","VisitNumber":20,"VisitTelephone":"13162520886","ApplyTime":"/Date(1470381792000)/","Status":2,"OwnerName":"tanting","CreatedOn":"/Date(1470381792000)/"},{"ReceptionId":"d3e8d256-3a5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000020","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"测试","VisitNumber":61381,"VisitTelephone":"1231643236","ApplyTime":"/Date(1470311730000)/","Status":3,"OwnerName":"tanting","CreatedOn":"/Date(1470311730000)/"},{"ReceptionId":"0e2dcc49-275a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000019","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"朋友1","VisitNumber":1,"VisitTelephone":"110","ApplyTime":"/Date(1470303548000)/","Status":2,"OwnerName":"tanting","CreatedOn":"/Date(1470303547000)/"},{"ReceptionId":"70b8c3ff-0e5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000018","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"1111","VisitNumber":11111,"VisitTelephone":"2222","ApplyTime":"/Date(1470293116000)/","Status":2,"OwnerName":"姓名","CreatedOn":"/Date(1470293115000)/"},{"ReceptionId":"46593ae3-0e5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000017","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"111","VisitNumber":11111,"VisitTelephone":"222222","ApplyTime":"/Date(1470293068000)/","Status":3,"OwnerName":"姓名","CreatedOn":"/Date(1470293067000)/"},{"ReceptionId":"b42ce665-0b5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000016","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"111","VisitNumber":333,"VisitTelephone":"22222","ApplyTime":"/Date(1470291572000)/","Status":4,"OwnerName":"姓名","CreatedOn":"/Date(1470291572000)/"},{"ReceptionId":"3503cc7c-4c59-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000015","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"我","VisitNumber":1,"VisitTelephone":"12","ApplyTime":"/Date(1470209573000)/","Status":3,"OwnerName":"姓名","CreatedOn":"/Date(1470209573000)/"},{"ReceptionId":"7ee02064-4c59-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000014","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"我","VisitNumber":12,"VisitTelephone":"136","ApplyTime":"/Date(1470209532000)/","Status":4,"OwnerName":"姓名","CreatedOn":"/Date(1470209532000)/"},{"ReceptionId":"5de4afe0-4b59-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000013","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"wew","VisitNumber":2,"VisitTelephone":"12312312312","ApplyTime":"/Date(1470209312000)/","Status":2,"OwnerName":"姓名","CreatedOn":"/Date(1470209311000)/"},{"ReceptionId":"07ccaa3f-6458-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000012","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"这是有图片的","VisitNumber":99,"VisitTelephone":"123465789","ApplyTime":"/Date(1470109828000)/","Status":3,"OwnerName":"姓名","CreatedOn":"/Date(1470109828000)/"}]
     */

    private int errorcode;
    /**
     * ReceptionId : 5112ec76-dd5a-e611-92fc-085700e64e0f
     * ApplyNo : KCSQ201608000021
     * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
     * AccountName : 襄城区余家湖社区卫生服务中心
     * VisitName : 名称：
     * VisitNumber : 20
     * VisitTelephone : 13162520886
     * ApplyTime : /Date(1470381792000)/
     * Status : 2
     * OwnerName : tanting
     * CreatedOn : /Date(1470381792000)/
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
        private String ReceptionId;
        private String ApplyNo;
        private String AccountId;
        private String AccountName;
        private String VisitName;
        private int VisitNumber;
        private String VisitTelephone;
        private String ApplyTime;
        private int Status;
        private String OwnerName;
        private String CreatedOn;

        public String getReceptionId() {
            return ReceptionId;
        }

        public void setReceptionId(String ReceptionId) {
            this.ReceptionId = ReceptionId;
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

        public String getVisitName() {
            return VisitName;
        }

        public void setVisitName(String VisitName) {
            this.VisitName = VisitName;
        }

        public int getVisitNumber() {
            return VisitNumber;
        }

        public void setVisitNumber(int VisitNumber) {
            this.VisitNumber = VisitNumber;
        }

        public String getVisitTelephone() {
            return VisitTelephone;
        }

        public void setVisitTelephone(String VisitTelephone) {
            this.VisitTelephone = VisitTelephone;
        }

        public String getApplyTime() {
            return ApplyTime;
        }

        public void setApplyTime(String ApplyTime) {
            this.ApplyTime = ApplyTime;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
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
