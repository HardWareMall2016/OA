package com.android.wandong.base;

/**
 * 作者：伍岳 on 2015/12/10 12:59
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
public class BaseRequestBean {

    public BaseRequestBean(){
        /*if(UserInfo.getCurrentUser()!=null){
            setUserID(UserInfo.getCurrentUser().getUserID());
            setToken(UserInfo.getCurrentUser().getToken());
        }*/
    }

    /**
     * token :
     * Data : {}
     * userID :
     */

    private String token;
    private int userID;

    public void setToken(String Token) {
        this.token = Token;
    }

    public void setUserID(int UserId) {
        this.userID = UserId;
    }

    public String getToken() {
        return token;
    }

    public int getUserID() {
        return userID;
    }
}
