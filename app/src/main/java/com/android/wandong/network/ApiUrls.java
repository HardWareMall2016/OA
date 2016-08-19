package com.android.wandong.network;

/**
 * 作者：伍岳 on 2016/3/7 17:34
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
public class ApiUrls {
    /***
     * 登录注册模块
     */
    public static final String LOGIN = "Common/Login.ashx";


    /***
     *  工作模块
     */
    //外勤签到-列表
    public static final String OUTDOOR_SIGN_IN_LIST = "MySign/List.ashx";
    //外勤签到-详情
    public static final String OUTDOOR_SIGN_DETAIL = "MySign/Detail.ashx";
    //外勤签到-签出
    public static final String OUTDOOR_SIGN_OUT = "MySign/SignOut.ashx";
    //工作报告-列表
    public static final String WORK_REPORT_LIST = "WorkReport/List.ashx";

    //公告通知-列表
    public static final String NOTICE_LIST = "Notice/Notice/List.ashx";
    //新建公告—发布公告
    public static final String NOTICE_ADD = "Notice/Notice/Add.ashx";
    //新建公告－公告对象列表
    public static final String NOTICE_CONTACTS_USER_list = "Contacts/ConvertUserList.ashx";
    //新建公告－确定公告对象
    public static final String NOTICE_CONTACTS_USERS = "Contacts/Users.ashx";
    //新建公告—按组织结构查看列表
    public static final String CONTACTS_DEPARTMENTS = "Contacts/Departments.ashx";
    //新建公告－按工作岗位查看列表
    public static final String CONTACTS_WORKROLES = "Contacts/WorkRoles.ashx";


    //合同申请列表
    public static final String CONTRACT_APPLY_LIST = "ContractApply/List.ashx";
    //新建合同申请－产品线
    public static final String OPPORTUNITY_GETPRODUCT_CLASSIFY = "Opportunity/GetProductClassify.ashx";
    //新建合同申请－产品型号
    public static final String OPPORTUNITY_GETPRODUCT = "Opportunity/GetProduct.ashx";
    //新建合同申请－配置要求
    public static final String COMMON_GETOPION_VALUE = "Common/GetOptionValue.ashx";

    //招待申请-列表
    public static final String ENTERTAIN_APPLY_LIST = "EntertainApply/List.ashx";

    //市场活动费申请
    public static final String  COMPAIGN_APPLY_LIST = "Campaign/Apply/List.ashx";
    //市场活动费申请列表详情
    public static final String COMPAIGN_APPLY_DETAIL = "Campaign/Apply/Detail.ashx";
    //新建市场活动费申请
    public static final String COMMON_SUBMIT_APPLY = "Common/SubmitApply.ashx";
    //新建市场活动费申请-选择费用类型
    public static final String COMMON_GETOPTION_VALUE = "Common/GetOptionValue.ashx";

    //市场活动费报销
    public static final String  CAMPAIGN_EXPENSE_LIST = "Campaign/Expense/List.ashx";
    //市场活动费报销详情
     public static final String CAMPAIGN_EXPENSE_DETAIL = "Campaign/Expense/Detail.ashx";

    //招待申请-招待详情
    public static final String ENTERTAIN_APPLY_DETAIL = "EntertainApply/Detail.ashx";

    //招待费报销列表
    public static final String ENTER_TAIN_EXPENSE = "EntertainExpense/List.ashx";
    //招待费报销详情
    public static final String ENTER_TAIN_EXPENSE_DETAIL="EntertainExpense/Detail.ashx";

    //专项费报销
    public static final String  DAILY_EXPENSE_LIST = "DailyExpense/List.ashx";
    //专项费报销详情
    public static final String DAILY_EXPENSE_DETAIL = "DailyExpense/Detail.ashx";

    //差旅费报销
     public static final String TRAVEL_EXPENSE_LIST = "TravelExpense/List.ashx";
    //差旅费报销详情
     public static final String TRAVEL_EXPENSE_DETAIL = "TravelExpense/Detail.ashx";

    //考察接待申请_ 列表
     public static final String RECEPTION_LIST = "Reception/List.ashx";
    //考察接待申请详情
     public static final String RECEPTION_DETAIL = "Reception/Detail.ashx";

    //招投标申请_列表
    public static final String TENDER_AUTHORIZATION_APPLY_LIST = "TenderAuthorizationApply/List.ashx";
    //招投标申请详情
    public static final String TENDER_AUTHORIZATION_APPLY_DETAIL = "TenderAuthorizationApply/Detail.ashx";

    //工作报告详情_回复列表
    public static final String WORK_REPORT_GET_REPLY_USERS_LIST = "WorkReport/GetReplyUsersList.ashx";

    //工作报告详情_发送消息
    public static final String WORK_REPORT_SEND_REPLY_CONTENT = "WorkReport/SendReplyContent.ashx";

    //获取账户列表
    public static final String ACCOUNT_LIST = "Account/List.ashx";

    //外勤签到-签入
    public static final String MYSIGN_SIGNIN= "MySign/SignIn.ashx";
    //外勤签到-签出
    public static final String MYSIGN_SIGN_OUT= "MySign/SignOut.ashx";

    //工作报告-写日报 周报
    public static final String WORKREPORT_SENDREPORT= "WorkReport/SendReport.ashx";
    //工作报告-今日休息
    public static final String WORKREPORT_SENDCURDAYREST= "WorkReport/SendCurDayRest.ashx";

    //上传图片
    public static final String UPLOAD_IMAGES= "Common/UploadImgs.ashx";
}
