package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：蒲柯柯 on 2016/9/2 15:28
 * 邮箱：983198505@qq.com
 * 介绍:
 */
public class ReplyDetailRequestBean extends BaseResponseBean {
    /**
     * DepartId : 58e28524-c632-e611-9c1b-085700e64e0f
     * Id : 42d69db2-ff65-e611-92fc-085700e64e0f
     * OperType : 2
     * PassWord : 12345678
     * UserId : 027503d7-9b54-e611-be6c-085700e64e0f
     * HasChildren : false
     * IsAuditForm : true
     * EntityName : new_entertaincost
     * UserName : test2
     * IsStartWorkflow : true
     * ApprovalPrice : 220.00
     * WorkflowFormInfo : {"Auditstatus":"4","Opinion":"","StepNumber":"1"}
     * FormInfo : []
     */

    private String DepartId;
    private String Id;
    private String OperType;
    private String PassWord;
    private String UserId;
    private boolean HasChildren;
    private boolean IsAuditForm;
    private String EntityName;
    private String UserName;
    private boolean IsStartWorkflow;
    private String ApprovalPrice;
    /**
     * Auditstatus : 4
     * Opinion :
     * StepNumber : 1
     */

    private WorkflowFormInfoBean WorkflowFormInfo;
    private List<?> FormInfo;

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

    public String getOperType() {
        return OperType;
    }

    public void setOperType(String OperType) {
        this.OperType = OperType;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
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

    public String getEntityName() {
        return EntityName;
    }

    public void setEntityName(String EntityName) {
        this.EntityName = EntityName;
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

    public String getApprovalPrice() {
        return ApprovalPrice;
    }

    public void setApprovalPrice(String ApprovalPrice) {
        this.ApprovalPrice = ApprovalPrice;
    }

    public WorkflowFormInfoBean getWorkflowFormInfo() {
        return WorkflowFormInfo;
    }

    public void setWorkflowFormInfo(WorkflowFormInfoBean WorkflowFormInfo) {
        this.WorkflowFormInfo = WorkflowFormInfo;
    }

    public List<?> getFormInfo() {
        return FormInfo;
    }

    public void setFormInfo(List<?> FormInfo) {
        this.FormInfo = FormInfo;
    }

    public static class WorkflowFormInfoBean {
        private String Auditstatus;
        private String Opinion;
        private String StepNumber;

        public String getAuditstatus() {
            return Auditstatus;
        }

        public void setAuditstatus(String Auditstatus) {
            this.Auditstatus = Auditstatus;
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
}
