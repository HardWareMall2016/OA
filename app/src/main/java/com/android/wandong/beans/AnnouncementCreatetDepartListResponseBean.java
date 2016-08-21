package com.android.wandong.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 16/8/10 12:38
 * 邮箱：wuyue8512@163.com
 //
 //         .............................................
 //                  美女坐镇                  BUG辟易
 //         .............................................
 //
 //                       .::::.
 //                     .::::::::.
 //                    :::::::::::
 //                 ..:::::::::::'
 //              '::::::::::::'
 //                .::::::::::
 //           '::::::::::::::..
 //                ..::::::::::::.
 //              ``::::::::::::::::
 //               ::::``:::::::::'        .:::.
 //              ::::'   ':::::'       .::::::::.
 //            .::::'      ::::     .:::::::'::::.
 //           .:::'       :::::  .:::::::::' ':::::.
 //          .::'        :::::.:::::::::'      ':::::.
 //         .::'         ::::::::::::::'         ``::::.
 //     ...:::           ::::::::::::'              ``::.
 //    ```` ':.          ':::::::::'                  ::::..
 //                       '.:::::'                    ':'````..
 //
 */
public class AnnouncementCreatetDepartListResponseBean extends BaseResponseBean {

    /**
     * errorcode : 200
     * entityInfo : {"departlist":[{"type":3,"new_departmentId":"23fad504-c232-e611-9c1b-085700e64e0f","new_name":"营销中心"},{"type":3,"new_departmentId":"63750d60-c232-e611-9c1b-085700e64e0f","new_name":"技术服务"},{"type":3,"new_departmentId":"640e407b-c232-e611-9c1b-085700e64e0f","new_name":"品牌部"},{"type":3,"new_departmentId":"efd7b195-c232-e611-9c1b-085700e64e0f","new_name":"DR产品部"},{"type":3,"new_departmentId":"1d51bbb6-c232-e611-9c1b-085700e64e0f","new_name":"动态产品部"},{"type":3,"new_departmentId":"fec713d4-c232-e611-9c1b-085700e64e0f","new_name":"发生器产品部"},{"type":3,"new_departmentId":"200abef4-c232-e611-9c1b-085700e64e0f","new_name":"CT、探测器产品部"},{"type":3,"new_departmentId":"a5b0c90c-c332-e611-9c1b-085700e64e0f","new_name":"基础放射及部件产品部"},{"type":3,"new_departmentId":"8e4de723-c332-e611-9c1b-085700e64e0f","new_name":"MR产品部"},{"type":3,"new_departmentId":"718a4b99-c332-e611-9c1b-085700e64e0f","new_name":"研发质量部"},{"type":3,"new_departmentId":"abcd5fcf-c332-e611-9c1b-085700e64e0f","new_name":"财务部"}],"userlist":[{"type":1,"SystemUserId":"3492379e-d832-e611-9c1b-085700e64e0f","fullname":"谢宇峰","new_headportrait":"","new_hyphenateid":""}]}
     */

    @JSONField(name = "errorcode")
    private int errorcode;
    @JSONField(name = "entityInfo")
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

        @JSONField(name = "departlist")
        private List<DepartlistBean> departlist;
        /**
         * type : 1
         * SystemUserId : 3492379e-d832-e611-9c1b-085700e64e0f
         * fullname : 谢宇峰
         * new_headportrait :
         * new_hyphenateid :
         */

        @JSONField(name = "userlist")
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
            @JSONField(name = "type")
            private int type;
            @JSONField(name = "new_departmentId")
            private String newDepartmentId;
            @JSONField(name = "new_name")
            private String newName;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getNewDepartmentId() {
                return newDepartmentId;
            }

            public void setNewDepartmentId(String newDepartmentId) {
                this.newDepartmentId = newDepartmentId;
            }

            public String getNewName() {
                return newName;
            }

            public void setNewName(String newName) {
                this.newName = newName;
            }
        }

        public static class UserlistBean {
            @JSONField(name = "type")
            private int type;
            @JSONField(name = "SystemUserId")
            private String SystemUserId;
            @JSONField(name = "fullname")
            private String fullname;
            @JSONField(name = "new_headportrait")
            private String newHeadportrait;
            @JSONField(name = "new_hyphenateid")
            private String newHyphenateid;

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

            public String getNewHeadportrait() {
                return newHeadportrait;
            }

            public void setNewHeadportrait(String newHeadportrait) {
                this.newHeadportrait = newHeadportrait;
            }

            public String getNewHyphenateid() {
                return newHyphenateid;
            }

            public void setNewHyphenateid(String newHyphenateid) {
                this.newHyphenateid = newHyphenateid;
            }
        }
    }
}
