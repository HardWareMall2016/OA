package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/20.
 */
public class SpecialDuesReimburseCostTypeResponseBean extends BaseResponseBean {
    /**
     * errorcode : 200
     * entityInfo : [{"Name":"福利费","Value":"1"},{"Name":"交通补助","Value":"2"},{"Name":"通讯费","Value":"3"},{"Name":"会议费","Value":"4"},{"Name":"招标费","Value":"5"},{"Name":"中标服务费","Value":"6"},{"Name":"客户进修费","Value":"7"},{"Name":"办公费","Value":"8"},{"Name":"租赁费","Value":"9"},{"Name":"修理费","Value":"10"},{"Name":"运输费","Value":"11"},{"Name":"装卸费","Value":"12"},{"Name":"保险费","Value":"13"},{"Name":"包装费","Value":"14"}]
     */

    private int errorcode;
    /**
     * Name : 福利费
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
