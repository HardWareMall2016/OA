package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/21.
 */
public class ContractApplicationCreateBusinessListResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : {"Total":"3","TotalAmount":"11055.00","CurrentMonthTotal":"1","CurrentMonthAmountTotal":"11000.00","List":[{"OpportunityId":"b0ac9878-2f65-e611-92fc-085700e64e0f","Name":"姓名","AccountName":"襄城区余家湖社区卫生服务中心","Stage":8,"EstimatedCloseDate":"/Date(1470931200000)/","EstimatedValue":11000,"OwnerName":"姓名","CreatedOn":"/Date(1471516525000)/"},{"OpportunityId":"e30f1331-d326-e611-a831-085700e64e0f","Name":"接口测试商机","AccountName":"保山仁济医院","Stage":8,"EstimatedCloseDate":"/Date(1464271500000)/","EstimatedValue":22.5,"OwnerName":"檀庭","CreatedOn":"/Date(1464659919000)/"},{"OpportunityId":"c454fdc6-4f26-e611-97c0-085700e64e0f","Name":"陈晗修改商机","AccountName":"保山仁济医院","Stage":8,"EstimatedCloseDate":"/Date(1467110340000)/","EstimatedValue":32.5,"OwnerName":"姓名","CreatedOn":"/Date(1464603477000)/"}]}
     */

    private int errorcode;
    /**
     * Total : 3
     * TotalAmount : 11055.00
     * CurrentMonthTotal : 1
     * CurrentMonthAmountTotal : 11000.00
     * List : [{"OpportunityId":"b0ac9878-2f65-e611-92fc-085700e64e0f","Name":"姓名","AccountName":"襄城区余家湖社区卫生服务中心","Stage":8,"EstimatedCloseDate":"/Date(1470931200000)/","EstimatedValue":11000,"OwnerName":"姓名","CreatedOn":"/Date(1471516525000)/"},{"OpportunityId":"e30f1331-d326-e611-a831-085700e64e0f","Name":"接口测试商机","AccountName":"保山仁济医院","Stage":8,"EstimatedCloseDate":"/Date(1464271500000)/","EstimatedValue":22.5,"OwnerName":"檀庭","CreatedOn":"/Date(1464659919000)/"},{"OpportunityId":"c454fdc6-4f26-e611-97c0-085700e64e0f","Name":"陈晗修改商机","AccountName":"保山仁济医院","Stage":8,"EstimatedCloseDate":"/Date(1467110340000)/","EstimatedValue":32.5,"OwnerName":"姓名","CreatedOn":"/Date(1464603477000)/"}]
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
        private String Total;
        private String TotalAmount;
        private String CurrentMonthTotal;
        private String CurrentMonthAmountTotal;
        /**
         * OpportunityId : b0ac9878-2f65-e611-92fc-085700e64e0f
         * Name : 姓名
         * AccountName : 襄城区余家湖社区卫生服务中心
         * Stage : 8
         * EstimatedCloseDate : /Date(1470931200000)/
         * EstimatedValue : 11000
         * OwnerName : 姓名
         * CreatedOn : /Date(1471516525000)/
         */

        private java.util.List<ListBean> List;

        public String getTotal() {
            return Total;
        }

        public void setTotal(String Total) {
            this.Total = Total;
        }

        public String getTotalAmount() {
            return TotalAmount;
        }

        public void setTotalAmount(String TotalAmount) {
            this.TotalAmount = TotalAmount;
        }

        public String getCurrentMonthTotal() {
            return CurrentMonthTotal;
        }

        public void setCurrentMonthTotal(String CurrentMonthTotal) {
            this.CurrentMonthTotal = CurrentMonthTotal;
        }

        public String getCurrentMonthAmountTotal() {
            return CurrentMonthAmountTotal;
        }

        public void setCurrentMonthAmountTotal(String CurrentMonthAmountTotal) {
            this.CurrentMonthAmountTotal = CurrentMonthAmountTotal;
        }

        public List<ListBean> getList() {
            return List;
        }

        public void setList(List<ListBean> List) {
            this.List = List;
        }

        public static class ListBean {
            private String OpportunityId;
            private String Name;
            private String AccountName;
            private int Stage;
            private String EstimatedCloseDate;
            private double EstimatedValue;
            private String OwnerName;
            private String CreatedOn;

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

            public String getAccountName() {
                return AccountName;
            }

            public void setAccountName(String AccountName) {
                this.AccountName = AccountName;
            }

            public int getStage() {
                return Stage;
            }

            public void setStage(int Stage) {
                this.Stage = Stage;
            }

            public String getEstimatedCloseDate() {
                return EstimatedCloseDate;
            }

            public void setEstimatedCloseDate(String EstimatedCloseDate) {
                this.EstimatedCloseDate = EstimatedCloseDate;
            }

            public double getEstimatedValue() {
                return EstimatedValue;
            }

            public void setEstimatedValue(double EstimatedValue) {
                this.EstimatedValue = EstimatedValue;
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
}
