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

    /**
     * errorcode : 0
     * entityInfo : [{"new_noticeinfoid":"62ef2dde-3e59-e611-92fc-085700e64e0f","new_name":"每次都zhanw","new_content":null,"new_appcontent":"p","AttachmentsList":["http://58.213.44.194:9001/UploadedFiles/5c1d92ec-e513-458d-a977-ff110fe168bb.jpeg","http://58.213.44.194:9001/UploadedFiles/c5b47439-53cc-434b-99bc-4dab89e3140e.jpeg","http://58.213.44.194:9001/UploadedFiles/d0df38e0-0d21-4f23-a4d4-c8c9281d947a.jpeg"],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470203724000)/"},{"new_noticeinfoid":"50369838-3e59-e611-92fc-085700e64e0f","new_name":"让人听过后","new_content":null,"new_appcontent":"这也有很高","AttachmentsList":[],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470203446000)/"},{"new_noticeinfoid":"bb0fe6e3-f757-e611-92fc-085700e64e0f","new_name":"why","new_content":null,"new_appcontent":"Why","AttachmentsList":["http://58.213.44.194:9001/UploadedFiles/2252833c-760d-4e7b-9829-e497a8a9d6a2.jpeg"],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470063288000)/"},{"new_noticeinfoid":"d776d9da-f657-e611-92fc-085700e64e0f","new_name":"12","new_content":null,"new_appcontent":"123","AttachmentsList":[],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470062843000)/"},{"new_noticeinfoid":"f35849c9-f257-e611-92fc-085700e64e0f","new_name":"123","new_content":null,"new_appcontent":"123","AttachmentsList":[],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470061096000)/"},{"new_noticeinfoid":"6cc47f29-c457-e611-92fc-085700e64e0f","new_name":"我","new_content":null,"new_appcontent":"我们的","AttachmentsList":[],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470041071000)/"},{"new_noticeinfoid":"3c87e0eb-c257-e611-92fc-085700e64e0f","new_name":"饿饿","new_content":null,"new_appcontent":"你们","AttachmentsList":[],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470040538000)/"},{"new_noticeinfoid":"c2bc864d-c257-e611-92fc-085700e64e0f","new_name":"fff","new_content":null,"new_appcontent":"tt","AttachmentsList":[],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470040272000)/"},{"new_noticeinfoid":"3b8a5134-c257-e611-92fc-085700e64e0f","new_name":"达到","new_content":null,"new_appcontent":"达到","AttachmentsList":[],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470040230000)/"},{"new_noticeinfoid":"d1eec724-c257-e611-92fc-085700e64e0f","new_name":"共同","new_content":null,"new_appcontent":"公告","AttachmentsList":[],"OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","CreatedOn":"/Date(1470040204000)/"}]
     */

    private int errorcode;
    /**
     * new_noticeinfoid : 62ef2dde-3e59-e611-92fc-085700e64e0f
     * new_name : 每次都zhanw
     * new_content : null
     * new_appcontent : p
     * AttachmentsList : ["http://58.213.44.194:9001/UploadedFiles/5c1d92ec-e513-458d-a977-ff110fe168bb.jpeg","http://58.213.44.194:9001/UploadedFiles/c5b47439-53cc-434b-99bc-4dab89e3140e.jpeg","http://58.213.44.194:9001/UploadedFiles/d0df38e0-0d21-4f23-a4d4-c8c9281d947a.jpeg"]
     * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
     * OwnerName : 姓名
     * CreatedOn : /Date(1470203724000)/
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
        private String new_noticeinfoid;
        private String new_name;
        private String new_content;
        private String new_appcontent;
        private String OwnerId;
        private String OwnerName;
        private String CreatedOn;
        private List<String> AttachmentsList;

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

        public String getNew_content() {
            return new_content;
        }

        public void setNew_content(String new_content) {
            this.new_content = new_content;
        }

        public String getNew_appcontent() {
            return new_appcontent;
        }

        public void setNew_appcontent(String new_appcontent) {
            this.new_appcontent = new_appcontent;
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
