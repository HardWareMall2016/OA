package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/7/22 16:59
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
public class NoticeResponseBean extends BaseResponseBean {

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
        private String new_noticeinfoid;
        private String new_name;
        private Object new_content;
        private String new_appcontent;
        private String new_img;
        private String OwnerId;
        private String OwnerName;
        private String CreatedOn;

        public String getNew_noticeinfoid() {
            return new_noticeinfoid;
        }

        public void setNew_noticeinfoid(String new_noticeinfoid) {
            this.new_noticeinfoid = new_noticeinfoid;
        }

        public String getNew_name() {
            return new_name;
        }

        public void setNew_name(String new_name) {
            this.new_name = new_name;
        }

        public Object getNew_content() {
            return new_content;
        }

        public void setNew_content(Object new_content) {
            this.new_content = new_content;
        }

        public String getNew_appcontent() {
            return new_appcontent;
        }

        public void setNew_appcontent(String new_appcontent) {
            this.new_appcontent = new_appcontent;
        }

        public String getNew_img() {
            return new_img;
        }

        public void setNew_img(String new_img) {
            this.new_img = new_img;
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
    }
}
