package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/7/22 09:53
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
public class WorkReportListResponseBean extends BaseResponseBean {

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
        private String entityId;
        private String new_workplan;
        private String new_workexperience;
        private String new_reporttype;
        private String ownerid;
        private String new_headportrait;
        private String new_hyphenateid;
        private String ownername;
        private String createdon;
        private String new_commentpersonid;
        private String new_commentperson;
        private String new_commenttime;
        private String new_commentcontent;
        private String new_scorelabel;
        private int new_score;
        private String new_isrest;
        private String new_replynumber;

        private List<NewWorksummaryBean> new_worksummary;

        public String getEntityId() {
            return entityId;
        }

        public void setEntityId(String entityId) {
            this.entityId = entityId;
        }

        public String getNew_workplan() {
            return new_workplan;
        }

        public void setNew_workplan(String new_workplan) {
            this.new_workplan = new_workplan;
        }

        public String getNew_workexperience() {
            return new_workexperience;
        }

        public void setNew_workexperience(String new_workexperience) {
            this.new_workexperience = new_workexperience;
        }

        public String getNew_reporttype() {
            return new_reporttype;
        }

        public void setNew_reporttype(String new_reporttype) {
            this.new_reporttype = new_reporttype;
        }

        public String getOwnerid() {
            return ownerid;
        }

        public void setOwnerid(String ownerid) {
            this.ownerid = ownerid;
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

        public String getOwnername() {
            return ownername;
        }

        public void setOwnername(String ownername) {
            this.ownername = ownername;
        }

        public String getCreatedon() {
            return createdon;
        }

        public void setCreatedon(String createdon) {
            this.createdon = createdon;
        }

        public String getNew_commentpersonid() {
            return new_commentpersonid;
        }

        public void setNew_commentpersonid(String new_commentpersonid) {
            this.new_commentpersonid = new_commentpersonid;
        }

        public String getNew_commentperson() {
            return new_commentperson;
        }

        public void setNew_commentperson(String new_commentperson) {
            this.new_commentperson = new_commentperson;
        }

        public String getNew_commenttime() {
            return new_commenttime;
        }

        public void setNew_commenttime(String new_commenttime) {
            this.new_commenttime = new_commenttime;
        }

        public String getNew_commentcontent() {
            return new_commentcontent;
        }

        public void setNew_commentcontent(String new_commentcontent) {
            this.new_commentcontent = new_commentcontent;
        }

        public String getNew_scorelabel() {
            return new_scorelabel;
        }

        public void setNew_scorelabel(String new_scorelabel) {
            this.new_scorelabel = new_scorelabel;
        }

        public int getNew_score() {
            return new_score;
        }

        public void setNew_score(int new_score) {
            this.new_score = new_score;
        }

        public String getNew_isrest() {
            return new_isrest;
        }

        public void setNew_isrest(String new_isrest) {
            this.new_isrest = new_isrest;
        }

        public String getNew_replynumber() {
            return new_replynumber;
        }

        public void setNew_replynumber(String new_replynumber) {
            this.new_replynumber = new_replynumber;
        }

        public List<NewWorksummaryBean> getNew_worksummary() {
            return new_worksummary;
        }

        public void setNew_worksummary(List<NewWorksummaryBean> new_worksummary) {
            this.new_worksummary = new_worksummary;
        }

        public static class NewWorksummaryBean {
            private String new_customerid;
            private String new_customername;
            private String new_workcontent;

            public String getNew_customerid() {
                return new_customerid;
            }

            public void setNew_customerid(String new_customerid) {
                this.new_customerid = new_customerid;
            }

            public String getNew_customername() {
                return new_customername;
            }

            public void setNew_customername(String new_customername) {
                this.new_customername = new_customername;
            }

            public String getNew_workcontent() {
                return new_workcontent;
            }

            public void setNew_workcontent(String new_workcontent) {
                this.new_workcontent = new_workcontent;
            }
        }
    }
}
