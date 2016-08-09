package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/8/9 23:05
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
public class AccountListResponseBean extends BaseResponseBean {
    private int errorcode;

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
        private int Total;
        private int NewCurrentMonthTotal;

        private java.util.List<ListBean> List;

        public int getTotal() {
            return Total;
        }

        public void setTotal(int Total) {
            this.Total = Total;
        }

        public int getNewCurrentMonthTotal() {
            return NewCurrentMonthTotal;
        }

        public void setNewCurrentMonthTotal(int NewCurrentMonthTotal) {
            this.NewCurrentMonthTotal = NewCurrentMonthTotal;
        }

        public List<ListBean> getList() {
            return List;
        }

        public void setList(List<ListBean> List) {
            this.List = List;
        }

        public static class ListBean {
            private String AccountId;
            private String Name;
            private String OwnerId;
            private String OwnerName;
            private int Level;
            private String Longitude;
            private String Latitude;
            private int Type;
            private String CreatedOn;
            private int ContractNumber;
            private int OpportunityNumber;

            public String getAccountId() {
                return AccountId;
            }

            public void setAccountId(String AccountId) {
                this.AccountId = AccountId;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
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

            public int getLevel() {
                return Level;
            }

            public void setLevel(int Level) {
                this.Level = Level;
            }

            public String getLongitude() {
                return Longitude;
            }

            public void setLongitude(String Longitude) {
                this.Longitude = Longitude;
            }

            public String getLatitude() {
                return Latitude;
            }

            public void setLatitude(String Latitude) {
                this.Latitude = Latitude;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }

            public String getCreatedOn() {
                return CreatedOn;
            }

            public void setCreatedOn(String CreatedOn) {
                this.CreatedOn = CreatedOn;
            }

            public int getContractNumber() {
                return ContractNumber;
            }

            public void setContractNumber(int ContractNumber) {
                this.ContractNumber = ContractNumber;
            }

            public int getOpportunityNumber() {
                return OpportunityNumber;
            }

            public void setOpportunityNumber(int OpportunityNumber) {
                this.OpportunityNumber = OpportunityNumber;
            }
        }
    }
}
