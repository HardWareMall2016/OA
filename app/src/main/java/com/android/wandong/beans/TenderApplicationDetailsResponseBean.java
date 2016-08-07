package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/7.
 */
public class TenderApplicationDetailsResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"Detail":{"TenderAuthorizationId":"f1630972-db5a-e611-92fc-085700e64e0f","Name":"TBSQ201608000007","ProjectName":"招投标","Number":"001","BidStatus":0,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Province":"天津市","City":"哈哈哈哈","ProductClassifyId":"64bc3705-b218-e611-ac23-085700e64e0f","ProductClassifyName":"MRI磁共振成像系统","ProductId":"9b94b47d-d318-e611-ac23-085700e64e0f","ProductName":"i_Open 0.3T","Quantity":20,"OpenTendersTime":"/Date(1470470400000)/","TenderAgency":"机构","website":"www","EmpoweredName":"名","OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470380924000)/","Remark":"","AuditStatus":2,"StepNumber":1,"TenderAuthorizationOpportunitys":[{"TenderAuthorizationOpportunityId":"77e5d2b5-095a-e611-92fc-085700e64e0f","OpportunityId":"00000000-0000-0000-0000-000000000000","OpportunityName":null,"TenderAuthorizationId":"76e5d2b5-095a-e611-92fc-085700e64e0f"}]},"Approval":[{"StepNumber":"1","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"97bb0342-2d34-e611-b907-085700e64e0f","Approver":"待豫单元经理审批"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}],"isApprover":false}
     */

    private int errorcode;
    /**
     * Detail : {"TenderAuthorizationId":"f1630972-db5a-e611-92fc-085700e64e0f","Name":"TBSQ201608000007","ProjectName":"招投标","Number":"001","BidStatus":0,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Province":"天津市","City":"哈哈哈哈","ProductClassifyId":"64bc3705-b218-e611-ac23-085700e64e0f","ProductClassifyName":"MRI磁共振成像系统","ProductId":"9b94b47d-d318-e611-ac23-085700e64e0f","ProductName":"i_Open 0.3T","Quantity":20,"OpenTendersTime":"/Date(1470470400000)/","TenderAgency":"机构","website":"www","EmpoweredName":"名","OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"tanting","CreatedOn":"/Date(1470380924000)/","Remark":"","AuditStatus":2,"StepNumber":1,"TenderAuthorizationOpportunitys":[{"TenderAuthorizationOpportunityId":"77e5d2b5-095a-e611-92fc-085700e64e0f","OpportunityId":"00000000-0000-0000-0000-000000000000","OpportunityName":null,"TenderAuthorizationId":"76e5d2b5-095a-e611-92fc-085700e64e0f"}]}
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
         * TenderAuthorizationId : f1630972-db5a-e611-92fc-085700e64e0f
         * Name : TBSQ201608000007
         * ProjectName : 招投标
         * Number : 001
         * BidStatus : 0
         * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
         * AccountName : 襄城区余家湖社区卫生服务中心
         * Province : 天津市
         * City : 哈哈哈哈
         * ProductClassifyId : 64bc3705-b218-e611-ac23-085700e64e0f
         * ProductClassifyName : MRI磁共振成像系统
         * ProductId : 9b94b47d-d318-e611-ac23-085700e64e0f
         * ProductName : i_Open 0.3T
         * Quantity : 20
         * OpenTendersTime : /Date(1470470400000)/
         * TenderAgency : 机构
         * website : www
         * EmpoweredName : 名
         * OwnerId : 20998760-65fd-e511-a1e5-085700e64e0f
         * OwnerName : tanting
         * CreatedOn : /Date(1470380924000)/
         * Remark :
         * AuditStatus : 2
         * StepNumber : 1
         * TenderAuthorizationOpportunitys : [{"TenderAuthorizationOpportunityId":"77e5d2b5-095a-e611-92fc-085700e64e0f","OpportunityId":"00000000-0000-0000-0000-000000000000","OpportunityName":null,"TenderAuthorizationId":"76e5d2b5-095a-e611-92fc-085700e64e0f"}]
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
            private String TenderAuthorizationId;
            private String Name;
            private String ProjectName;
            private String Number;
            private int BidStatus;
            private String AccountId;
            private String AccountName;
            private String Province;
            private String City;
            private String ProductClassifyId;
            private String ProductClassifyName;
            private String ProductId;
            private String ProductName;
            private int Quantity;
            private String OpenTendersTime;
            private String TenderAgency;
            private String website;
            private String EmpoweredName;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private String Remark;
            private int AuditStatus;
            private int StepNumber;
            /**
             * TenderAuthorizationOpportunityId : 77e5d2b5-095a-e611-92fc-085700e64e0f
             * OpportunityId : 00000000-0000-0000-0000-000000000000
             * OpportunityName : null
             * TenderAuthorizationId : 76e5d2b5-095a-e611-92fc-085700e64e0f
             */

            private List<TenderAuthorizationOpportunitysBean> TenderAuthorizationOpportunitys;

            public String getTenderAuthorizationId() {
                return TenderAuthorizationId;
            }

            public void setTenderAuthorizationId(String TenderAuthorizationId) {
                this.TenderAuthorizationId = TenderAuthorizationId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getProjectName() {
                return ProjectName;
            }

            public void setProjectName(String ProjectName) {
                this.ProjectName = ProjectName;
            }

            public String getNumber() {
                return Number;
            }

            public void setNumber(String Number) {
                this.Number = Number;
            }

            public int getBidStatus() {
                return BidStatus;
            }

            public void setBidStatus(int BidStatus) {
                this.BidStatus = BidStatus;
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

            public String getProvince() {
                return Province;
            }

            public void setProvince(String Province) {
                this.Province = Province;
            }

            public String getCity() {
                return City;
            }

            public void setCity(String City) {
                this.City = City;
            }

            public String getProductClassifyId() {
                return ProductClassifyId;
            }

            public void setProductClassifyId(String ProductClassifyId) {
                this.ProductClassifyId = ProductClassifyId;
            }

            public String getProductClassifyName() {
                return ProductClassifyName;
            }

            public void setProductClassifyName(String ProductClassifyName) {
                this.ProductClassifyName = ProductClassifyName;
            }

            public String getProductId() {
                return ProductId;
            }

            public void setProductId(String ProductId) {
                this.ProductId = ProductId;
            }

            public String getProductName() {
                return ProductName;
            }

            public void setProductName(String ProductName) {
                this.ProductName = ProductName;
            }

            public int getQuantity() {
                return Quantity;
            }

            public void setQuantity(int Quantity) {
                this.Quantity = Quantity;
            }

            public String getOpenTendersTime() {
                return OpenTendersTime;
            }

            public void setOpenTendersTime(String OpenTendersTime) {
                this.OpenTendersTime = OpenTendersTime;
            }

            public String getTenderAgency() {
                return TenderAgency;
            }

            public void setTenderAgency(String TenderAgency) {
                this.TenderAgency = TenderAgency;
            }

            public String getWebsite() {
                return website;
            }

            public void setWebsite(String website) {
                this.website = website;
            }

            public String getEmpoweredName() {
                return EmpoweredName;
            }

            public void setEmpoweredName(String EmpoweredName) {
                this.EmpoweredName = EmpoweredName;
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

            public int getStepNumber() {
                return StepNumber;
            }

            public void setStepNumber(int StepNumber) {
                this.StepNumber = StepNumber;
            }

            public List<TenderAuthorizationOpportunitysBean> getTenderAuthorizationOpportunitys() {
                return TenderAuthorizationOpportunitys;
            }

            public void setTenderAuthorizationOpportunitys(List<TenderAuthorizationOpportunitysBean> TenderAuthorizationOpportunitys) {
                this.TenderAuthorizationOpportunitys = TenderAuthorizationOpportunitys;
            }

            public static class TenderAuthorizationOpportunitysBean {
                private String TenderAuthorizationOpportunityId;
                private String OpportunityId;
                private Object OpportunityName;
                private String TenderAuthorizationId;

                public String getTenderAuthorizationOpportunityId() {
                    return TenderAuthorizationOpportunityId;
                }

                public void setTenderAuthorizationOpportunityId(String TenderAuthorizationOpportunityId) {
                    this.TenderAuthorizationOpportunityId = TenderAuthorizationOpportunityId;
                }

                public String getOpportunityId() {
                    return OpportunityId;
                }

                public void setOpportunityId(String OpportunityId) {
                    this.OpportunityId = OpportunityId;
                }

                public Object getOpportunityName() {
                    return OpportunityName;
                }

                public void setOpportunityName(Object OpportunityName) {
                    this.OpportunityName = OpportunityName;
                }

                public String getTenderAuthorizationId() {
                    return TenderAuthorizationId;
                }

                public void setTenderAuthorizationId(String TenderAuthorizationId) {
                    this.TenderAuthorizationId = TenderAuthorizationId;
                }
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
