package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/7.
 */
public class TenderApplicationDetailsResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"Detail":{"TenderAuthorizationId":"01e3855f-786b-e611-92fc-085700e64e0f","Name":"TBSQ201608000032","ProjectName":"周五招投标","Number":"08261525","BidStatus":0,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Province":"河北省","City":"邯郸","ProductClassifyId":"089c9037-b918-e611-ac23-085700e64e0f","ProductClassifyName":"常规产品","ProductId":"24e647a4-da18-e611-ac23-085700e64e0f","ProductName":"LS-3型","Quantity":5,"OpenTendersTime":"/Date(1487923200000)/","TenderAgency":"第一临时工有限公司","Website":"www.cctv.com","EmpoweredName":"第一市场","OwnerId":"fe139861-9b54-e611-be6c-085700e64e0f","OwnerName":"销售员","CreatedOn":"/Date(1472207543000)/","Remark":"","AuditStatus":2,"AuditStatusName":null,"StepNumber":1,"TenderAuthorizationOpportunitys":{"TenderAuthorizationOpportunityId":"02e3855f-786b-e611-92fc-085700e64e0f","OpportunityId":"095ad7c0-d868-e611-92fc-085700e64e0f","OpportunityName":"测试商机2","TenderAuthorizationId":"01e3855f-786b-e611-92fc-085700e64e0f"}},"Approval":[{"StepNumber":"1","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"97bb0342-2d34-e611-b907-085700e64e0f","Approver":"待豫单元经理审批"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}],"isApprover":true}
     */

    private int errorcode;
    /**
     * Detail : {"TenderAuthorizationId":"01e3855f-786b-e611-92fc-085700e64e0f","Name":"TBSQ201608000032","ProjectName":"周五招投标","Number":"08261525","BidStatus":0,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Province":"河北省","City":"邯郸","ProductClassifyId":"089c9037-b918-e611-ac23-085700e64e0f","ProductClassifyName":"常规产品","ProductId":"24e647a4-da18-e611-ac23-085700e64e0f","ProductName":"LS-3型","Quantity":5,"OpenTendersTime":"/Date(1487923200000)/","TenderAgency":"第一临时工有限公司","Website":"www.cctv.com","EmpoweredName":"第一市场","OwnerId":"fe139861-9b54-e611-be6c-085700e64e0f","OwnerName":"销售员","CreatedOn":"/Date(1472207543000)/","Remark":"","AuditStatus":2,"AuditStatusName":null,"StepNumber":1,"TenderAuthorizationOpportunitys":{"TenderAuthorizationOpportunityId":"02e3855f-786b-e611-92fc-085700e64e0f","OpportunityId":"095ad7c0-d868-e611-92fc-085700e64e0f","OpportunityName":"测试商机2","TenderAuthorizationId":"01e3855f-786b-e611-92fc-085700e64e0f"}}
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
         * TenderAuthorizationId : 01e3855f-786b-e611-92fc-085700e64e0f
         * Name : TBSQ201608000032
         * ProjectName : 周五招投标
         * Number : 08261525
         * BidStatus : 0
         * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
         * AccountName : 襄城区余家湖社区卫生服务中心
         * Province : 河北省
         * City : 邯郸
         * ProductClassifyId : 089c9037-b918-e611-ac23-085700e64e0f
         * ProductClassifyName : 常规产品
         * ProductId : 24e647a4-da18-e611-ac23-085700e64e0f
         * ProductName : LS-3型
         * Quantity : 5
         * OpenTendersTime : /Date(1487923200000)/
         * TenderAgency : 第一临时工有限公司
         * Website : www.cctv.com
         * EmpoweredName : 第一市场
         * OwnerId : fe139861-9b54-e611-be6c-085700e64e0f
         * OwnerName : 销售员
         * CreatedOn : /Date(1472207543000)/
         * Remark :
         * AuditStatus : 2
         * AuditStatusName : null
         * StepNumber : 1
         * TenderAuthorizationOpportunitys : {"TenderAuthorizationOpportunityId":"02e3855f-786b-e611-92fc-085700e64e0f","OpportunityId":"095ad7c0-d868-e611-92fc-085700e64e0f","OpportunityName":"测试商机2","TenderAuthorizationId":"01e3855f-786b-e611-92fc-085700e64e0f"}
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
            private String Website;
            private String EmpoweredName;
            private String OwnerId;
            private String OwnerName;
            private String CreatedOn;
            private String Remark;
            private int AuditStatus;
            private Object AuditStatusName;
            private int StepNumber;
            /**
             * TenderAuthorizationOpportunityId : 02e3855f-786b-e611-92fc-085700e64e0f
             * OpportunityId : 095ad7c0-d868-e611-92fc-085700e64e0f
             * OpportunityName : 测试商机2
             * TenderAuthorizationId : 01e3855f-786b-e611-92fc-085700e64e0f
             */

            private TenderAuthorizationOpportunitysBean TenderAuthorizationOpportunitys;

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
                return Website;
            }

            public void setWebsite(String Website) {
                this.Website = Website;
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

            public Object getAuditStatusName() {
                return AuditStatusName;
            }

            public void setAuditStatusName(Object AuditStatusName) {
                this.AuditStatusName = AuditStatusName;
            }

            public int getStepNumber() {
                return StepNumber;
            }

            public void setStepNumber(int StepNumber) {
                this.StepNumber = StepNumber;
            }

            public TenderAuthorizationOpportunitysBean getTenderAuthorizationOpportunitys() {
                return TenderAuthorizationOpportunitys;
            }

            public void setTenderAuthorizationOpportunitys(TenderAuthorizationOpportunitysBean TenderAuthorizationOpportunitys) {
                this.TenderAuthorizationOpportunitys = TenderAuthorizationOpportunitys;
            }

            public static class TenderAuthorizationOpportunitysBean {
                private String TenderAuthorizationOpportunityId;
                private String OpportunityId;
                private String OpportunityName;
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

                public String getOpportunityName() {
                    return OpportunityName;
                }

                public void setOpportunityName(String OpportunityName) {
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
