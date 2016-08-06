package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class SpecialDuesReimburseResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"Id":"f37b953a-e65a-e611-92fc-085700e64e0f","ApplyNo":"ZXBX201608000006","Status":3,"OwnerName":"姓名","CostType":2,"Amount":200,"Remark":"备注内容","CreatedOn":"/Date(1470385556000)/"},{"Id":"edd001a3-3b5a-e611-92fc-085700e64e0f","ApplyNo":"ZXBX201608000005","Status":3,"OwnerName":"tanting","CostType":2,"Amount":500,"Remark":"提前预支","CreatedOn":"/Date(1470312287000)/"},{"Id":"950adbe2-265a-e611-92fc-085700e64e0f","ApplyNo":"ZXBX201608000004","Status":2,"OwnerName":"tanting","CostType":2,"Amount":5888,"Remark":"哪来的暑假","CreatedOn":"/Date(1470303375000)/"},{"Id":"f14765e0-6e59-e611-92fc-085700e64e0f","ApplyNo":"ZXBX201608000003","Status":3,"OwnerName":"姓名","CostType":2,"Amount":20,"Remark":"拍啊","CreatedOn":"/Date(1470224343000)/"},{"Id":"fae9aeac-6e59-e611-92fc-085700e64e0f","ApplyNo":"ZXBX201608000002","Status":3,"OwnerName":"姓名","CostType":2,"Amount":5.0004444E7,"Remark":"就是报销","CreatedOn":"/Date(1470224256000)/"},{"Id":"1b24b9c9-6d59-e611-92fc-085700e64e0f","ApplyNo":"ZXBX201608000001","Status":2,"OwnerName":"姓名","CostType":2,"Amount":8.00000123E8,"Remark":"七月交通补助","CreatedOn":"/Date(1470223876000)/"},{"Id":"2ecee302-5655-e611-96a5-085700e64e0f","ApplyNo":"ZXBX201607000013","Status":2,"OwnerName":"姓名","CostType":8,"Amount":500,"Remark":"改变","CreatedOn":"/Date(1469773859000)/"},{"Id":"c7e33a9b-5455-e611-96a5-085700e64e0f","ApplyNo":"ZXBX201607000012","Status":2,"OwnerName":"姓名","CostType":5,"Amount":9.87654321E8,"Remark":"投标","CreatedOn":"/Date(1469773256000)/"},{"Id":"bae8fc44-5455-e611-96a5-085700e64e0f","ApplyNo":"ZXBX201607000011","Status":2,"OwnerName":"姓名","CostType":7,"Amount":5.8000022E7,"Remark":"开学","CreatedOn":"/Date(1469773111000)/"},{"Id":"6f595e1b-5455-e611-96a5-085700e64e0f","ApplyNo":"ZXBX201607000010","Status":2,"OwnerName":"姓名","CostType":3,"Amount":58,"Remark":"打电话买票","CreatedOn":"/Date(1469773041000)/"}]
     */

    private int errorcode;
    /**
     * Id : f37b953a-e65a-e611-92fc-085700e64e0f
     * ApplyNo : ZXBX201608000006
     * Status : 3
     * OwnerName : 姓名
     * CostType : 2
     * Amount : 200.0
     * Remark : 备注内容
     * CreatedOn : /Date(1470385556000)/
     */

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
        private String Id;
        private String ApplyNo;
        private int Status;
        private String OwnerName;
        private int CostType;
        private double Amount;
        private String Remark;
        private String CreatedOn;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String OwnerName) {
            this.OwnerName = OwnerName;
        }

        public int getCostType() {
            return CostType;
        }

        public void setCostType(int CostType) {
            this.CostType = CostType;
        }

        public double getAmount() {
            return Amount;
        }

        public void setAmount(double Amount) {
            this.Amount = Amount;
        }

        public String getRemark() {
            return Remark;
        }

        public void setRemark(String Remark) {
            this.Remark = Remark;
        }

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String CreatedOn) {
            this.CreatedOn = CreatedOn;
        }
    }
}
