package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/21.
 */
public class ContractApplicationCreateResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : {"OpportunityId":"b0ac9878-2f65-e611-92fc-085700e64e0f","Name":"姓名","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Source":0,"Competitor":null,"OpportunityType":0,"ProcessControl":0,"Description":null,"EstimatedCloseDate":"/Date(1470931200000)/","EstimatedValue":11000,"Stage":0,"CloseDate":"/Date(-62135596800000)/","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1471516525000)/","OpportunityProductItem":[{"OpportunityProductId":"b1ac9878-2f65-e611-92fc-085700e64e0f","ProductId":"24e647a4-da18-e611-ac23-085700e64e0f","Name":"LS-3型","ProductClassifyId":"089c9037-b918-e611-ac23-085700e64e0f","ProductClassifyName":"常规产品","OpportunityId":"b0ac9878-2f65-e611-92fc-085700e64e0f","Quantity":22,"Price":2}]}
     */

    private int errorcode;
    /**
     * OpportunityId : b0ac9878-2f65-e611-92fc-085700e64e0f
     * Name : 姓名
     * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
     * AccountName : 襄城区余家湖社区卫生服务中心
     * Source : 0
     * Competitor : null
     * OpportunityType : 0
     * ProcessControl : 0
     * Description : null
     * EstimatedCloseDate : /Date(1470931200000)/
     * EstimatedValue : 11000
     * Stage : 0
     * CloseDate : /Date(-62135596800000)/
     * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
     * OwnerName : 姓名
     * CreatedOn : /Date(1471516525000)/
     * OpportunityProductItem : [{"OpportunityProductId":"b1ac9878-2f65-e611-92fc-085700e64e0f","ProductId":"24e647a4-da18-e611-ac23-085700e64e0f","Name":"LS-3型","ProductClassifyId":"089c9037-b918-e611-ac23-085700e64e0f","ProductClassifyName":"常规产品","OpportunityId":"b0ac9878-2f65-e611-92fc-085700e64e0f","Quantity":22,"Price":2}]
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
        private String OpportunityId;
        private String Name;
        private String AccountId;
        private String AccountName;
        private int Source;
        private Object Competitor;
        private int OpportunityType;
        private int ProcessControl;
        private Object Description;
        private String EstimatedCloseDate;
        private int EstimatedValue;
        private int Stage;
        private String CloseDate;
        private String OwnerId;
        private String OwnerName;
        private String CreatedOn;
        /**
         * OpportunityProductId : b1ac9878-2f65-e611-92fc-085700e64e0f
         * ProductId : 24e647a4-da18-e611-ac23-085700e64e0f
         * Name : LS-3型
         * ProductClassifyId : 089c9037-b918-e611-ac23-085700e64e0f
         * ProductClassifyName : 常规产品
         * OpportunityId : b0ac9878-2f65-e611-92fc-085700e64e0f
         * Quantity : 22
         * Price : 2
         */

        private List<OpportunityProductItemBean> OpportunityProductItem;

        public String getOpportunityId() {
            return OpportunityId;
        }

        public void setOpportunityId(String OpportunityId) {
            this.OpportunityId = OpportunityId;
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

        public int getSource() {
            return Source;
        }

        public void setSource(int Source) {
            this.Source = Source;
        }

        public Object getCompetitor() {
            return Competitor;
        }

        public void setCompetitor(Object Competitor) {
            this.Competitor = Competitor;
        }

        public int getOpportunityType() {
            return OpportunityType;
        }

        public void setOpportunityType(int OpportunityType) {
            this.OpportunityType = OpportunityType;
        }

        public int getProcessControl() {
            return ProcessControl;
        }

        public void setProcessControl(int ProcessControl) {
            this.ProcessControl = ProcessControl;
        }

        public Object getDescription() {
            return Description;
        }

        public void setDescription(Object Description) {
            this.Description = Description;
        }

        public String getEstimatedCloseDate() {
            return EstimatedCloseDate;
        }

        public void setEstimatedCloseDate(String EstimatedCloseDate) {
            this.EstimatedCloseDate = EstimatedCloseDate;
        }

        public int getEstimatedValue() {
            return EstimatedValue;
        }

        public void setEstimatedValue(int EstimatedValue) {
            this.EstimatedValue = EstimatedValue;
        }

        public int getStage() {
            return Stage;
        }

        public void setStage(int Stage) {
            this.Stage = Stage;
        }

        public String getCloseDate() {
            return CloseDate;
        }

        public void setCloseDate(String CloseDate) {
            this.CloseDate = CloseDate;
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

        public List<OpportunityProductItemBean> getOpportunityProductItem() {
            return OpportunityProductItem;
        }

        public void setOpportunityProductItem(List<OpportunityProductItemBean> OpportunityProductItem) {
            this.OpportunityProductItem = OpportunityProductItem;
        }

        public static class OpportunityProductItemBean {
            private String OpportunityProductId;
            private String ProductId;
            private String Name;
            private String ProductClassifyId;
            private String ProductClassifyName;
            private String OpportunityId;
            private int Quantity;
            private int Price;

            public String getOpportunityProductId() {
                return OpportunityProductId;
            }

            public void setOpportunityProductId(String OpportunityProductId) {
                this.OpportunityProductId = OpportunityProductId;
            }

            public String getProductId() {
                return ProductId;
            }

            public void setProductId(String ProductId) {
                this.ProductId = ProductId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
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

            public String getOpportunityId() {
                return OpportunityId;
            }

            public void setOpportunityId(String OpportunityId) {
                this.OpportunityId = OpportunityId;
            }

            public int getQuantity() {
                return Quantity;
            }

            public void setQuantity(int Quantity) {
                this.Quantity = Quantity;
            }

            public int getPrice() {
                return Price;
            }

            public void setPrice(int Price) {
                this.Price = Price;
            }
        }
    }
}
