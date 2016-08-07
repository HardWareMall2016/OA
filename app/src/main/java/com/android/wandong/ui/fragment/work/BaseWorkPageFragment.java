package com.android.wandong.ui.fragment.work;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.wandong.R;
import com.android.wandong.base.BaseResponseBean;
import com.android.wandong.network.ApiUrls;
import com.android.wandong.utils.Tools;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhan.framework.network.HttpRequestParams;
import com.zhan.framework.network.HttpRequestUtils;
import com.zhan.framework.support.inject.ViewInject;
import com.zhan.framework.ui.fragment.APullToRefreshListFragment;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者：伍岳 on 2016/7/22 15:37
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
public abstract class BaseWorkPageFragment<ItemData, ResponseBean extends BaseResponseBean> extends APullToRefreshListFragment<ItemData> {
    private final static int PAGE_SIZE=10;

    @ViewInject(id = R.id.search_content)
    protected View mViewContentSearch;

    @Override
    protected int inflateContentView() {
        return R.layout.frag_work_comm_layout_with_search;
    }

    @Override
    protected void configRefresh(RefreshConfig config) {
        config.minResultSize=PAGE_SIZE;
    }

    protected abstract void populateRequestParams(RefreshMode mode,HttpRequestParams requestParams);

    protected abstract String getRequestApiUrl();

    @Override
    protected void requestData(RefreshMode mode) {
        HttpRequestParams requestParams= Tools.createHttpRequestParams();
        populateRequestParams(mode,requestParams);

        startFormRequest(getRequestApiUrl(), requestParams, new PagingTask<ResponseBean>(mode) {
            @Override
            public ResponseBean parseResponseToResult(String content) {
                return Tools.parseJson(content, getResponseBeanClazzInfo());
            }

            @Override
            public String verifyResponseResult(ResponseBean result) {
                return Tools.verifyResponseResult(result);
            }

            @Override
            protected List<ItemData> parseResult(ResponseBean baseResponseBean) {
                List<ItemData> items=new ArrayList<>();
                if(baseResponseBean!=null){
                    parseResponseBeanToItemDataList(baseResponseBean, items);
                }
                return items;
            }
        }, HttpRequestUtils.RequestType.POST);
    }

    protected abstract void parseResponseBeanToItemDataList(ResponseBean baseResponseBean, List<ItemData> items);


    private Class<ResponseBean> getResponseBeanClazzInfo() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        return (Class) params[1];
    }
}
