package com.android.wandong.ui.fragment.work.Tools;

import android.view.View;
import android.widget.ImageView;

import com.android.wandong.R;

/**
 * 作者：伍岳 on 2016/8/6 14:23
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
public class AuditStatusHelper {
    public static void setImageViewByStatus(ImageView imageView,int status){
        //审批状态1：草稿（暂时没用）2：待审批，3：已审批，4：驳回，5：撤销
        imageView.setVisibility(View.GONE);
        switch (status){
            case 1:
                break;
            case 2:
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.icon_pending_review);
                break;
            case 3:
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.icon_passed);
                break;
            case 4:
                imageView.setVisibility(View.VISIBLE);
                imageView.setImageResource(R.drawable.icon_not_passed);
                break;
            case 5:
                break;
        }
    }
}
