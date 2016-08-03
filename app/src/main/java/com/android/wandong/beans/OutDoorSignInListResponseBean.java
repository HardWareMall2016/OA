package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * 作者：伍岳 on 2016/7/20 21:24
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
public class OutDoorSignInListResponseBean extends BaseResponseBean {

    /**
     * errorcode : 200
     * entityInfo : [{"SignInfo":{"SignId":"8ea31671-8b58-e611-92fc-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄埔区北京东路689号","LocationTime":"/Date(1470126360000)/","Latitude":"31.245183","Longitude":"121.484965","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"在于","SignInTime":"/Date(1470126661000)/","SignOutTime":"/Date(1470126863000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":["http://58.213.44.194:9001/UploadedFiles/25c0ea3f-d099-463a-b85d-97b4d7921fe7.jpeg","http://58.213.44.194:9001/UploadedFiles/5cf5d1bc-43bc-4a94-95c3-e59d1fb5d2e1.jpeg","http://58.213.44.194:9001/UploadedFiles/3c0e4a23-7734-4294-b349-ae3b5c402736.jpeg","http://58.213.44.194:9001/UploadedFiles/79e02b2c-31d8-4472-b7c6-31174d4cba03.jpeg","http://58.213.44.194:9001/UploadedFiles/6d6ccd61-1e8e-410c-bbda-27358cb2ac26.jpeg","http://58.213.44.194:9001/UploadedFiles/7ffea5c3-9a5b-44ed-9e19-a1fcf40cf15b.jpeg"]},{"SignInfo":{"SignId":"b1e55204-8a58-e611-92fc-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄埔区北京东路689号","LocationTime":"/Date(1470125580000)/","Latitude":"31.244514","Longitude":"121.483648","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"www","SignInTime":"/Date(1470126049000)/","SignOutTime":"/Date(1470126094000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":[]},{"SignInfo":{"SignId":"a1868129-8958-e611-92fc-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄埔区北京东路689号","SignOutAddress":"上海黄浦区北京东路668号","LocationTime":"/Date(1470125400000)/","Latitude":"31.244431","Longitude":"121.483694","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"呜呜呜呜","SignInTime":"/Date(1470125682000)/","SignOutTime":"/Date(1470125696000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":[]},{"SignInfo":{"SignId":"43e29e97-bb57-e611-92fc-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄浦区北京东路668号","LocationTime":"/Date(1470037140000)/","Latitude":"31.244445","Longitude":"121.483648","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"发福床","SignInTime":"/Date(1470037390000)/","SignOutTime":"/Date(1470037400000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":[]},{"SignInfo":{"SignId":"ea012169-bb57-e611-92fc-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄埔区北京东路689号","SignOutAddress":"上海黄浦区北京东路668号","LocationTime":"/Date(1470037020000)/","Latitude":"31.244453","Longitude":"121.483748","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"天天团购","SignInTime":"/Date(1470037312000)/","SignOutTime":"/Date(1470037347000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":["http://58.213.44.194:9001/UploadedFiles/c1961649-f31b-4d11-9e25-5844fd2396b0.jpeg"]},{"SignInfo":{"SignId":"5ad22997-7755-e611-96a5-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"黄浦区北京东路668号(近福建中路)","SignOutAddress":"上海黄浦区北京东路668号","LocationTime":"/Date(1469788020000)/","Latitude":"31.244647","Longitude":"121.484008","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"hhh签出","SignInTime":"/Date(1469788281000)/","SignOutTime":"/Date(1469788399000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":[]},{"SignInfo":{"SignId":"9d55cb52-7355-e611-96a5-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄浦区北京东路668号","LocationTime":"/Date(1469786160000)/","Latitude":"31.244514","Longitude":"121.483625","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"图片有几张。 不知道","SignInTime":"/Date(1469786449000)/","SignOutTime":"/Date(1469788055000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":["http://58.213.44.194:9001/UploadedFiles/96d4cd77-a446-499a-8001-faa1277b26d2.jpeg"]},{"SignInfo":{"SignId":"2039bc39-7355-e611-96a5-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄浦区北京东路668号","LocationTime":"/Date(1469786100000)/","Latitude":"31.244480","Longitude":"121.483594","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"测试测试中，测试测试测试","SignInTime":"/Date(1469786407000)/","SignOutTime":"/Date(1470032418000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":["http://58.213.44.194:9001/UploadedFiles/25c0ea3f-d099-463a-b85d-97b4d7921fe7.jpeg","http://58.213.44.194:9001/UploadedFiles/5cf5d1bc-43bc-4a94-95c3-e59d1fb5d2e1.jpeg","http://58.213.44.194:9001/UploadedFiles/3c0e4a23-7734-4294-b349-ae3b5c402736.jpeg","http://58.213.44.194:9001/UploadedFiles/79e02b2c-31d8-4472-b7c6-31174d4cba03.jpeg","http://58.213.44.194:9001/UploadedFiles/6d6ccd61-1e8e-410c-bbda-27358cb2ac26.jpeg","http://58.213.44.194:9001/UploadedFiles/7ffea5c3-9a5b-44ed-9e19-a1fcf40cf15b.jpeg"]},{"SignInfo":{"SignId":"58dd841e-7355-e611-96a5-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄浦区北京东路668号","LocationTime":"/Date(1469786100000)/","Latitude":"31.244527","Longitude":"121.483449","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"测试测试啊哈哈","SignInTime":"/Date(1469786361000)/","SignOutTime":"/Date(1469787716000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":[]},{"SignInfo":{"SignId":"7605f873-7255-e611-96a5-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄埔区北京东路689号","LocationTime":"/Date(1469785800000)/","Latitude":"31.244681","Longitude":"121.483594","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"测试测试在一次测试结果","SignInTime":"/Date(1469786075000)/","SignOutTime":"/Date(1470032693000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"},"AttachmentInfo":[]}]
     */

