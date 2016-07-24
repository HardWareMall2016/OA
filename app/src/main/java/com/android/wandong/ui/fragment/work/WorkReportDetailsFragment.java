package com.android.wandong.ui.fragment.work;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.beans.OutDoorSignInListResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.ui.widget.FixListView;
import com.android.wandong.utils.Tools;
import com.zhan.framework.component.container.FragmentArgs;
import com.zhan.framework.component.container.FragmentContainerActivity;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.adapter.ABaseAdapter;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;

import java.util.ArrayList;

/**
 * 作者：伍岳 on 2016/7/23 16:34
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
public class WorkReportDetailsFragment extends ABaseFragment {
    private final static String ARG_KEY = "arg_key";

    @ViewInject(id = R.id.comments_list)
    protected FixListView mListViewComments;

    @ViewInject(id = R.id.click_to_input, click = "OnClick")
    protected EditText mViewClickToInput;
    //Data
    private String mReportId;
    private String mCommentsContent;

    public static void launch(Activity activity, String id) {
        FragmentArgs args = new FragmentArgs();
        args.add(ARG_KEY, id);
        FragmentContainerActivity.launch(activity, WorkReportDetailsFragment.class, args);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mReportId = savedInstanceState == null ? (String) getArguments().getSerializable(ARG_KEY) : (String) savedInstanceState.getSerializable(ARG_KEY);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(ARG_KEY, mReportId);
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        getActivity().setTitle("日报详情");
    }

    @Override
    public void onActionBarMenuClick() {
        WorkReportCalendarFragment.launch(getActivity());
    }

    @Override
    public void onPrepareActionbarMenu(TextView menu, final Activity activity) {
        String html = "<img src='" + R.drawable.icon_occupy + "'/>";
        Html.ImageGetter imgGetter = new Html.ImageGetter() {

            @Override
            public Drawable getDrawable(String source) {
                int id = Integer.parseInt(source);
                Drawable d = activity.getResources().getDrawable(id);
                d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
                return d;
            }
        };
        CharSequence charSequence = Html.fromHtml(html, imgGetter, null);
        menu.setText(charSequence);
        menu.setBackgroundResource(R.drawable.default_bg);
    }

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_report_details;
    }

    @Override
    public void requestData() {
        HttpRequestParams requestParams = Tools.createHttpRequestParams();
        requestParams.put("PageIndex", 1);
        requestParams.put("PageNumber", 10);

        startFormRequest(ApiUrls.OUTDOOR_SIGN_IN_LIST, requestParams, new BaseHttpRequestTask<OutDoorSignInListResponseBean>() {
            @Override
            public OutDoorSignInListResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, OutDoorSignInListResponseBean.class);
            }

            @Override
            public String verifyResponseResult(OutDoorSignInListResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected void onSuccess(OutDoorSignInListResponseBean result) {
                super.onSuccess(result);
                //这里加正确处理的逻辑就好了

                //只需要显示3行评论
                ArrayList<Comments> dataList = new ArrayList<>();
                dataList.add(new Comments());
                dataList.add(new Comments());
                dataList.add(new Comments());
                mListViewComments.setAdapter(new CommentsAdapter(dataList, getActivity()));

            }
        }, HttpRequestUtils.RequestType.POST);
    }

    void OnClick(View v) {
        switch (v.getId()) {
            case R.id.click_to_input:
                Dialog dialog = Tools.showDialogFromBottom(getActivity(), R.layout.dialog_work_report_comments_input, true);
                final EditText commentsContent = (EditText) dialog.findViewById(R.id.comments_content);
                if (!TextUtils.isEmpty(mCommentsContent)) {
                    commentsContent.setText(mCommentsContent);
                }
                commentsContent.requestFocus();
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        mCommentsContent = commentsContent.getText().toString();
                        mViewClickToInput.setText(mCommentsContent);
                    }
                });
                break;
        }
    }

    private class Comments {

    }

    private class CommentsAdapter extends ABaseAdapter<Comments> {

        public CommentsAdapter(ArrayList<Comments> datas, Activity context) {
            super(datas, context);
        }

        @Override
        protected AbstractItemView<Comments> newItemView() {
            return new CommentsItemView();
        }
    }

    private class CommentsItemView extends ABaseAdapter.AbstractItemView<Comments> {

        @Override
        public int inflateViewId() {
            return R.layout.list_item_work_report_details_comments;
        }

        @Override
        public void bindingData(View convertView, Comments data) {

        }
    }
}
