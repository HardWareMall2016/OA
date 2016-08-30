package com.android.wandong.beans;

import java.io.Serializable;

/**
 * 作者：蒲柯柯 on 2016/8/30 11:34
 * 邮箱：983198505@qq.com
 * 介绍:
 */
public class ContractApplicationDetailContent implements Serializable {
    private String ApplyNo;
    private String ContractId;
    private String ContractName;
    private int Status;
    private String OwnerName ;
    private int ContracTotal ;
    private String CreatedOn;

    public String getApplyNo() {
        return ApplyNo;
    }

    public void setApplyNo(String applyNo) {
        ApplyNo = applyNo;
    }


    public String getContractId() {
        return ContractId;
    }

    public void setContractId(String contractId) {
        ContractId = contractId;
    }

    public String getContractName() {
        return ContractName;
    }

    public void setContractName(String contractName) {
        ContractName = contractName;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public int getContracTotal() {
        return ContracTotal;
    }

    public void setContracTotal(int contracTotal) {
        ContracTotal = contracTotal;
    }

    public String getCreatedOn() {
        return CreatedOn;
    }

    public void setCreatedOn(String createdOn) {
        CreatedOn = createdOn;
    }

}
