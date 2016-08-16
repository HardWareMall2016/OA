package com.android.wandong.ui.fragment.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.base.UserInfo;
import com.android.wandong.beans.LoginResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.activity.MainActivity;
import com.android.wandong.utils.Tools;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.zhan.framework.component.container.SingleTopFragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.activity.BaseActivity;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.ToastUtils;

/**
 * 作者：伍岳 on 2016/4/21 13:10
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
public class LoginFragment extends ABaseFragment {
    @ViewInject(id = R.id.btn_login, click = "OnClick")
    TextView mBtnLogin;
    @ViewInject(id = R.id.account)
    MaterialEditText mInputAccount;
    @ViewInject(id = R.id.password)
    MaterialEditText mInputPassword;

    private String mAccount;
    private String mPassword;

    public static void launch(Activity from) {
        SingleTopFragmentContainerActivity.launch(from, LoginFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);

    }

    @Override
    public void onPrepareSetContentView(BaseActivity activity) {
        super.onPrepareSetContentView(activity);
        activity.showBackIcon(false);
        activity.setTitle("登录");
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_login;
    }

    @Override
    public void onDestroyView() {
        //cancelCountDownTimer();
        super.onDestroyView();
    }

    void OnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (!checkAccountInput()) {
                    return;
                }
                if (!checkPasswordInput()) {
                    return;
                }

                loginRequest(mAccount, mPassword);
                break;
        }

    }

    private boolean checkPasswordInput() {
        mPassword = mInputPassword.getText().toString();
        if (TextUtils.isEmpty(mPassword)) {
            ToastUtils.toast("请输入密码");
            return false;
        }
        return true;
    }

    private boolean checkAccountInput() {
        mAccount = mInputAccount.getText().toString();
        if (TextUtils.isEmpty(mAccount)) {
            ToastUtils.toast("请输入手机号或邮箱");
            return false;
        }
        /*if (!Tools.checkMobilePhoneNumber(mAccount)) {
            ToastUtils.toast("请输入正确的手机号");
            return false;
        }*/
        return true;
    }


    private void loginRequest(String account,String password){
        if(isRequestProcessing(ApiUrls.LOGIN)){
            return;
        }
        showRotateProgressDialog("登录中...",false);
        HttpRequestParams requestParams=new HttpRequestParams();
        requestParams.put("UserName",account);
        requestParams.put("PassWord",password);
        startFormRequest(ApiUrls.LOGIN, requestParams, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                closeRotateProgressDialog();
                switch (resultCode) {
                    case success:
                        LoginResponseBean responseBean = Tools.parseJsonTostError(result, LoginResponseBean.class);
                        if (responseBean != null && responseBean.getEntityInfo() != null){
                            saveUserInfo(responseBean);
                            Intent homePageIntent = new Intent(getActivity(), MainActivity.class);
                            homePageIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(homePageIntent);
                            getActivity().finish();
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }


    private void saveUserInfo(LoginResponseBean responseBean){
        UserInfo user = new UserInfo();
        user.setLoginAccount(mAccount);
        user.setDepartId(responseBean.getEntityInfo().getDepartid());
        user.setDepartName(responseBean.getEntityInfo().getDepartname());
        user.setHeadPortrait(responseBean.getEntityInfo().getNew_headportrait());
        user.setUserId(responseBean.getEntityInfo().getUserId());
        user.setUserName(mAccount);
        user.setPassword(mPassword);
        user.setIsLogin(true);
        user.setIsLogin(true);

        UserInfo.saveLoginUserInfo(user);
    }


    //登录
    /*private void login(){
        if(isRequestProcessing(ApiUrls.TEACHER_LOGIN)){
            return;
        }
        LoginsRequestBean requestBean = new LoginsRequestBean();
        LoginsRequestBean.DataEntity dataEntity = new LoginsRequestBean.DataEntity();
        dataEntity.setPhone(mAccount);
        dataEntity.setPhoneChkNo(mPassword);
        requestBean.setData(dataEntity);
        startJsonRequest(ApiUrls.TEACHER_LOGIN, requestBean, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                switch (resultCode){
                    case success:
                        LoginsResponseBean responseBean= Tools.parseJsonTostError(result, LoginsResponseBean.class);
                        if(responseBean!=null){
                            ToastUtils.toast(responseBean.getMessage());
                            UserInfo user = new UserInfo();
                            user.setToken(responseBean.getData().getToken());
                            user.setUserID(responseBean.getData().getPersonId());
                            user.setPostId(responseBean.getData().getJobId());
                            user.setComId(responseBean.getData().getCompanyId());
                            user.setDeptid(responseBean.getData().getDepartmentId());
                            user.setHeadImgUrl(responseBean.getData().getImgUrl());
                            user.setIsLogin(true);

                            UserInfo.saveLoginUserInfo(user);

                            Intent homePageIntent = new Intent(getActivity(), MainActivity.class);
                            homePageIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(homePageIntent);
                            getActivity().finish();
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                }
            }
        });
    }*/

    //获取短信验证码
    /*private void getCodeRequest(){
        if(isRequestProcessing(ApiUrls.GET_CHECET_CODE)){
            return;
        }
        MessageCodeRequestBean request = new MessageCodeRequestBean();
        MessageCodeRequestBean.DataEntity dataEntity = new MessageCodeRequestBean.DataEntity();
        dataEntity.setPhone(mAccount);
        request.setData(dataEntity);
        startJsonRequest(ApiUrls.GET_CHECET_CODE, request, new HttpRequestHandler(this) {
            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                cancelCountDownTimer();
                switch (resultCode) {
                    case success:
                        MessageCodeResponseBean responseBean = Tools.parseJsonTostError(result, MessageCodeResponseBean.class);
                        if (responseBean != null) {
                            mMessageCode.setText(responseBean.getMessage());
                            mPassword = responseBean.getMessage();
                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                }
            }
        });
    }*/

    /*private void startCountDownTimer(){
        if(mTimer!=null){
            cancelCountDownTimer();
        }

        mLoginCode.setEnabled(false);
        mLoginCode.setTextColor(Color.rgb(102, 102, 102));
        mTimer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String formatStr = "%d秒后重试";
                mLoginCode.setText(String.format(formatStr, millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                mLoginCode.setEnabled(true);
                mLoginCode.setText(R.string.get_sms_code);
                mLoginCode.setTextColor(0xff9390A5);
            }
        };
        mTimer.start();

        getCodeRequest();
    }


    private void cancelCountDownTimer(){
        mLoginCode.setEnabled(true);
        mLoginCode.setText(R.string.get_sms_code);
        mLoginCode.setTextColor(0xff9390A5);
        if(mTimer!=null){
            mTimer.cancel();
        }
        mTimer=null;
    }*/


    /*private void loginDemo() {
        LoginRequestBean request = new LoginRequestBean();
        request.setToken("");
        LoginRequestBean.DataEntity data = new LoginRequestBean.DataEntity();
        data.setLoginName("jesse.huang@zhan.com");
        data.setPassWord(Tools.md5("1111110").substring(0, 20).toUpperCase());
        request.setData(data);
        startJsonRequest(ApiUrls.TEACHER_LOGIN, request, new HttpRequestHandler(this) {

            @Override
            public boolean isCacheData() {
                return true;
            }

            @Override
            public void onBeforeRequest() {
                showRotateProgressDialog("登陆...", true);
                List<ExampleCacheBean> cacheBeanList = getCacheData(ExampleCacheBean.class);
                if (cacheBeanList != null && cacheBeanList.size() > 0) {
                    Log.i("wuyue", "Get Cache success size = " + cacheBeanList.size());
                    for (ExampleCacheBean bean : cacheBeanList) {
                        Log.i("wuyue", "getName = " + bean.getName() + " , time = " + bean.getTime());
                    }
                } else {
                    Log.i("wuyue", "No Cache");
                }
            }

            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                super.onRequestFinished(resultCode, result);
                closeRotateProgressDialog();
            }

            @Override
            public void onRequestSucceeded(String content) {
                super.onRequestSucceeded(content);

                //缓存
                ExampleCacheBean bean = new ExampleCacheBean();
                bean.setName("KEKE");
                bean.setTime(System.currentTimeMillis());

                List<ExampleCacheBean> beans = new ArrayList<ExampleCacheBean>();
                beans.add(bean);

                bean = new ExampleCacheBean();
                bean.setName("WUYUE");
                bean.setTime(System.currentTimeMillis() + 100);
                beans.add(bean);

                bean = new ExampleCacheBean();
                bean.setName("MINGKUI");
                bean.setTime(System.currentTimeMillis() + 200);
                beans.add(bean);

                putCacheData(beans, ExampleCacheBean.class);


                //登陆
                UserInfo user = new UserInfo();
                user.setUserID(101);
                user.setIsLogin(true);
                UserInfo.saveLoginUserInfo(user);

                Intent homePageIntent = new Intent(getActivity(), MainActivity.class);
                homePageIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homePageIntent);

                getActivity().finish();
            }
        });
    }*/

}
