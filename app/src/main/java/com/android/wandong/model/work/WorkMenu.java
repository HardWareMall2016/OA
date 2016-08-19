package com.android.wandong.model.work;

import com.android.wandong.base.BasePersistObject;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：伍岳 on 2016/8/19 23:36
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
public class WorkMenu extends BasePersistObject {

    private static final long serialVersionUID = 3156046308314231340L;

    private List<MenuItem> menuItemList;

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
    }

    public static class MenuItem implements Serializable{
        private static final long serialVersionUID = 6779018399929726953L;

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

    private static WorkMenu sWorkMenu =null;

    public static WorkMenu getInstance() {
        if(sWorkMenu ==null){
            sWorkMenu =getPersisObject(WorkMenu.class);
        }
        return sWorkMenu;
    }

    public MenuItem getMenuByEntityName(String entityName){
        MenuItem menuItem=null;
        for(MenuItem item:menuItemList){
            if(entityName.equals(item.EntityName)){
                menuItem=item;
                break;
            }
        }

        return menuItem;
    }
}
