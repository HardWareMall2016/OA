package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/19.
 */
public class CostTypeListResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : [{"Name":"广告宣传费","Value":"1"},{"Name":"国内展览费","Value":"2"},{"Name":"会议费","Value":"3"},{"Name":"彩页","Value":"4"}]
     */

    private int errorcode;
    /**
     * Name : 广告宣传费
     * Value : 1
     */

    private List<EntityInfoBean> entityInfo;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public List<EntityInfoBean> getEntityInfo() {
        return entityInfo;
    }

    public void setEntityInfo(List<EntityInfoBean> entityInfo) {
        this.entityInfo = entityInfo;
    }

    public static class EntityInfoBean {
        private String Name;
        private String Value;

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getValue() {
            return Value;
        }

        public void setValue(String Value) {
            this.Value = Value;
        }
    }
}
