package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/10.
 */
public class AnnouncementCreatetDepartListResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : {"departlist":[{"type":3,"new_departmentId":"23fad504-c232-e611-9c1b-085700e64e0f","new_name":"营销中心"},{"type":3,"new_departmentId":"63750d60-c232-e611-9c1b-085700e64e0f","new_name":"技术服务"},{"type":3,"new_departmentId":"640e407b-c232-e611-9c1b-085700e64e0f","new_name":"品牌部"},{"type":3,"new_departmentId":"efd7b195-c232-e611-9c1b-085700e64e0f","new_name":"DR产品部"},{"type":3,"new_departmentId":"1d51bbb6-c232-e611-9c1b-085700e64e0f","new_name":"动态产品部"},{"type":3,"new_departmentId":"fec713d4-c232-e611-9c1b-085700e64e0f","new_name":"发生器产品部"},{"type":3,"new_departmentId":"200abef4-c232-e611-9c1b-085700e64e0f","new_name":"CT、探测器产品部"},{"type":3,"new_departmentId":"a5b0c90c-c332-e611-9c1b-085700e64e0f","new_name":"基础放射及部件产品部"},{"type":3,"new_departmentId":"8e4de723-c332-e611-9c1b-085700e64e0f","new_name":"MR产品部"},{"type":3,"new_departmentId":"718a4b99-c332-e611-9c1b-085700e64e0f","new_name":"研发质量部"},{"type":3,"new_departmentId":"abcd5fcf-c332-e611-9c1b-085700e64e0f","new_name":"财务部"}],"userlist":[{"type":1,"SystemUserId":"3492379e-d832-e611-9c1b-085700e64e0f","fullname":"谢宇峰","new_headportrait":"","new_hyphenateid":"test04"}]}
     */

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
        /**
         * type : 3
         * new_departmentId : 23fad504-c232-e611-9c1b-085700e64e0f
         * new_name : 营销中心
         */

        private List<DepartlistBean> departlist;
        /**
         * type : 1
         * SystemUserId : 3492379e-d832-e611-9c1b-085700e64e0f
         * fullname : 谢宇峰
         * new_headportrait :
         * new_hyphenateid : test04
         */

        private List<UserlistBean> userlist;

        public List<DepartlistBean> getDepartlist() {
            return departlist;
        }

        public void setDepartlist(List<DepartlistBean> departlist) {
            this.departlist = departlist;
        }

        public List<UserlistBean> getUserlist() {
            return userlist;
        }

        public void setUserlist(List<UserlistBean> userlist) {
            this.userlist = userlist;
        }

        public static class DepartlistBean {
            private int type;
            private String new_departmentId;
            private String new_name;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getNew_departmentId() {
                return new_departmentId;
            }

            public void setNew_departmentId(String new_departmentId) {
                this.new_departmentId = new_departmentId;
            }

            public String getNew_name() {
                return new_name;
            }

            public void setNew_name(String new_name) {
                this.new_name = new_name;
            }
        }

        public static class UserlistBean {
            private int type;
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

            public String getSystemUserId() {
                return SystemUserId;
            }

            public void setSystemUserId(String SystemUserId) {
                this.SystemUserId = SystemUserId;
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
}
