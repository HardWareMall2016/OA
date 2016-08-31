package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

/**
 * 作者：蒲柯柯 on 2016/8/31 15:03
 * 邮箱：983198505@qq.com
 * 介绍:
 */
public class ReplyDetailResponseBean extends BaseResponseBean{
    /**
     * errorcode : 200
     * entityInfo : null
     */

    private int errorcode;
    private Object entityInfo;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public Object getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(Object entityInfo) {
        this.entityInfo = entityInfo;
    }
}
