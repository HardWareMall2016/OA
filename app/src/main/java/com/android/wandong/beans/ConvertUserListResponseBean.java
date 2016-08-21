package com.android.wandong.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/8/21 15:33
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
public class ConvertUserListResponseBean extends BaseResponseBean {

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
        @JSONField(name = "SystemUserId")
        private String SystemUserId;
        @JSONField(name = "fullname")
        private String fullname;
        @JSONField(name = "new_headportrait")
        private String newHeadportrait;
        @JSONField(name = "new_hyphenateid")
        private String newHyphenateid;

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
