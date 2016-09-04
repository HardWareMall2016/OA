package com.android.wandong.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/8/28 21:16
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
public class MyAuditListResponseBean extends BaseResponseBean{
    @JSONField(name = "errorcode")
    private int errorcode;

    private List<EntityInfoBean> entityInfo;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public List<EntityInfoBean> getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(List<EntityInfoBean> entityInfo) {
        this.entityInfo = entityInfo;
    }

    public static class EntityInfoBean {
        //合同申请审批
        private String ContractId;
        private String ApplyNo;
        private String ContractName;
        private String Status;
        private String ContracTotal;

        //市场活动费申请审批
        private String CampaignId;
        //private String ApplyNo;
        //private String Name;
        private String CostTypeName;
        //private String Status;
        private String OccurTime;
        //private String Amount;

        //市场活动费报销审批
        //private String CampaignId;
        //private String ApplyNo;
        //private String Name;
        //private String CostTypeName;
        //private String OccurTime;
        //private String Amount;
        //private String Status;

        //专项费用报销审批
        private String Id;
        //private String ApplyNo;
        private String Amount;
        //private String Status;

        //差旅费报销
        private String TravelCostId;
        private String Name;
        private String ApprovalPrice;
        private String StepNumber;
        private String AuditStatus;

        //公共部分
        private String OwnerName;
        private String CreatedOn;

        public String getContractId() {
            return ContractId;
        }

        public void setContractId(String ContractId) {
            this.ContractId = ContractId;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public String getContractName() {
            return ContractName;
        }

        public void setContractName(String ContractName) {
            this.ContractName = ContractName;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public String getContracTotal() {
            return ContracTotal;
        }

        public void setContracTotal(String ContracTotal) {
            this.ContracTotal = ContracTotal;
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

        public String getTravelCostId() {
            return TravelCostId;
        }

        public void setTravelCostId(String travelCostId) {
            TravelCostId = travelCostId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getApprovalPrice() {
            return ApprovalPrice;
        }

        public void setApprovalPrice(String approvalPrice) {
            ApprovalPrice = approvalPrice;
        }

        public String getStepNumber() {
            return StepNumber;
        }

        public void setStepNumber(String stepNumber) {
            StepNumber = stepNumber;
        }

        public String getAuditStatus() {
            return AuditStatus;
        }

        public void setAuditStatus(String auditStatus) {
            AuditStatus = auditStatus;
        }

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getAmount() {
            return Amount;
        }

        public void setAmount(String amount) {
            Amount = amount;
        }

        public String getCampaignId() {
            return CampaignId;
        }

        public void setCampaignId(String campaignId) {
            CampaignId = campaignId;
        }

        public String getCostTypeName() {
            return CostTypeName;
        }

        public void setCostTypeName(String costTypeName) {
            CostTypeName = costTypeName;
        }

        public String getOccurTime() {
            return OccurTime;
        }

        public void setOccurTime(String occurTime) {
            OccurTime = occurTime;
        }
    }
}
