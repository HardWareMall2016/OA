package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/8/19 23:37
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
public class MenuResponseBean extends BaseResponseBean {

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
        private String MobileMenuId;
        private String Name;
        private String EntityName;
        private int MenuLevel;
        private int Order;

        public String getMobileMenuId() {
            return MobileMenuId;
        }

        public void setMobileMenuId(String MobileMenuId) {
            this.MobileMenuId = MobileMenuId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getEntityName() {
            return EntityName;
        }

        public void setEntityName(String EntityName) {
            this.EntityName = EntityName;
        }

        public int getMenuLevel() {
            return MenuLevel;
        }

        public void setMenuLevel(int MenuLevel) {
            this.MenuLevel = MenuLevel;
        }

        public int getOrder() {
            return Order;
        }

        public void setOrder(int Order) {
            this.Order = Order;
        }
    }
}
