package com.android.wandong.beans;

import java.io.Serializable;

/**
 * Created by ${keke} on 16/8/21.
 */
public class ContractContent implements Serializable {


    private String AccountName ;//客户名称
    private String BuyerName ;//买方名称
    private String ContractName;//合同名称
    private String DeliveryAppointment;//交货约定
    private String MoneyBelonger;//奖金归属人
    private String OpportunityId;
    private String ProductClassifyId ;
    private String ProductId ;
    private String Quantity;//销售数量
    private String TaskBelonger;//任务归属人
    private String Unit;//所属单元
    private String ContractAmount ;//合同总价
    private String UserSite ;//用户所在地区
    private String ProductBasePrice ; //产品基价

    public String getProductBasePrice() {
        return ProductBasePrice;
    }

    public void setProductBasePrice(String productBasePrice) {
        ProductBasePrice = productBasePrice;
    }

    public String getUserSite() {
        return UserSite;
    }

    public void setUserSite(String userSite) {
        UserSite = userSite;
    }

    public String getContractAmount() {
        return ContractAmount;
    }

    public void setContractAmount(String contractAmount) {
        ContractAmount = contractAmount;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(String buyerName) {
        BuyerName = buyerName;
    }

    public String getContractName() {
        return ContractName;
    }

    public void setContractName(String contractName) {
        ContractName = contractName;
    }

    public String getDeliveryAppointment() {
        return DeliveryAppointment;
    }

    public void setDeliveryAppointment(String deliveryAppointment) {
        DeliveryAppointment = deliveryAppointment;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getTaskBelonger() {
        return TaskBelonger;
    }

    public void setTaskBelonger(String taskBelonger) {
        TaskBelonger = taskBelonger;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public String getProductClassifyId() {
        return ProductClassifyId;
    }

    public void setProductClassifyId(String productClassifyId) {
        ProductClassifyId = productClassifyId;
    }

    public String getOpportunityId() {
        return OpportunityId;
    }

    public void setOpportunityId(String opportunityId) {
        OpportunityId = opportunityId;
    }

    public String getMoneyBelonger() {
        return MoneyBelonger;
    }

    public void setMoneyBelonger(String moneyBelonger) {
        MoneyBelonger = moneyBelonger;
    }

}
