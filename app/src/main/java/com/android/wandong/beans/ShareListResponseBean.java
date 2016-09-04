package com.android.wandong.beans;

import com.alibaba.fastjson.annotation.JSONField;
import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/9/4 13:18
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
public class ShareListResponseBean extends BaseResponseBean {

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
        @JSONField(name = "new_shareid")
        private String newShareid;
        @JSONField(name = "new_name")
        private String newName;
        @JSONField(name = "new_content")
        private String newContent;
        @JSONField(name = "new_replynumber")
        private String newReplynumber;
        @JSONField(name = "OwnerId")
        private String OwnerId;
        @JSONField(name = "OwnerName")
        private String OwnerName;
        @JSONField(name = "CreatedOn")
        private String CreatedOn;
        @JSONField(name = "AttachmentsList")
        private List<String> AttachmentsList;

        public String getNewShareid() {
            return newShareid;
        }

        public void setNewShareid(String newShareid) {
            this.newShareid = newShareid;
        }

        public String getNewName() {
            return newName;
        }

        public void setNewName(String newName) {
            this.newName = newName;
        }

        public String getNewContent() {
            return newContent;
        }

        public void setNewContent(String newContent) {
            this.newContent = newContent;
        }

        public String getNewReplynumber() {
            return newReplynumber;
        }

        public void setNewReplynumber(String newReplynumber) {
            this.newReplynumber = newReplynumber;
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

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String CreatedOn) {
            this.CreatedOn = CreatedOn;
        }

        public List<String> getAttachmentsList() {
            return AttachmentsList;
        }

        public void setAttachmentsList(List<String> AttachmentsList) {
            this.AttachmentsList = AttachmentsList;
        }
    }
}
