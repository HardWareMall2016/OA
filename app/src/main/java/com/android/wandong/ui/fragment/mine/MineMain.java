package com.android.wandong.ui.fragment.mine;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.android.wandong.R;
import com.android.wandong.base.UserInfo;
import com.android.wandong.utils.Tools;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.ui.widget.CircleImageView;

/**
 * 作者：伍岳 on 2016/7/9 21:46
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
public class MineMain extends ABaseFragment {
    @ViewInject(id = R.id.headPortrait)
    CircleImageView mViewHeadPortrait;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_mine_main;
    }

    @Override
    protected void layoutInit(LayoutInflater inflater, Bundle savedInstanceSate) {
        super.layoutInit(inflater, savedInstanceSate);
        ImageLoader.getInstance().displayImage(UserInfo.getCurrentUser().getHeadPortrait(), mViewHeadPortrait, Tools.buildDisplayImageOptionsForAvatar());
    }
}
