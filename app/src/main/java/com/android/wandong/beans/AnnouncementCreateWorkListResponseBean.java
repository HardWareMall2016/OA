package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/11.
 */
public class AnnouncementCreateWorkListResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : [{"type":2,"RoleId":"b5de9668-6a34-e611-8588-085700e64e0f","Name":"单元总经理"},{"type":2,"RoleId":"4c5e5182-6a34-e611-8588-085700e64e0f","Name":"单元副总经理"},{"type":2,"RoleId":"176b45a3-6a34-e611-8588-085700e64e0f","Name":"市场专员"},{"type":2,"RoleId":"08c855dc-6a34-e611-8588-085700e64e0f","Name":"财务部经理"},{"type":2,"RoleId":"399afaaa-c732-e611-9c1b-085700e64e0f","Name":"副总经理"},{"type":2,"RoleId":"a20ee94a-c832-e611-9c1b-085700e64e0f","Name":"营销中心销售总监"},{"type":2,"RoleId":"89233765-c832-e611-9c1b-085700e64e0f","Name":"营销中心运营总监"},{"type":2,"RoleId":"f54c1778-c832-e611-9c1b-085700e64e0f","Name":"营销中心市场总监"},{"type":2,"RoleId":"6bae5198-c832-e611-9c1b-085700e64e0f","Name":"区域总监"},{"type":2,"RoleId":"52df4674-5d33-e611-9c1b-085700e64e0f","Name":"运营专员"},{"type":2,"RoleId":"c9450d8e-5d33-e611-9c1b-085700e64e0f","Name":"产品专员"},{"type":2,"RoleId":"8600279d-5d33-e611-9c1b-085700e64e0f","Name":"法务专员"},{"type":2,"RoleId":"bd2693bf-5d33-e611-9c1b-085700e64e0f","Name":"商务专员"},{"type":2,"RoleId":"263dacc9-5d33-e611-9c1b-085700e64e0f","Name":"成品库管专员"},{"type":2,"RoleId":"3e9102bf-60fd-e511-a1e5-085700e64e0f","Name":"业务经理"},{"type":2,"RoleId":"ed2410c5-60fd-e511-a1e5-085700e64e0f","Name":"总经理"},{"type":2,"RoleId":"889fcd84-5334-e611-b907-085700e64e0f","Name":"单元运营专员"}]
     */

    private int errorcode;
    /**
     * type : 2
     * RoleId : b5de9668-6a34-e611-8588-085700e64e0f
     * Name : 单元总经理
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
        private int type;
        private String RoleId;
        private String Name;
        private String SystemUserId;
        private String fullname;
        private String new_headportrait;
        private String new_hyphenateid;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getRoleId() {
            return RoleId;
        }

        public void setRoleId(String RoleId) {
            this.RoleId = RoleId;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getSystemUserId() {
            return SystemUserId;
        }

        public void setSystemUserId(String systemUserId) {
            SystemUserId = systemUserId;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getNew_headportrait() {
            return new_headportrait;
        }

        public void setNew_headportrait(String new_headportrait) {
            this.new_headportrait = new_headportrait;
        }

        public String getNew_hyphenateid() {
            return new_hyphenateid;
        }

        public void setNew_hyphenateid(String new_hyphenateid) {
            this.new_hyphenateid = new_hyphenateid;
        }
    }
}
