package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/7.
 */
public class EntertainmentReimbursementDetailResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"Detail":{"EntertainCostId":"4a1ae667-325a-e611-92fc-085700e64e0f","Name":"ZDBX201608000016","AuditStatus":2,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Number":6,"Reason":"有朋自远方来","EntertainDate":"/Date(1475481600000)/","Province":"辽宁省","ApplyUnit":"营销中心","ActualMeals":8000,"ActualOffice":0,"ActualHotel":888,"ActualTraffic":0,"ActualGift":0,"ActualTotal":8888,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470308322000)/","StepNumber":1},"Approval":[{"StepNumber":"1","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"97bb0342-2d34-e611-b907-085700e64e0f","Approver":"待豫单元经理审批"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}],"isApprover":false}
     */

    private int errorcode;
    /**
     * Detail : {"EntertainCostId":"4a1ae667-325a-e611-92fc-085700e64e0f","Name":"ZDBX201608000016","AuditStatus":2,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Number":6,"Reason":"有朋自远方来","EntertainDate":"/Date(1475481600000)/","Province":"辽宁省","ApplyUnit":"营销中心","ActualMeals":8000,"ActualOffice":0,"ActualHotel":888,"ActualTraffic":0,"ActualGift":0,"ActualTotal":8888,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470308322000)/","StepNumber":1}
     * Approval : [{"StepNumber":"1","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"97bb0342-2d34-e611-b907-085700e64e0f","Approver":"待豫单元经理审批"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}]
     * isApprover : false
     */

    private EntityInfoBean entityInfo;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public EntityInfoBean getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(EntityInfoBean entityInfo) {
        this.entityInfo = entityInfo;
    }

    public static class EntityInfoBean {
        /**
         * EntertainCostId : 4a1ae667-325a-e611-92fc-085700e64e0f
         * Name : ZDBX201608000016
         * AuditStatus : 2
         * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
         * AccountName : 襄城区余家湖社区卫生服务中心
         * Number : 6
         * Reason : 有朋自远方来
         * EntertainDate : /Date(1475481600000)/
         * Province : 辽宁省
         * ApplyUnit : 营销中心
         * ActualMeals : 8000.0
         * ActualOffice : 0.0
         * ActualHotel : 888.0
         * ActualTraffic : 0.0
         * ActualGift : 0.0
         * ActualTotal : 8888.0
         * OwnerId : 20998760-65fd-e511-a1e5-085700e64e0f
         * OwnerName : tanting
         * CreatedOn : /Date(1470308322000)/
         * StepNumber : 1
         */

        private DetailBean Detail;
        private boolean isApprover;
        /**
         * StepNumber : 1
         * ApprovalTime :
         * ApprovalPrice : 0
         * Opinion :
         * Result :
         * ApproverId : 97bb0342-2d34-e611-b907-085700e64e0f
         * Approver : 待豫单元经理审批
         */

        private List<ApprovalBean> Approval;

        public DetailBean getDetail() {
            return Detail;
        }

        public void setDetail(DetailBean Detail) {
            this.Detail = Detail;
        }

        public boolean isIsApprover() {
            return isApprover;
        }

        public void setIsApprover(boolean isApprover) {
            this.isApprover = isApprover;
        }

        public List<ApprovalBean> getApproval() {
            return Approval;
        }

        public void setApproval(List<ApprovalBean> Approval) {
            this.Approval = Approval;
        }

        public static class DetailBean {
            private String EntertainCostId;
            private String Name;
            private int AuditStatus;
            private String AccountId;
            private String AccountName;
            private int Number;
            private String Reason;
            private String EntertainDate;
            private String Province;
            private String ApplyUnit;
            private double ActualMeals;
            private double ActualOffice;
            private double ActualHotel;
            private double ActualTraffic;
            private double ActualGift;
            private double ActualTotal;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private int StepNumber;

            public String getEntertainCostId() {
                return EntertainCostId;
            }

            public void setEntertainCostId(String EntertainCostId) {
                this.EntertainCostId = EntertainCostId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public int getAuditStatus() {
                return AuditStatus;
            }

            public void setAuditStatus(int AuditStatus) {
                this.AuditStatus = AuditStatus;
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

            public int getNumber() {
                return Number;
            }

            public void setNumber(int Number) {
                this.Number = Number;
            }

            public String getReason() {
                return Reason;
            }

            public void setReason(String Reason) {
                this.Reason = Reason;
            }

            public String getEntertainDate() {
                return EntertainDate;
            }

            public void setEntertainDate(String EntertainDate) {
                this.EntertainDate = EntertainDate;
            }

            public String getProvince() {
                return Province;
            }

            public void setProvince(String Province) {
                this.Province = Province;
            }

            public String getApplyUnit() {
                return ApplyUnit;
            }

            public void setApplyUnit(String ApplyUnit) {
                this.ApplyUnit = ApplyUnit;
            }

            public double getActualMeals() {
                return ActualMeals;
            }

            public void setActualMeals(double ActualMeals) {
                this.ActualMeals = ActualMeals;
            }

            public double getActualOffice() {
                return ActualOffice;
            }

            public void setActualOffice(double ActualOffice) {
                this.ActualOffice = ActualOffice;
            }

            public double getActualHotel() {
                return ActualHotel;
            }

            public void setActualHotel(double ActualHotel) {
                this.ActualHotel = ActualHotel;
            }

            public double getActualTraffic() {
                return ActualTraffic;
            }

            public void setActualTraffic(double ActualTraffic) {
                this.ActualTraffic = ActualTraffic;
            }

            public double getActualGift() {
                return ActualGift;
            }

            public void setActualGift(double ActualGift) {
                this.ActualGift = ActualGift;
            }

            public double getActualTotal() {
                return ActualTotal;
            }

            public void setActualTotal(double ActualTotal) {
                this.ActualTotal = ActualTotal;
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

            public int getStepNumber() {
                return StepNumber;
            }

            public void setStepNumber(int StepNumber) {
                this.StepNumber = StepNumber;
            }
        }

        public static class ApprovalBean {
            private String StepNumber;
            private String ApprovalTime;
            private int ApprovalPrice;
            private String Opinion;
            private String Result;
            private String ApproverId;
            private String Approver;

            public String getStepNumber() {
                return StepNumber;
            }

            public void setStepNumber(String StepNumber) {
                this.StepNumber = StepNumber;
            }

            public String getApprovalTime() {
                return ApprovalTime;
            }

            public void setApprovalTime(String ApprovalTime) {
                this.ApprovalTime = ApprovalTime;
            }

            public int getApprovalPrice() {
                return ApprovalPrice;
            }

            public void setApprovalPrice(int ApprovalPrice) {
                this.ApprovalPrice = ApprovalPrice;
            }

            public String getOpinion() {
                return Opinion;
            }

            public void setOpinion(String Opinion) {
                this.Opinion = Opinion;
            }

            public String getResult() {
                return Result;
            }

            public void setResult(String Result) {
                this.Result = Result;
            }

            public String getApproverId() {
                return ApproverId;
            }

            public void setApproverId(String ApproverId) {
                this.ApproverId = ApproverId;
            }

            public String getApprover() {
                return Approver;
            }

            public void setApprover(String Approver) {
                this.Approver = Approver;
            }
        }
    }
}
