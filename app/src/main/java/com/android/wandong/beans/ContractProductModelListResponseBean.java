package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/17.
 */
public class ContractProductModelListResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"Id":"24e647a4-da18-e611-ac23-085700e64e0f","Name":"LS-3型","Price":0}]
     */

    private int errorcode;
    /**
     * Id : 24e647a4-da18-e611-ac23-085700e64e0f
     * Name : LS-3型
     * Price : 0
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
        private String Id;
        private String Name;
        private int Price;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getPrice() {
            return Price;
        }

        public void setPrice(int Price) {
            this.Price = Price;
        }
    }
}
