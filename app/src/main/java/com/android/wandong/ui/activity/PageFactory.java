package com.android.wandong.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.wandong.R;
import com.android.wandong.ui.fragment.CrmMain.CrmMain;
import com.android.wandong.ui.fragment.companyLetter.CompanyLetterMain;
import com.android.wandong.ui.fragment.mine.MineMain;
import com.android.wandong.ui.fragment.work.WorkMain;
import com.android.wandong.utils.Tools;
import com.zhan.framework.common.context.GlobalContext;
import com.zhan.framework.ui.fragment.ABaseFragment;
import com.zhan.framework.utils.PixelUtils;

import java.util.ArrayList;
import java.util.List;

public class PageFactory {
    private Activity mActivity;
    public PageFactory(Activity activity) {
        mActivity = activity;
    }

    public List<Page> createPages() {
        return generateManagementPages();
    }

    private List<Page> generateManagementPages() {
        List<Page> pageList = new ArrayList<>();
        //企信
        CompanyLetterMain goodsMain = new CompanyLetterMain();
        pageList.add(generatePage(goodsMain, R.string.module_company_letter, R.drawable.tab_home_unselect, R.drawable.tab_home_selected));
        //工作
        WorkMain informationMain = new WorkMain();
        pageList.add(generatePage(informationMain, R.string.module_work, R.drawable.tab_goods_unselect, R.drawable.tab_goods_selected));
        //CRM
        CrmMain cartMain = new CrmMain();
        pageList.add(generatePage(cartMain, R.string.module_crm, R.drawable.tab_cart_unselect, R.drawable.tab_cart_selected));
        //我
        MineMain mineMain = new MineMain();
        pageList.add(generatePage(mineMain, R.string.module_mine, R.drawable.tab_me_unselect, R.drawable.tab_me_selected));
        return pageList;
    }

    private Page generatePage(ABaseFragment fragment, int titleRes, int normalDrawableId, int selectedDrawableId) {
        Page page = new Page();
        page.TAG = fragment.getClass().getSimpleName();
        page.bottomTitle = generateBottomTextView(mActivity, GlobalContext.getInstance().getString(titleRes));
        page.bottomTitle.setTag(page);
        page.pageFragment = fragment;
        page.normalDrawableId = normalDrawableId;
        page.selectedDrawableId = selectedDrawableId;
        return page;
    }

    private TextView generateBottomTextView(Context context, String bottomTitle) {
        TextView bottomTextView = new TextView(context);
        bottomTextView.setText(bottomTitle);
        bottomTextView.setCompoundDrawablePadding(PixelUtils.dp2px(2));
        bottomTextView.setTextSize(16);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.weight = 1.0f;
        params.gravity = Gravity.CENTER;
        bottomTextView.setLayoutParams(params);
        bottomTextView.setGravity(Gravity.CENTER);
        return bottomTextView;
    }

    /***
     * 进入
     * @return
     */
    public boolean showOrLauncherLoginPage(String pageTag){
        //return true;
        return Tools.checkIsLogin(mActivity);
    }
}
