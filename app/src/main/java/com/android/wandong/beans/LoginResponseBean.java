package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

/**
 * 作者：伍岳 on 2016/7/16 11:57
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
public class LoginResponseBean extends BaseResponseBean {

    /**
     * errorcode : 0
     * entityInfo : {"userId":"c52610c5-60fd-e511-a1e5-085700e64e0f","userName":"姓名","departid":"72e28524-c632-e611-9c1b-085700e64e0f","departname":"上海","new_hyphenateid":"","new_headportrait":"~/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"}
     */

    private int errorcode;
    /**
     * userId : c52610c5-60fd-e511-a1e5-085700e64e0f
     * userName : 姓名
     * departid : 72e28524-c632-e611-9c1b-085700e64e0f
     * departname : 上海
     * new_hyphenateid :
     * new_headportrait : ~/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg
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
        private String userId;
        private String userName;
        private String departid;
        private String departname;
        private String new_hyphenateid;
        private String new_headportrait;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getDepartid() {
            return departid;
        }

        public void setDepartid(String departid) {
            this.departid = departid;
        }

        public String getDepartname() {
            return departname;
        }

        public void setDepartname(String departname) {
            this.departname = departname;
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
