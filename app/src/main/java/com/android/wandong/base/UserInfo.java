package com.android.wandong.base;

/**
 * 作者：伍岳 on 2015/10/14 12:00
 * 邮箱：wuyue8512@163.com
 //
 //         .............................................
 //                  美女坐镇                  BUG辟易
 //         .............................................
 //
 //                       .::::.
 //                     .::::::::.
 //                    :::::::::::
 //                 ..:::::::::::'
 //              '::::::::::::'
 //                .::::::::::
 //           '::::::::::::::..
 //                ..::::::::::::.
 //              ``::::::::::::::::
 //               ::::``:::::::::'        .:::.
 //              ::::'   ':::::'       .::::::::.
 //            .::::'      ::::     .:::::::'::::.
 //           .:::'       :::::  .:::::::::' ':::::.
 //          .::'        :::::.:::::::::'      ':::::.
 //         .::'         ::::::::::::::'         ``::::.
 //     ...:::           ::::::::::::'              ``::.
 //    ```` ':.          ':::::::::'                  ::::..
 //                       '.:::::'                    ':'````..
 //
 */
public class UserInfo extends BasePersistObject {
    private boolean isLogin =false;
    private String userId;
    private String userName;
    private String departId;
    private String departName;
    private String headPortrait;
    private String password;

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

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setIsLogin(boolean isLogin) {
        this.isLogin = isLogin;
    }

    private static UserInfo sUserInfo=null;

    public static UserInfo getCurrentUser() {
        if(sUserInfo==null){
            sUserInfo=getPersisObject(UserInfo.class);
        }
        return sUserInfo;
    }

    public static void saveLoginUserInfo(UserInfo user) {
        //如果登录的不是同一个用户就清除相关数据
        /*if(getCurrentUser()==null||!getCurrentUser().getUserID().equals(user.getUserID())){
            PushMessageInfo.clearPushMessageInfo();
        }*/
        persisObject(user);
        sUserInfo=user;
    }

    public static void logout() {
        if(sUserInfo!=null){
            sUserInfo.setIsLogin(false);
            persisObject(sUserInfo);
        }
        //PushMessageInfo.clearPushMessageInfo();
        /*deletePersistObject(UserInfo.class);
        sUserInfo=null;*/
    }

}
