package com.android.wandong.beans;

import java.util.List;

/**
 * Created by ${keke} on 16/8/11.
 */
public class MarketActivityCreateRequestBean {
    /**
     * DepartId : 23fad504-c232-e611-9c1b-085700e64e0f
     * Id :
     * PassWord : tanting123
     * OperType : 1
     * UserId : 20998760-65fd-e511-a1e5-085700e64e0f
     * HasChildren : false
     * IsAuditForm : false
     * UserName : tanting
     * IsStartWorkflow : true
     * EntityName : new_campaign
     * WorkflowFormInfo : {"AuditStatus":"","Opinion":"","StepNumber":""}
     * ApprovalPrice : 1235
     * FormInfo : [{"FieldValue":"活动名称","FieldName":"new_campaignname","FieldType":"2"},{"FieldValue":"2","FieldName":"new_costtype","FieldType":"1"},{"FieldValue":"1235","FieldName":"new_amount","FieldType":"3"},{"FieldValue":"2016-08-11","FieldName":"new_occurtime","FieldType":"5"},{"FieldValue":"备注","FieldName":"new_remark","FieldType":"2"}]
     */

    private String DepartId;
    private String Id;
    private String PassWord;
    private String OperType;
    private String UserId;
    private boolean HasChildren;
    private boolean IsAuditForm;
    private String UserName;
    private boolean IsStartWorkflow;
    private String EntityName;
    /**
     * AuditStatus :
     * Opinion :
     * StepNumber :
     */

    private WorkflowFormInfoBean WorkflowFormInfo;
    private String ApprovalPrice;
    /**
     * FieldValue : 活动名称
     * FieldName : new_campaignname
     * FieldType : 2
     */

    private List<FormInfoBean> FormInfo;

    public String getDepartId() {
        return DepartId;
    }

    public void setDepartId(String DepartId) {
        this.DepartId = DepartId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public String getOperType() {
        return OperType;
    }

    public void setOperType(String OperType) {
        this.OperType = OperType;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public boolean isHasChildren() {
        return HasChildren;
    }

    public void setHasChildren(boolean HasChildren) {
        this.HasChildren = HasChildren;
    }

    public boolean isIsAuditForm() {
        return IsAuditForm;
    }

    public void setIsAuditForm(boolean IsAuditForm) {
        this.IsAuditForm = IsAuditForm;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public boolean isIsStartWorkflow() {
        return IsStartWorkflow;
    }

    public void setIsStartWorkflow(boolean IsStartWorkflow) {
        this.IsStartWorkflow = IsStartWorkflow;
    }

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String EntityName) {
        this.EntityName = EntityName;
    }

    public WorkflowFormInfoBean getWorkflowFormInfo() {
        return WorkflowFormInfo;
    }

    public void setWorkflowFormInfo(WorkflowFormInfoBean WorkflowFormInfo) {
        this.WorkflowFormInfo = WorkflowFormInfo;
    }

    public String getApprovalPrice() {
        return ApprovalPrice;
    }

    public void setApprovalPrice(String ApprovalPrice) {
        this.ApprovalPrice = ApprovalPrice;
    }

    public List<FormInfoBean> getFormInfo() {
        return FormInfo;
    }

    public void setFormInfo(List<FormInfoBean> FormInfo) {
        this.FormInfo = FormInfo;
    }

    public static class WorkflowFormInfoBean {
        private String AuditStatus;
        private String Opinion;
        private String StepNumber;

        public String getAuditStatus() {
            return AuditStatus;
        }

        public void setAuditStatus(String AuditStatus) {
            this.AuditStatus = AuditStatus;
        }

        public String getOpinion() {
            return Opinion;
        }

        public void setOpinion(String Opinion) {
            this.Opinion = Opinion;
        }

        public String getStepNumber() {
            return StepNumber;
        }

        public void setStepNumber(String StepNumber) {
            this.StepNumber = StepNumber;
        }
    }

    public static class FormInfoBean {
        private String FieldValue;
        private String FieldName;
        private String FieldType;

        public String getFieldValue() {
            return FieldValue;
        }

        public void setFieldValue(String FieldValue) {
            this.FieldValue = FieldValue;
        }

        public String getFieldName() {
            return FieldName;
        }

        public void setFieldName(String FieldName) {
            this.FieldName = FieldName;
        }

        public String getFieldType() {
            return FieldType;
        }

        public void setFieldType(String FieldType) {
            this.FieldType = FieldType;
        }
    }
}
