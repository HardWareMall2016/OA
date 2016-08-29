package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/29.
 */
public class ContractApplicationDetailsResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"Detail":{"ContractId":"bfb8a608-c969-e611-92fc-085700e64e0f","Name":"HTSQ201608000026","ContractName":"测试","OpportunityId":"574a9826-da68-e611-92fc-085700e64e0f","OpportunityName":"rhdnt ","Unit":"营销中心","PaymentAppointment":1,"PaymentAppointmentName":"全款发货","UserSite":"测试","TaskBelonger":"我","MoneyBelonger":"","OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"檀庭","BuyerName":"我","AccountName":"廊坊爱德堡医院","ProductClassifyId":"1f82b623-b918-e611-ac23-085700e64e0f","ProductClassifyName":"常规产品","ProductId":"8d5ed981-da18-e611-ac23-085700e64e0f","ProductName":"F30-IIG型-03","CapitalOccupyPrincipal":"","ContracTotal":123,"Quantity":8,"PaymentMode":"","DeliveryAppointment":"","ConfigurationRequire":1,"ConfigurationRequireName":"标配","ProductBasePrice":"0.00","Options":null,"OptionsPublishPrice":null,"PurchasingParts":null,"PurchasingPublishPrice":null,"CommissionMode":1,"CommissionModeName":"有","CommissionEstimateAmount":null,"Warranty":"12","GuaranteePublishPrice":"12","TransportMode":1,"TransportModeName":"标准配送","FreightEstimateAmount":null,"AmortizedMode":0,"AmortizedModeName":"","Interest":"","TrainRequirement":null,"TrainingEstimateAmount":null,"HandlingRequirement":null,"HandlingEstimateAmount":null,"ContractAmount":123,"FinalEstimateAmount":12,"CreatedOn":"/Date(1472022284000)/","StepNumber":1,"Status":0,"StatusName":null,"ERP_ContractNo":"HTSQ201608000026","ERP_AccountName":null,"ERP_ArriveDeliversDate":null,"ERP_Billing":null,"ERP_BreakevenAmount":null,"ERP_Consignee":null,"ERP_ConstantlyReceivable":null,"ERP_ContactNumber":null,"ERP_ContractAmount":null,"ERP_DeliveryDate":null,"ERP_InstallAcceptanceDate":null,"ERP_InventoryDate":null,"ERP_OutstockDate":null,"ERP_Payer":null,"ERP_ProductModel":null,"ERP_ReceivablesPlan":null,"ERP_SignDate":null,"ERP_StorageDate":null,"ERP_TotalReceivable":null},"Approval":[{"StepNumber":"1","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"97bb0342-2d34-e611-b907-085700e64e0f","Approver":"待豫单元经理审批"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}],"IsApprover":true}
     */

    private int errorcode;
    /**
     * Detail : {"ContractId":"bfb8a608-c969-e611-92fc-085700e64e0f","Name":"HTSQ201608000026","ContractName":"测试","OpportunityId":"574a9826-da68-e611-92fc-085700e64e0f","OpportunityName":"rhdnt ","Unit":"营销中心","PaymentAppointment":1,"PaymentAppointmentName":"全款发货","UserSite":"测试","TaskBelonger":"我","MoneyBelonger":"","OwnerId":"20998760-65fd-e511-a1e5-085700e64e0f","OwnerName":"檀庭","BuyerName":"我","AccountName":"廊坊爱德堡医院","ProductClassifyId":"1f82b623-b918-e611-ac23-085700e64e0f","ProductClassifyName":"常规产品","ProductId":"8d5ed981-da18-e611-ac23-085700e64e0f","ProductName":"F30-IIG型-03","CapitalOccupyPrincipal":"","ContracTotal":123,"Quantity":8,"PaymentMode":"","DeliveryAppointment":"","ConfigurationRequire":1,"ConfigurationRequireName":"标配","ProductBasePrice":"0.00","Options":null,"OptionsPublishPrice":null,"PurchasingParts":null,"PurchasingPublishPrice":null,"CommissionMode":1,"CommissionModeName":"有","CommissionEstimateAmount":null,"Warranty":"12","GuaranteePublishPrice":"12","TransportMode":1,"TransportModeName":"标准配送","FreightEstimateAmount":null,"AmortizedMode":0,"AmortizedModeName":"","Interest":"","TrainRequirement":null,"TrainingEstimateAmount":null,"HandlingRequirement":null,"HandlingEstimateAmount":null,"ContractAmount":123,"FinalEstimateAmount":12,"CreatedOn":"/Date(1472022284000)/","StepNumber":1,"Status":0,"StatusName":null,"ERP_ContractNo":"HTSQ201608000026","ERP_AccountName":null,"ERP_ArriveDeliversDate":null,"ERP_Billing":null,"ERP_BreakevenAmount":null,"ERP_Consignee":null,"ERP_ConstantlyReceivable":null,"ERP_ContactNumber":null,"ERP_ContractAmount":null,"ERP_DeliveryDate":null,"ERP_InstallAcceptanceDate":null,"ERP_InventoryDate":null,"ERP_OutstockDate":null,"ERP_Payer":null,"ERP_ProductModel":null,"ERP_ReceivablesPlan":null,"ERP_SignDate":null,"ERP_StorageDate":null,"ERP_TotalReceivable":null}
     * Approval : [{"StepNumber":"1","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"97bb0342-2d34-e611-b907-085700e64e0f","Approver":"待豫单元经理审批"},{"StepNumber":"2","ApprovalTime":"","ApprovalPrice":0,"Opinion":"","Result":"","ApproverId":"75bb0342-2d34-e611-b907-085700e64e0f","Approver":"待销售总监审批"}]
     * IsApprover : true
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
         * ContractId : bfb8a608-c969-e611-92fc-085700e64e0f
         * Name : HTSQ201608000026
         * ContractName : 测试
         * OpportunityId : 574a9826-da68-e611-92fc-085700e64e0f
         * OpportunityName : rhdnt
         * Unit : 营销中心
         * PaymentAppointment : 1
         * PaymentAppointmentName : 全款发货
         * UserSite : 测试
         * TaskBelonger : 我
         * MoneyBelonger :
         * OwnerId : 20998760-65fd-e511-a1e5-085700e64e0f
         * OwnerName : 檀庭
         * BuyerName : 我
         * AccountName : 廊坊爱德堡医院
         * ProductClassifyId : 1f82b623-b918-e611-ac23-085700e64e0f
         * ProductClassifyName : 常规产品
         * ProductId : 8d5ed981-da18-e611-ac23-085700e64e0f
         * ProductName : F30-IIG型-03
         * CapitalOccupyPrincipal :
         * ContracTotal : 123
         * Quantity : 8
         * PaymentMode :
         * DeliveryAppointment :
         * ConfigurationRequire : 1
         * ConfigurationRequireName : 标配
         * ProductBasePrice : 0.00
         * Options : null
         * OptionsPublishPrice : null
         * PurchasingParts : null
         * PurchasingPublishPrice : null
         * CommissionMode : 1
         * CommissionModeName : 有
         * CommissionEstimateAmount : null
         * Warranty : 12
         * GuaranteePublishPrice : 12
         * TransportMode : 1
         * TransportModeName : 标准配送
         * FreightEstimateAmount : null
         * AmortizedMode : 0
         * AmortizedModeName :
         * Interest :
         * TrainRequirement : null
         * TrainingEstimateAmount : null
         * HandlingRequirement : null
         * HandlingEstimateAmount : null
         * ContractAmount : 123
         * FinalEstimateAmount : 12
         * CreatedOn : /Date(1472022284000)/
         * StepNumber : 1
         * Status : 0
         * StatusName : null
         * ERP_ContractNo : HTSQ201608000026
         * ERP_AccountName : null
         * ERP_ArriveDeliversDate : null
         * ERP_Billing : null
         * ERP_BreakevenAmount : null
         * ERP_Consignee : null
         * ERP_ConstantlyReceivable : null
         * ERP_ContactNumber : null
         * ERP_ContractAmount : null
         * ERP_DeliveryDate : null
         * ERP_InstallAcceptanceDate : null
         * ERP_InventoryDate : null
         * ERP_OutstockDate : null
         * ERP_Payer : null
         * ERP_ProductModel : null
         * ERP_ReceivablesPlan : null
         * ERP_SignDate : null
         * ERP_StorageDate : null
         * ERP_TotalReceivable : null
         */

        private DetailBean Detail;
        private boolean IsApprover;
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
            return IsApprover;
        }

        public void setIsApprover(boolean IsApprover) {
            this.IsApprover = IsApprover;
        }

        public List<ApprovalBean> getApproval() {
            return Approval;
        }

        public void setApproval(List<ApprovalBean> Approval) {
            this.Approval = Approval;
        }

        public static class DetailBean {
            private String ContractId;
            private String Name;
            private String ContractName;
            private String OpportunityId;
            private String OpportunityName;
            private String Unit;
            private int PaymentAppointment;
            private String PaymentAppointmentName;
            private String UserSite;
            private String TaskBelonger;
            private String MoneyBelonger;
            private String OwnerId;
            private String OwnerName;
            private String BuyerName;
            private String AccountName;
            private String ProductClassifyId;
            private String ProductClassifyName;
            private String ProductId;
            private String ProductName;
            private String CapitalOccupyPrincipal;
            private int ContracTotal;
            private int Quantity;
            private String PaymentMode;
            private String DeliveryAppointment;
            private int ConfigurationRequire;
            private String ConfigurationRequireName;
            private String ProductBasePrice;
            private Object Options;
            private Object OptionsPublishPrice;
            private Object PurchasingParts;
            private Object PurchasingPublishPrice;
            private int CommissionMode;
            private String CommissionModeName;
            private Object CommissionEstimateAmount;
            private String Warranty;
            private String GuaranteePublishPrice;
            private int TransportMode;
            private String TransportModeName;
            private Object FreightEstimateAmount;
            private int AmortizedMode;
            private String AmortizedModeName;
            private String Interest;
            private Object TrainRequirement;
            private Object TrainingEstimateAmount;
            private Object HandlingRequirement;
            private Object HandlingEstimateAmount;
            private int ContractAmount;
            private int FinalEstimateAmount;
            private String CreatedOn;
            private int StepNumber;
            private int Status;
            private Object StatusName;
            private String ERP_ContractNo;
            private Object ERP_AccountName;
            private Object ERP_ArriveDeliversDate;
            private Object ERP_Billing;
            private Object ERP_BreakevenAmount;
            private Object ERP_Consignee;
            private Object ERP_ConstantlyReceivable;
            private Object ERP_ContactNumber;
            private Object ERP_ContractAmount;
            private Object ERP_DeliveryDate;
            private Object ERP_InstallAcceptanceDate;
            private Object ERP_InventoryDate;
            private Object ERP_OutstockDate;
            private Object ERP_Payer;
            private Object ERP_ProductModel;
            private Object ERP_ReceivablesPlan;
            private Object ERP_SignDate;
            private Object ERP_StorageDate;
            private Object ERP_TotalReceivable;

            public String getContractId() {
                return ContractId;
            }

            public void setContractId(String ContractId) {
                this.ContractId = ContractId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public String getContractName() {
                return ContractName;
            }

            public void setContractName(String ContractName) {
                this.ContractName = ContractName;
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

            public String getUnit() {
                return Unit;
            }

            public void setUnit(String Unit) {
                this.Unit = Unit;
            }

            public int getPaymentAppointment() {
                return PaymentAppointment;
            }

            public void setPaymentAppointment(int PaymentAppointment) {
                this.PaymentAppointment = PaymentAppointment;
            }

            public String getPaymentAppointmentName() {
                return PaymentAppointmentName;
            }

            public void setPaymentAppointmentName(String PaymentAppointmentName) {
                this.PaymentAppointmentName = PaymentAppointmentName;
            }

            public String getUserSite() {
                return UserSite;
            }

            public void setUserSite(String UserSite) {
                this.UserSite = UserSite;
            }

            public String getTaskBelonger() {
                return TaskBelonger;
            }

            public void setTaskBelonger(String TaskBelonger) {
                this.TaskBelonger = TaskBelonger;
            }

            public String getMoneyBelonger() {
                return MoneyBelonger;
            }

            public void setMoneyBelonger(String MoneyBelonger) {
                this.MoneyBelonger = MoneyBelonger;
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

            public String getBuyerName() {
                return BuyerName;
            }

            public void setBuyerName(String BuyerName) {
                this.BuyerName = BuyerName;
            }

            public String getAccountName() {
                return AccountName;
            }

            public void setAccountName(String AccountName) {
                this.AccountName = AccountName;
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

            public String getCapitalOccupyPrincipal() {
                return CapitalOccupyPrincipal;
            }

            public void setCapitalOccupyPrincipal(String CapitalOccupyPrincipal) {
                this.CapitalOccupyPrincipal = CapitalOccupyPrincipal;
            }

            public int getContracTotal() {
                return ContracTotal;
            }

            public void setContracTotal(int ContracTotal) {
                this.ContracTotal = ContracTotal;
            }

            public int getQuantity() {
                return Quantity;
            }

            public void setQuantity(int Quantity) {
                this.Quantity = Quantity;
            }

            public String getPaymentMode() {
                return PaymentMode;
            }

            public void setPaymentMode(String PaymentMode) {
                this.PaymentMode = PaymentMode;
            }

            public String getDeliveryAppointment() {
                return DeliveryAppointment;
            }

            public void setDeliveryAppointment(String DeliveryAppointment) {
                this.DeliveryAppointment = DeliveryAppointment;
            }

            public int getConfigurationRequire() {
                return ConfigurationRequire;
            }

            public void setConfigurationRequire(int ConfigurationRequire) {
                this.ConfigurationRequire = ConfigurationRequire;
            }

            public String getConfigurationRequireName() {
                return ConfigurationRequireName;
            }

            public void setConfigurationRequireName(String ConfigurationRequireName) {
                this.ConfigurationRequireName = ConfigurationRequireName;
            }

            public String getProductBasePrice() {
                return ProductBasePrice;
            }

            public void setProductBasePrice(String ProductBasePrice) {
                this.ProductBasePrice = ProductBasePrice;
            }

            public Object getOptions() {
                return Options;
            }

            public void setOptions(Object Options) {
                this.Options = Options;
            }

            public Object getOptionsPublishPrice() {
                return OptionsPublishPrice;
            }

            public void setOptionsPublishPrice(Object OptionsPublishPrice) {
                this.OptionsPublishPrice = OptionsPublishPrice;
            }

            public Object getPurchasingParts() {
                return PurchasingParts;
            }

            public void setPurchasingParts(Object PurchasingParts) {
                this.PurchasingParts = PurchasingParts;
            }

            public Object getPurchasingPublishPrice() {
                return PurchasingPublishPrice;
            }

            public void setPurchasingPublishPrice(Object PurchasingPublishPrice) {
                this.PurchasingPublishPrice = PurchasingPublishPrice;
            }

            public int getCommissionMode() {
                return CommissionMode;
            }

            public void setCommissionMode(int CommissionMode) {
                this.CommissionMode = CommissionMode;
            }

            public String getCommissionModeName() {
                return CommissionModeName;
            }

            public void setCommissionModeName(String CommissionModeName) {
                this.CommissionModeName = CommissionModeName;
            }

            public Object getCommissionEstimateAmount() {
                return CommissionEstimateAmount;
            }

            public void setCommissionEstimateAmount(Object CommissionEstimateAmount) {
                this.CommissionEstimateAmount = CommissionEstimateAmount;
            }

            public String getWarranty() {
                return Warranty;
            }

            public void setWarranty(String Warranty) {
                this.Warranty = Warranty;
            }

            public String getGuaranteePublishPrice() {
                return GuaranteePublishPrice;
            }

            public void setGuaranteePublishPrice(String GuaranteePublishPrice) {
                this.GuaranteePublishPrice = GuaranteePublishPrice;
            }

            public int getTransportMode() {
                return TransportMode;
            }

            public void setTransportMode(int TransportMode) {
                this.TransportMode = TransportMode;
            }

            public String getTransportModeName() {
                return TransportModeName;
            }

            public void setTransportModeName(String TransportModeName) {
                this.TransportModeName = TransportModeName;
            }

            public Object getFreightEstimateAmount() {
                return FreightEstimateAmount;
            }

            public void setFreightEstimateAmount(Object FreightEstimateAmount) {
                this.FreightEstimateAmount = FreightEstimateAmount;
            }

            public int getAmortizedMode() {
                return AmortizedMode;
            }

            public void setAmortizedMode(int AmortizedMode) {
                this.AmortizedMode = AmortizedMode;
            }

            public String getAmortizedModeName() {
                return AmortizedModeName;
            }

            public void setAmortizedModeName(String AmortizedModeName) {
                this.AmortizedModeName = AmortizedModeName;
            }

            public String getInterest() {
                return Interest;
            }

            public void setInterest(String Interest) {
                this.Interest = Interest;
            }

            public Object getTrainRequirement() {
                return TrainRequirement;
            }

            public void setTrainRequirement(Object TrainRequirement) {
                this.TrainRequirement = TrainRequirement;
            }

            public Object getTrainingEstimateAmount() {
                return TrainingEstimateAmount;
            }

            public void setTrainingEstimateAmount(Object TrainingEstimateAmount) {
                this.TrainingEstimateAmount = TrainingEstimateAmount;
            }

            public Object getHandlingRequirement() {
                return HandlingRequirement;
            }

            public void setHandlingRequirement(Object HandlingRequirement) {
                this.HandlingRequirement = HandlingRequirement;
            }

            public Object getHandlingEstimateAmount() {
                return HandlingEstimateAmount;
            }

            public void setHandlingEstimateAmount(Object HandlingEstimateAmount) {
                this.HandlingEstimateAmount = HandlingEstimateAmount;
            }

            public int getContractAmount() {
                return ContractAmount;
            }

            public void setContractAmount(int ContractAmount) {
                this.ContractAmount = ContractAmount;
            }

            public int getFinalEstimateAmount() {
                return FinalEstimateAmount;
            }

            public void setFinalEstimateAmount(int FinalEstimateAmount) {
                this.FinalEstimateAmount = FinalEstimateAmount;
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

            public int getStatus() {
                return Status;
            }

            public void setStatus(int Status) {
                this.Status = Status;
            }

            public Object getStatusName() {
                return StatusName;
            }

            public void setStatusName(Object StatusName) {
                this.StatusName = StatusName;
            }

            public String getERP_ContractNo() {
                return ERP_ContractNo;
            }

            public void setERP_ContractNo(String ERP_ContractNo) {
                this.ERP_ContractNo = ERP_ContractNo;
            }

            public Object getERP_AccountName() {
                return ERP_AccountName;
            }

            public void setERP_AccountName(Object ERP_AccountName) {
                this.ERP_AccountName = ERP_AccountName;
            }

            public Object getERP_ArriveDeliversDate() {
                return ERP_ArriveDeliversDate;
            }

            public void setERP_ArriveDeliversDate(Object ERP_ArriveDeliversDate) {
                this.ERP_ArriveDeliversDate = ERP_ArriveDeliversDate;
            }

            public Object getERP_Billing() {
                return ERP_Billing;
            }

            public void setERP_Billing(Object ERP_Billing) {
                this.ERP_Billing = ERP_Billing;
            }

            public Object getERP_BreakevenAmount() {
                return ERP_BreakevenAmount;
            }

            public void setERP_BreakevenAmount(Object ERP_BreakevenAmount) {
                this.ERP_BreakevenAmount = ERP_BreakevenAmount;
            }

            public Object getERP_Consignee() {
                return ERP_Consignee;
            }

            public void setERP_Consignee(Object ERP_Consignee) {
                this.ERP_Consignee = ERP_Consignee;
            }

            public Object getERP_ConstantlyReceivable() {
                return ERP_ConstantlyReceivable;
            }

            public void setERP_ConstantlyReceivable(Object ERP_ConstantlyReceivable) {
                this.ERP_ConstantlyReceivable = ERP_ConstantlyReceivable;
            }

            public Object getERP_ContactNumber() {
                return ERP_ContactNumber;
            }

            public void setERP_ContactNumber(Object ERP_ContactNumber) {
                this.ERP_ContactNumber = ERP_ContactNumber;
            }

            public Object getERP_ContractAmount() {
                return ERP_ContractAmount;
            }

            public void setERP_ContractAmount(Object ERP_ContractAmount) {
                this.ERP_ContractAmount = ERP_ContractAmount;
            }

            public Object getERP_DeliveryDate() {
                return ERP_DeliveryDate;
            }

            public void setERP_DeliveryDate(Object ERP_DeliveryDate) {
                this.ERP_DeliveryDate = ERP_DeliveryDate;
            }

            public Object getERP_InstallAcceptanceDate() {
                return ERP_InstallAcceptanceDate;
            }

            public void setERP_InstallAcceptanceDate(Object ERP_InstallAcceptanceDate) {
                this.ERP_InstallAcceptanceDate = ERP_InstallAcceptanceDate;
            }

            public Object getERP_InventoryDate() {
                return ERP_InventoryDate;
            }

            public void setERP_InventoryDate(Object ERP_InventoryDate) {
                this.ERP_InventoryDate = ERP_InventoryDate;
            }

            public Object getERP_OutstockDate() {
                return ERP_OutstockDate;
            }

            public void setERP_OutstockDate(Object ERP_OutstockDate) {
                this.ERP_OutstockDate = ERP_OutstockDate;
            }

            public Object getERP_Payer() {
                return ERP_Payer;
            }

            public void setERP_Payer(Object ERP_Payer) {
                this.ERP_Payer = ERP_Payer;
            }

            public Object getERP_ProductModel() {
                return ERP_ProductModel;
            }

            public void setERP_ProductModel(Object ERP_ProductModel) {
                this.ERP_ProductModel = ERP_ProductModel;
            }

            public Object getERP_ReceivablesPlan() {
                return ERP_ReceivablesPlan;
            }

            public void setERP_ReceivablesPlan(Object ERP_ReceivablesPlan) {
                this.ERP_ReceivablesPlan = ERP_ReceivablesPlan;
            }

            public Object getERP_SignDate() {
                return ERP_SignDate;
            }

            public void setERP_SignDate(Object ERP_SignDate) {
                this.ERP_SignDate = ERP_SignDate;
            }

            public Object getERP_StorageDate() {
                return ERP_StorageDate;
            }

            public void setERP_StorageDate(Object ERP_StorageDate) {
                this.ERP_StorageDate = ERP_StorageDate;
            }

            public Object getERP_TotalReceivable() {
                return ERP_TotalReceivable;
            }

            public void setERP_TotalReceivable(Object ERP_TotalReceivable) {
                this.ERP_TotalReceivable = ERP_TotalReceivable;
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
