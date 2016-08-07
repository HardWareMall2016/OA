package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/8/7 20:43
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
public class WorkReportReplyListResponseBean extends BaseResponseBean {

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

        private List<ReplylistBean> replylist;
        private List<UserlistBean> userlist;

        public List<ReplylistBean> getReplylist() {
            return replylist;
        }

        public void setReplylist(List<ReplylistBean> replylist) {
            this.replylist = replylist;
        }

        public List<UserlistBean> getUserlist() {
            return userlist;
        }

        public void setUserlist(List<UserlistBean> userlist) {
            this.userlist = userlist;
        }

        public static class ReplylistBean {
            private String new_replycontent;
            private String new_headportrait;
            private String new_name;

            public String getNew_replycontent() {
                return new_replycontent;
            }

            public void setNew_replycontent(String new_replycontent) {
                this.new_replycontent = new_replycontent;
            }

            public String getNew_headportrait() {
                return new_headportrait;
            }

            public void setNew_headportrait(String new_headportrait) {
                this.new_headportrait = new_headportrait;
            }

            public String getNew_name() {
                return new_name;
            }

            public void setNew_name(String new_name) {
                this.new_name = new_name;
            }
        }

        public static class UserlistBean {
            private String new_headportrait;
            private String new_name;

            public String getNew_headportrait() {
                return new_headportrait;
            }

            public void setNew_headportrait(String new_headportrait) {
                this.new_headportrait = new_headportrait;
            }

            public String getNew_name() {
                return new_name;
            }

            public void setNew_name(String new_name) {
                this.new_name = new_name;
            }
        }
    }
}
