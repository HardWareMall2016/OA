package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.ConvertUserListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestHandler;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.widget.ActionSheetDialog;
import com.zhan.framework.utils.ToastUtils;

/**
 * 作者：伍岳 on 16/8/10 15:25
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
public class AnnouncementCreateFragment extends ABaseFragment {
    private final static int REQUEST_CODE = 100;

    @ViewInject(id = R.id.imgAddPhoto, click = "OnClick")
    ImageView mAddPhoto;
    @ViewInject(id = R.id.announcement_object, click = "OnClick")
    RelativeLayout mAnnouncementObject;
    @ViewInject(id = R.id.announcement_object_number)
    TextView mObjectNumber;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_announcement_create;
    }

    public static void launch(Activity mActivity) {
        FragmentContainerActivity.launch(mActivity, AnnouncementCreateFragment.class, null);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("发布公告");
    }


    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.imgAddPhoto:
                ActionSheetDialog actionSheetDialog = new ActionSheetDialog(getActivity());
                actionSheetDialog.builder();
                actionSheetDialog.addSheetItem("拍照", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {

                    }
                });
                actionSheetDialog.addSheetItem("相册", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {

                    }
                });

                actionSheetDialog.show();
                break;
            case R.id.announcement_object:
                AnnouncementCreateObjectFragment.launchForResult(AnnouncementCreateFragment.this, REQUEST_CODE);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo = (AnnouncementCreateObjectFragment.AnnounceObjectInfo) data.getSerializableExtra(AnnouncementCreateObjectFragment.EXT_DATA_KEY);
            requestAnnouncementCreateObject(selectInfo);
        }
    }

    private void requestAnnouncementCreateObject(AnnouncementCreateObjectFragment.AnnounceObjectInfo selectInfo) {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        String roles = "";
        for (String item : selectInfo.roles) {
            if (TextUtils.isEmpty(roles)) {
                roles = item;
            } else {
                roles += "," + item;
            }
        }
        String departs = "";
        for (String item : selectInfo.departs) {
            if (TextUtils.isEmpty(departs)) {
                departs = item;
            } else {
                departs += "," + item;
            }
        }
        String user = "";
        for (String item : selectInfo.users) {
            if (TextUtils.isEmpty(user)) {
                user = item;
            } else {
                user += "," + item;
            }
        }
        requestParams.put("roles", roles);
        requestParams.put("departs", departs);
        requestParams.put("users", user);
        startFormRequest(ApiUrls.CONTACTS_CONVERT_USERLIST, requestParams, new HttpRequestHandler(this) {
            @Override
            public void onPrepare() {
                showRotateProgressDialog("正在获取中...",false);
            }

            @Override
            public void onRequestFinished(ResultCode resultCode, String result) {
                closeRotateProgressDialog();
                switch (resultCode) {
                    case success:
                        ConvertUserListResponseBean responseBean = Tools.parseJsonTostError(result, ConvertUserListResponseBean.class);
                        if (responseBean != null) {

                        }
                        break;
                    default:
                        ToastUtils.toast(result);
                        break;
                }
            }
        }, HttpRequestUtils.RequestType.POST);
    }

}
