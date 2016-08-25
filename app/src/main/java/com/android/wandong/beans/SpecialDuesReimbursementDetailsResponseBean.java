package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/7.
 */
public class SpecialDuesReimbursementDetailsResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"Detail":{"SpecialPaymentId":"d13182f5-2e68-e611-92fc-085700e64e0f","Name":"ZXBX201608000016","FeedDate":"要","CostType":2,"CostTypeName":"交通补助","Amount":22,"Remark":null,"AuditStatus":2,"AuditStatusName":"待审批","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1471846158000)/","StepNumber":2},"Approval":[{"StepNumber":"1","ApprovalTime":"2016-08-22 14:19","ApprovalPrice":22,"Opinion":"","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}],"isApprover":true}
     */

    private int errorcode;
    /**
     * Detail : {"SpecialPaymentId":"d13182f5-2e68-e611-92fc-085700e64e0f","Name":"ZXBX201608000016","FeedDate":"要","CostType":2,"CostTypeName":"交通补助","Amount":22,"Remark":null,"AuditStatus":2,"AuditStatusName":"待审批","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1471846158000)/","StepNumber":2}
     * Approval : [{"StepNumber":"1","ApprovalTime":"2016-08-22 14:19","ApprovalPrice":22,"Opinion":"","Result":"通过","ApproverId":"c52610c5-60fd-e511-a1e5-085700e64e0f","Approver":"姓名"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}]
     * isApprover : true
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
         * SpecialPaymentId : d13182f5-2e68-e611-92fc-085700e64e0f
         * Name : ZXBX201608000016
         * FeedDate : 要
         * CostType : 2
         * CostTypeName : 交通补助
         * Amount : 22.0
         * Remark : null
         * AuditStatus : 2
         * AuditStatusName : 待审批
         * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
         * OwnerName : 姓名
         * CreatedOn : /Date(1471846158000)/
         * StepNumber : 2
         */

        private DetailBean Detail;
        private boolean isApprover;
        /**
         * StepNumber : 1
         * ApprovalTime : 2016-08-22 14:19
         * ApprovalPrice : 22.0
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
            private String SpecialPaymentId;
            private String Name;
            private String FeedDate;
            private int CostType;
            private String CostTypeName;
            private double Amount;
            private String Remark;
            private int AuditStatus;
            private String AuditStatusName;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private int StepNumber;

            public String getSpecialPaymentId() {
                return SpecialPaymentId;
            }

            public void setSpecialPaymentId(String SpecialPaymentId) {
                this.SpecialPaymentId = SpecialPaymentId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getFeedDate() {
                return FeedDate;
            }

            public void setFeedDate(String FeedDate) {
                this.FeedDate = FeedDate;
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

            public double getAmount() {
                return Amount;
            }

            public void setAmount(double Amount) {
                this.Amount = Amount;
            }

            public String getRemark() {
                return Remark;
            }

            public void setRemark(String Remark) {
                this.Remark = Remark;
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
