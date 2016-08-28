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

    @JSONField(name = "entityInfo")
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
        @JSONField(name = "ContractId")
        private String ContractId;
        @JSONField(name = "ApplyNo")
        private String ApplyNo;
        @JSONField(name = "ContractName")
        private String ContractName;
        @JSONField(name = "Status")
        private String Status;
        @JSONField(name = "ContracTotal")
        private String ContracTotal;
        @JSONField(name = "OwnerName")
        private String OwnerName;
        @JSONField(name = "CreatedOn")
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
    }
}