    private int errorcode;
    /**
     * SignInfo : {"SignId":"8ea31671-8b58-e611-92fc-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄埔区北京东路689号","LocationTime":"/Date(1470126360000)/","Latitude":"31.245183","Longitude":"121.484965","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"在于","SignInTime":"/Date(1470126661000)/","SignOutTime":"/Date(1470126863000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":"http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg"}
     * AttachmentInfo : ["http://58.213.44.194:9001/UploadedFiles/25c0ea3f-d099-463a-b85d-97b4d7921fe7.jpeg","http://58.213.44.194:9001/UploadedFiles/5cf5d1bc-43bc-4a94-95c3-e59d1fb5d2e1.jpeg","http://58.213.44.194:9001/UploadedFiles/3c0e4a23-7734-4294-b349-ae3b5c402736.jpeg","http://58.213.44.194:9001/UploadedFiles/79e02b2c-31d8-4472-b7c6-31174d4cba03.jpeg","http://58.213.44.194:9001/UploadedFiles/6d6ccd61-1e8e-410c-bbda-27358cb2ac26.jpeg","http://58.213.44.194:9001/UploadedFiles/7ffea5c3-9a5b-44ed-9e19-a1fcf40cf15b.jpeg"]
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
        /**
         * SignId : 8ea31671-8b58-e611-92fc-085700e64e0f
         * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
         * OwnerName : 姓名
         * Address : 上海黄浦区北京东路668号
         * SignOutAddress : 上海黄埔区北京东路689号
         * LocationTime : /Date(1470126360000)/
         * Latitude : 31.245183
         * Longitude : 121.484965
         * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
         * AccountName : 襄城区余家湖社区卫生服务中心
         * Remarks : 在于
         * SignInTime : /Date(1470126661000)/
         * SignOutTime : /Date(1470126863000)/
         * Signabnormal : 0
         * SignInAbnormal : 0
         * AbnormalDistance : 0
         * PersonalImage : http://58.213.44.194:9001/UploadedFiles/HeadPortrait/cc7e4862-1204-45a3-80a6-68ee24193775.jpeg
         */

        private SignInfoBean SignInfo;
        private List<String> AttachmentInfo;

        public SignInfoBean getSignInfo() {
            return SignInfo;
        }

        public void setSignInfo(SignInfoBean SignInfo) {
            this.SignInfo = SignInfo;
        }

        public List<String> getAttachmentInfo() {
            return AttachmentInfo;
        }

        public void setAttachmentInfo(List<String> AttachmentInfo) {
            this.AttachmentInfo = AttachmentInfo;
        }

        public static class SignInfoBean {
            private String SignId;
            private String OwnerId;
            private String OwnerName;
            private String Address;
            private String SignOutAddress;
            private String LocationTime;
            private String Latitude;
            private String Longitude;
            private String AccountId;
            private String AccountName;
            private String Remarks;
            private String SignInTime;
            private String SignOutTime;
            private int Signabnormal;
            private int SignInAbnormal;
            private int AbnormalDistance;
            private String PersonalImage;

            public String getSignId() {
                return SignId;
            }

            public void setSignId(String SignId) {
                this.SignId = SignId;
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

            public String getAddress() {
                return Address;
            }

            public void setAddress(String Address) {
                this.Address = Address;
            }

            public String getSignOutAddress() {
                return SignOutAddress;
            }

            public void setSignOutAddress(String SignOutAddress) {
                this.SignOutAddress = SignOutAddress;
            }

            public String getLocationTime() {
                return LocationTime;
            }

            public void setLocationTime(String LocationTime) {
                this.LocationTime = LocationTime;
            }

            public String getLatitude() {
                return Latitude;
            }

            public void setLatitude(String Latitude) {
                this.Latitude = Latitude;
            }

            public String getLongitude() {
                return Longitude;
            }

            public void setLongitude(String Longitude) {
                this.Longitude = Longitude;
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

            public String getRemarks() {
                return Remarks;
            }

            public void setRemarks(String Remarks) {
                this.Remarks = Remarks;
            }

            public String getSignInTime() {
                return SignInTime;
            }

            public void setSignInTime(String SignInTime) {
                this.SignInTime = SignInTime;
            }

            public String getSignOutTime() {
                return SignOutTime;
            }

            public void setSignOutTime(String SignOutTime) {
                this.SignOutTime = SignOutTime;
            }

            public int getSignabnormal() {
                return Signabnormal;
            }

            public void setSignabnormal(int Signabnormal) {
                this.Signabnormal = Signabnormal;
            }

            public int getSignInAbnormal() {
                return SignInAbnormal;
            }

            public void setSignInAbnormal(int SignInAbnormal) {
                this.SignInAbnormal = SignInAbnormal;
            }

            public int getAbnormalDistance() {
                return AbnormalDistance;
            }

            public void setAbnormalDistance(int AbnormalDistance) {
                this.AbnormalDistance = AbnormalDistance;
            }

            public String getPersonalImage() {
                return PersonalImage;
            }

            public void setPersonalImage(String PersonalImage) {
                this.PersonalImage = PersonalImage;
            }
        }
    }
}
