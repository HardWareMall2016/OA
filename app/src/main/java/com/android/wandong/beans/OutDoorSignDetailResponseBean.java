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
public class OutDoorSignDetailResponseBean extends BaseResponseBean {

    /**
     * errorcode : 200
     * entityInfo : {"SignInfo":{"SignId":"f87cf60c-9b4d-e611-86c6-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄埔区北京东路689号","LocationTime":"/Date(1468923660000)/","Latitude":"31.244493","Longitude":"121.483663","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"😭🎶😂😩✌🏻😂😂⬇️🐴","SignInTime":"/Date(1468923902000)/","SignOutTime":"/Date(1468923929000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":null},"AttachmentInfo":["http://58.213.44.194:8889/UploadedFiles/5db04b64-7921-43ce-a8b5-cecf79ffa569.jpeg"]}
     */

    private int errorcode;
    /**
     * SignInfo : {"SignId":"f87cf60c-9b4d-e611-86c6-085700e64e0f","OwnerId":"c52610c5-60fd-e511-a1e5-085700e64e0f","OwnerName":"姓名","Address":"上海黄浦区北京东路668号","SignOutAddress":"上海黄埔区北京东路689号","LocationTime":"/Date(1468923660000)/","Latitude":"31.244493","Longitude":"121.483663","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","Remarks":"😭🎶😂😩✌🏻😂😂⬇️🐴","SignInTime":"/Date(1468923902000)/","SignOutTime":"/Date(1468923929000)/","Signabnormal":0,"SignInAbnormal":0,"AbnormalDistance":0,"PersonalImage":null}
     * AttachmentInfo : ["http://58.213.44.194:8889/UploadedFiles/5db04b64-7921-43ce-a8b5-cecf79ffa569.jpeg"]
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
        /**
         * SignId : f87cf60c-9b4d-e611-86c6-085700e64e0f
         * OwnerId : c52610c5-60fd-e511-a1e5-085700e64e0f
         * OwnerName : 姓名
         * Address : 上海黄浦区北京东路668号
         * SignOutAddress : 上海黄埔区北京东路689号
         * LocationTime : /Date(1468923660000)/
         * Latitude : 31.244493
         * Longitude : 121.483663
         * AccountId : 5640c2e6-5516-e611-ac23-085700e64e0f
         * AccountName : 襄城区余家湖社区卫生服务中心
         * Remarks : 😭🎶😂😩✌🏻😂😂⬇️🐴
         * SignInTime : /Date(1468923902000)/
         * SignOutTime : /Date(1468923929000)/
         * Signabnormal : 0
         * SignInAbnormal : 0
         * AbnormalDistance : 0
         * PersonalImage : null
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
            private double AbnormalDistance;
            private Object PersonalImage;

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

            public double getAbnormalDistance() {
                return AbnormalDistance;
            }

            public void setAbnormalDistance(double AbnormalDistance) {
                this.AbnormalDistance = AbnormalDistance;
            }

            public Object getPersonalImage() {
                return PersonalImage;
            }

            public void setPersonalImage(Object PersonalImage) {
                this.PersonalImage = PersonalImage;
            }
        }
    }
}
