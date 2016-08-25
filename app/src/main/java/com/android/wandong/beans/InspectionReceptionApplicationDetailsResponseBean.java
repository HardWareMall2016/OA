package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/7.
 */
public class InspectionReceptionApplicationDetailsResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : {"Detail":{"ReceptionId":"f7ad845f-ca69-e611-92fc-085700e64e0f","Name":"KCSQ201608000034","AccountId":"91cb40a7-ac69-e611-92fc-085700e64e0f","AccountName":"上海第九十七人民医院","ComeTime":"/Date(1472109000000)/","LeaveTime":"/Date(1472281800000)/","SubmitTime":"/Date(1472022859000)/","VisitName":"测试","VisitNumber":12,"VisitTelephone":"123463","AuditStatus":2,"AuditStatusName":null,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"檀庭","CreatedOn":"/Date(-62135596800000)/","StepNumber":1},"AttachmentInfo":[],"Approval":[{"StepNumber":"1","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"97bb0342-2d34-e611-b907-085700e64e0f","Approver":"待豫单元经理审批"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}],"isApprover":true}
     */

    private int errorcode;
    /**
     * Detail : {"ReceptionId":"f7ad845f-ca69-e611-92fc-085700e64e0f","Name":"KCSQ201608000034","AccountId":"91cb40a7-ac69-e611-92fc-085700e64e0f","AccountName":"上海第九十七人民医院","ComeTime":"/Date(1472109000000)/","LeaveTime":"/Date(1472281800000)/","SubmitTime":"/Date(1472022859000)/","VisitName":"测试","VisitNumber":12,"VisitTelephone":"123463","AuditStatus":2,"AuditStatusName":null,"OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"檀庭","CreatedOn":"/Date(-62135596800000)/","StepNumber":1}
     * AttachmentInfo : []
     * Approval : [{"StepNumber":"1","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"97bb0342-2d34-e611-b907-085700e64e0f","Approver":"待豫单元经理审批"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}]
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
         * ReceptionId : f7ad845f-ca69-e611-92fc-085700e64e0f
         * Name : KCSQ201608000034
         * AccountId : 91cb40a7-ac69-e611-92fc-085700e64e0f
         * AccountName : 上海第九十七人民医院
         * ComeTime : /Date(1472109000000)/
         * LeaveTime : /Date(1472281800000)/
         * SubmitTime : /Date(1472022859000)/
         * VisitName : 测试
         * VisitNumber : 12
         * VisitTelephone : 123463
         * AuditStatus : 2
         * AuditStatusName : null
         * OwnerId : 20998760-65fd-e511-a1e5-085700e64e0f
         * OwnerName : 檀庭
         * CreatedOn : /Date(-62135596800000)/
         * StepNumber : 1
         */

        private DetailBean Detail;
        private boolean isApprover;
        private List<?> AttachmentInfo;
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

        public List<?> getAttachmentInfo() {
            return AttachmentInfo;
        }

        public void setAttachmentInfo(List<?> AttachmentInfo) {
            this.AttachmentInfo = AttachmentInfo;
        }

        public List<ApprovalBean> getApproval() {
            return Approval;
        }

        public void setApproval(List<ApprovalBean> Approval) {
            this.Approval = Approval;
        }

        public static class DetailBean {
            private String ReceptionId;
            private String Name;
            private String AccountId;
            private String AccountName;
            private String ComeTime;
            private String LeaveTime;
            private String SubmitTime;
            private String VisitName;
            private int VisitNumber;
            private String VisitTelephone;
            private int AuditStatus;
            private String AuditStatusName;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private int StepNumber;

            public String getReceptionId() {
                return ReceptionId;
            }

            public void setReceptionId(String ReceptionId) {
                this.ReceptionId = ReceptionId;
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

            public String getComeTime() {
                return ComeTime;
            }

            public void setComeTime(String ComeTime) {
                this.ComeTime = ComeTime;
            }

            public String getLeaveTime() {
                return LeaveTime;
            }

            public void setLeaveTime(String LeaveTime) {
                this.LeaveTime = LeaveTime;
            }

            public String getSubmitTime() {
                return SubmitTime;
            }

            public void setSubmitTime(String SubmitTime) {
                this.SubmitTime = SubmitTime;
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
