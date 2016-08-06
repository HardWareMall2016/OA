package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/8/6 13:15
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
public class EntertainApplyListResponseBean extends BaseResponseBean {

    /**
     * errorcode : 0
     * entityInfo : [{"EntertainId":"9b6797e5-9249-e611-86c6-085700e64e0f","ApplyNo":"ZDSQ201607000025","EstimateTotal":0,"AccountId":"e23fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"保山仁济医院","Reason":"招待费测试","Number":1,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg","OwnerName":"姓名","CreatedOn":"/Date(1500016595000)/","Status":3},{"EntertainId":"c34d599f-b55a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000022","EstimateTotal":800,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"Sy","Number":3,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470364680000)/","Status":4},{"EntertainId":"19d2a3d8-3b5a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000021","EstimateTotal":56726,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"这些是从","Number":5319,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470312377000)/","Status":3},{"EntertainId":"eed001a3-3b5a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000019","EstimateTotal":0,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"测试你的时候你","Number":2,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470312293000)/","Status":2},{"EntertainId":"efd001a3-3b5a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000020","EstimateTotal":0,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"测试你的时候你","Number":2,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470312293000)/","Status":2},{"EntertainId":"141d0df0-3a5a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000018","EstimateTotal":900,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"招待费申请呼呼呼","Number":888,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470311987000)/","Status":4},{"EntertainId":"a91b7621-275a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000017","EstimateTotal":8000,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"有朋自远方来","Number":6,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470303480000)/","Status":3},{"EntertainId":"55232555-245a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000016","EstimateTotal":67,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"Fhjjjkkl","Number":2,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470302278000)/","Status":1},{"EntertainId":"082c99a2-235a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000015","EstimateTotal":987512,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"吃啊","Number":965,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470301978000)/","Status":1},{"EntertainId":"cf07239a-235a-e611-92fc-085700e64e0f","ApplyNo":"ZDSQ201608000014","EstimateTotal":987512,"AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Reason":"吃啊","Number":965,"PersonalImage":null,"OwnerName":"tanting","CreatedOn":"/Date(1470301964000)/","Status":1}]
     */

    private int errorcode;
    /**
     * EntertainId : 9b6797e5-9249-e611-86c6-085700e64e0f
     * ApplyNo : ZDSQ201607000025
     * EstimateTotal : 0.0
     * AccountId : e23fc2e6-5516-e611-ac23-085700e64e0f
     * AccountName : 保山仁济医院
     * Reason : 招待费测试
     * Number : 1
     * PersonalImage : http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg
     * OwnerName : 姓名
     * CreatedOn : /Date(1500016595000)/
     * Status : 3
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
        private String EntertainId;
        private String ApplyNo;
        private double EstimateTotal;
        private String AccountId;
        private String AccountName;
        private String Reason;
        private int Number;
        private String PersonalImage;
        private String OwnerName;
        private String CreatedOn;
        private int Status;

        public String getEntertainId() {
            return EntertainId;
        }

        public void setEntertainId(String EntertainId) {
            this.EntertainId = EntertainId;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public double getEstimateTotal() {
            return EstimateTotal;
        }

        public void setEstimateTotal(double EstimateTotal) {
            this.EstimateTotal = EstimateTotal;
        }

        public String getAccountId() {
            return AccountId;
        }

        public void setAccountId(String AccountId) {
            this.AccountId = AccountId;
        }

        public String getAccountName() {
            return AccountName;
        }

        public void setAccountName(String AccountName) {
            this.AccountName = AccountName;
        }

        public String getReason() {
            return Reason;
        }

        public void setReason(String Reason) {
            this.Reason = Reason;
        }

        public int getNumber() {
            return Number;
        }

        public void setNumber(int Number) {
            this.Number = Number;
        }

        public String getPersonalImage() {
            return PersonalImage;
        }

        public void setPersonalImage(String PersonalImage) {
            this.PersonalImage = PersonalImage;
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

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }
    }
}
