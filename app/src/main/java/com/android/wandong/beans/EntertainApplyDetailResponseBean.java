package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/8/6 16:12
 * 邮箱：wuyue8512@163.com
 * //
 * //         .............................................
 * //                  美女坐镇                  BUG辟易
 * //         .............................................
 * //
 * //                       .::::.
 * //                     .::::::::.
 * //                    :::::::::::
 * //                 ..:::::::::::'
 * //              '::::::::::::'
 * //                .::::::::::
 * //           '::::::::::::::..
 * //                ..::::::::::::.
 * //              ``::::::::::::::::
 * //               ::::``:::::::::'        .:::.
 * //              ::::'   ':::::'       .::::::::.
 * //            .::::'      ::::     .:::::::'::::.
 * //           .:::'       :::::  .:::::::::' ':::::.
 * //          .::'        :::::.:::::::::'      ':::::.
 * //         .::'         ::::::::::::::'         ``::::.
 * //     ...:::           ::::::::::::'              ``::.
 * //    ```` ':.          ':::::::::'                  ::::..
 * //                       '.:::::'                    ':'````..
 * //
 */
public class EntertainApplyDetailResponseBean extends BaseResponseBean {

    private int errorcode;

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

        private DetailBean Detail;
        private boolean isApprover;

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
            private double EstimateMeals;
            private double EstimateOffice;
            private double EstimateTraffic;
            private double EstimateGift;
            private double EstimateHotel;
            private double EstimateTotal;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private int AuditStatus;
            private int StepNumber;
            private String PersonalImage;

            public String getEntertainId() {
                return EntertainId;
            }

            public void setEntertainId(String entertainId) {
                EntertainId = entertainId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String name) {
                Name = name;
            }

            public String getAccountId() {
                return AccountId;
            }

            public void setAccountId(String accountId) {
                AccountId = accountId;
            }

            public String getAccountName() {
                return AccountName;
            }

            public void setAccountName(String accountName) {
                AccountName = accountName;
            }

            public int getNumber() {
                return Number;
            }

            public void setNumber(int number) {
                Number = number;
            }

            public String getReason() {
                return Reason;
            }

            public void setReason(String reason) {
                Reason = reason;
            }

            public String getEntertainDate() {
                return EntertainDate;
            }

            public void setEntertainDate(String entertainDate) {
                EntertainDate = entertainDate;
            }

            public String getProvince() {
                return Province;
            }

            public void setProvince(String province) {
                Province = province;
            }

            public String getApplyUnit() {
                return ApplyUnit;
            }

            public void setApplyUnit(String applyUnit) {
                ApplyUnit = applyUnit;
            }

            public double getEstimateMeals() {
                return EstimateMeals;
            }

            public void setEstimateMeals(double estimateMeals) {
                EstimateMeals = estimateMeals;
            }

            public double getEstimateOffice() {
                return EstimateOffice;
            }

            public void setEstimateOffice(double estimateOffice) {
                EstimateOffice = estimateOffice;
            }

            public double getEstimateTraffic() {
                return EstimateTraffic;
            }

            public void setEstimateTraffic(double estimateTraffic) {
                EstimateTraffic = estimateTraffic;
            }

            public double getEstimateGift() {
                return EstimateGift;
            }

            public void setEstimateGift(double estimateGift) {
                EstimateGift = estimateGift;
            }

            public double getEstimateHotel() {
                return EstimateHotel;
            }

            public void setEstimateHotel(double estimateHotel) {
                EstimateHotel = estimateHotel;
            }

            public double getEstimateTotal() {
                return EstimateTotal;
            }

            public void setEstimateTotal(double estimateTotal) {
                EstimateTotal = estimateTotal;
            }

            public String getOwnerId() {
                return OwnerId;
            }

            public void setOwnerId(String ownerId) {
                OwnerId = ownerId;
            }

            public String getOwnerName() {
                return OwnerName;
            }

            public void setOwnerName(String ownerName) {
                OwnerName = ownerName;
            }

            public String getCreatedOn() {
                return CreatedOn;
            }

            public void setCreatedOn(String createdOn) {
                CreatedOn = createdOn;
            }

            public int getAuditStatus() {
                return AuditStatus;
            }

            public void setAuditStatus(int auditStatus) {
                AuditStatus = auditStatus;
            }

            public int getStepNumber() {
                return StepNumber;
            }

            public void setStepNumber(int stepNumber) {
                StepNumber = stepNumber;
            }

            public String getPersonalImage() {
                return PersonalImage;
            }

            public void setPersonalImage(String personalImage) {
                PersonalImage = personalImage;
            }
        }

        public static class ApprovalBean {
            private String StepNumber;
            private String ApprovalTime;
            private double ApprovalPrice;
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

            public double getApprovalPrice() {
                return ApprovalPrice;
            }

            public void setApprovalPrice(double ApprovalPrice) {
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
