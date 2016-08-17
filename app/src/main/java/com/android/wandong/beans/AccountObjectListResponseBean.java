package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/17.
 */
public class AccountObjectListResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : [{"userid":"c5d00e9b-de32-e611-9c1b-085700e64e0f","fullname":"杨硕","new_departmentid":"70c98201-c432-e611-9c1b-085700e64e0f","new_departmentname":"本部运营","new_hyphenateid":"","new_headportrait":""},{"userid":"c52610c5-60fd-e511-a1e5-085700e64e0f","fullname":"姓名","new_departmentid":"72e28524-c632-e611-9c1b-085700e64e0f","new_departmentname":"上海","new_hyphenateid":"administrator","new_headportrait":"~/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},{"userid":"3492379e-d832-e611-9c1b-085700e64e0f","fullname":"谢宇峰","new_departmentid":"58bc13e5-c132-e611-9c1b-085700e64e0f","new_departmentname":"万东医疗","new_hyphenateid":"","new_headportrait":""},{"userid":"aa052247-9c54-e611-be6c-085700e64e0f","fullname":"销售总监","new_departmentid":"23fad504-c232-e611-9c1b-085700e64e0f","new_departmentname":"营销中心","new_hyphenateid":"test3","new_headportrait":""},{"userid":"fe139861-9b54-e611-be6c-085700e64e0f","fullname":"销售员","new_departmentid":"58e28524-c632-e611-9c1b-085700e64e0f","new_departmentname":"豫","new_hyphenateid":"test1","new_headportrait":""},{"userid":"24efbb90-6c34-e611-8588-085700e64e0f","fullname":"王亚男","new_departmentid":"58e28524-c632-e611-9c1b-085700e64e0f","new_departmentname":"豫","new_hyphenateid":"","new_headportrait":""},{"userid":"20998760-65fd-e511-a1e5-085700e64e0f","fullname":"檀庭","new_departmentid":"23fad504-c232-e611-9c1b-085700e64e0f","new_departmentname":"营销中心","new_hyphenateid":"tanting","new_headportrait":"~/UploadedFiles/HeadPortrait/cb5dc38b-5d3a-49e6-83b3-d25c1c79453c.png"},{"userid":"8d220e6f-6734-e611-8588-085700e64e0f","fullname":"韩志","new_departmentid":"58e28524-c632-e611-9c1b-085700e64e0f","new_departmentname":"豫","new_hyphenateid":"","new_headportrait":""},{"userid":"027503d7-9b54-e611-be6c-085700e64e0f","fullname":"单元经理","new_departmentid":"58e28524-c632-e611-9c1b-085700e64e0f","new_departmentname":"豫","new_hyphenateid":"test2","new_headportrait":""}]
     */

    private int errorcode;
    /**
     * userid : c5d00e9b-de32-e611-9c1b-085700e64e0f
     * fullname : 杨硕
     * new_departmentid : 70c98201-c432-e611-9c1b-085700e64e0f
     * new_departmentname : 本部运营
     * new_hyphenateid :
     * new_headportrait :
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
        private String userid;
        private String fullname;
        private String new_departmentid;
        private String new_departmentname;
        private String new_hyphenateid;
        private String new_headportrait;

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getFullname() {
            return fullname;
        }

        public void setFullname(String fullname) {
            this.fullname = fullname;
        }

        public String getNew_departmentid() {
            return new_departmentid;
        }

        public void setNew_departmentid(String new_departmentid) {
            this.new_departmentid = new_departmentid;
        }

        public String getNew_departmentname() {
            return new_departmentname;
        }

        public void setNew_departmentname(String new_departmentname) {
            this.new_departmentname = new_departmentname;
        }

        public String getNew_hyphenateid() {
            return new_hyphenateid;
        }

        public void setNew_hyphenateid(String new_hyphenateid) {
            this.new_hyphenateid = new_hyphenateid;
        }

        public String getNew_headportrait() {
            return new_headportrait;
        }

        public void setNew_headportrait(String new_headportrait) {
            this.new_headportrait = new_headportrait;
        }
    }
}
