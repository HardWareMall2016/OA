package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/20.
 */
public class EntertainmentReimbursementCreateDetailResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"Detail":{"EntertainId":"49983671-a65e-e611-92fc-085700e64e0f","Name":"ZDSQ201608000026","AccountId":"5e40c2e6-5516-e611-ac23-085700e64e0f","AccountName":"高平武承谋骨伤专科医院","Number":3,"Reason":"Tgro","EntertainDate":"/Date(1476028800000)/","Province":"内蒙古自治区","ApplyUnit":"上海","EstimateMeals":999,"EstimateOffice":555,"EstimateTraffic":0,"EstimateGift":0,"EstimateHotel":0,"EstimateTotal":1554,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470797964000)/","AuditStatus":3,"AuditStatusName":null,"StepNumber":3,"PersonalImage":null},"Approval":[{"StepNumber":"1","ApprovalTime":"2016-08-19 18:31","ApprovalPrice":1554,"Opinion":"","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"},{"StepNumber":"2","ApprovalTime":"2016-08-19 18:31","ApprovalPrice":1554,"Opinion":"","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"},{"StepNumber":"3","ApprovalTime":"2016-08-19 18:31","ApprovalPrice":1554,"Opinion":"","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"}],"isApprover":false}
     */

    private int errorcode;
    /**
     * Detail : {"EntertainId":"49983671-a65e-e611-92fc-085700e64e0f","Name":"ZDSQ201608000026","AccountId":"5e40c2e6-5516-e611-ac23-085700e64e0f","AccountName":"高平武承谋骨伤专科医院","Number":3,"Reason":"Tgro","EntertainDate":"/Date(1476028800000)/","Province":"内蒙古自治区","ApplyUnit":"上海","EstimateMeals":999,"EstimateOffice":555,"EstimateTraffic":0,"EstimateGift":0,"EstimateHotel":0,"EstimateTotal":1554,"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470797964000)/","AuditStatus":3,"AuditStatusName":null,"StepNumber":3,"PersonalImage":null}
     * Approval : [{"StepNumber":"1","ApprovalTime":"2016-08-19 18:31","ApprovalPrice":1554,"Opinion":"","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"},{"StepNumber":"2","ApprovalTime":"2016-08-19 18:31","ApprovalPrice":1554,"Opinion":"","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"},{"StepNumber":"3","ApprovalTime":"2016-08-19 18:31","ApprovalPrice":1554,"Opinion":"","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"}]
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
         * EntertainId : 49983671-a65e-e611-92fc-085700e64e0f
         * Name : ZDSQ201608000026
         * AccountId : 5e40c2e6-5516-e611-ac23-085700e64e0f
         * AccountName : 高平武承谋骨伤专科医院
         * Number : 3
         * Reason : Tgro
         * EntertainDate : /Date(1476028800000)/
         * Province : 内蒙古自治区
         * ApplyUnit : 上海
         * EstimateMeals : 999
         * EstimateOffice : 555
         * EstimateTraffic : 0
         * EstimateGift : 0
         * EstimateHotel : 0
         * EstimateTotal : 1554
         * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
         * OwnerName : 姓名
         * CreatedOn : /Date(1470797964000)/
         * AuditStatus : 3
         * AuditStatusName : null
         * StepNumber : 3
         * PersonalImage : null
         */

        private DetailBean Detail;
        private boolean isApprover;
        /**
         * StepNumber : 1
         * ApprovalTime : 2016-08-19 18:31
         * ApprovalPrice : 1554
         * Opinion :
         * Result : 通过
         * ApproverId : c52610c5-60fd-e511-a1e5-085700e64e0f
         * Approver : 姓名
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
            private String EntertainId;
            private String Name;
            private String AccountId;
            private String AccountName;
            private int Number;
            private String Reason;
            private String EntertainDate;
            private String Province;
            private String ApplyUnit;
            private int EstimateMeals;
            private int EstimateOffice;
            private int EstimateTraffic;
            private int EstimateGift;
            private int EstimateHotel;
            private int EstimateTotal;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private int AuditStatus;
            private String AuditStatusName;
            private int StepNumber;
            private String PersonalImage;

            public String getEntertainId() {
                return EntertainId;
            }

            public void setEntertainId(String EntertainId) {
                this.EntertainId = EntertainId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
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

            public int getEstimateMeals() {
                return EstimateMeals;
            }

            public void setEstimateMeals(int EstimateMeals) {
                this.EstimateMeals = EstimateMeals;
            }

            public int getEstimateOffice() {
                return EstimateOffice;
            }

            public void setEstimateOffice(int EstimateOffice) {
                this.EstimateOffice = EstimateOffice;
            }

            public int getEstimateTraffic() {
                return EstimateTraffic;
            }

            public void setEstimateTraffic(int EstimateTraffic) {
                this.EstimateTraffic = EstimateTraffic;
            }

            public int getEstimateGift() {
                return EstimateGift;
            }

            public void setEstimateGift(int EstimateGift) {
                this.EstimateGift = EstimateGift;
            }

            public int getEstimateHotel() {
                return EstimateHotel;
            }

            public void setEstimateHotel(int EstimateHotel) {
                this.EstimateHotel = EstimateHotel;
            }

            public int getEstimateTotal() {
                return EstimateTotal;
            }

            public void setEstimateTotal(int EstimateTotal) {
                this.EstimateTotal = EstimateTotal;
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

            public int getAuditStatus() {
                return AuditStatus;
            }

            public void setAuditStatus(int AuditStatus) {
                this.AuditStatus = AuditStatus;
            }

            public String getAuditStatusName() {
                return AuditStatusName;
            }

            public void setAuditStatusName(String AuditStatusName) {
                this.AuditStatusName = AuditStatusName;
            }

            public int getStepNumber() {
                return StepNumber;
            }

            public void setStepNumber(int StepNumber) {
                this.StepNumber = StepNumber;
            }

            public String getPersonalImage() {
                return PersonalImage;
            }

            public void setPersonalImage(String PersonalImage) {
                this.PersonalImage = PersonalImage;
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
