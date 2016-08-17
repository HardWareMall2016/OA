package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/17.
 */
public class ContractProductLineListResponseBean extends BaseResponseBean{
    /**
     * errorcode : 0
     * entityInfo : [{"Id":"64bc3705-b218-e611-ac23-085700e64e0f","Name":"MRI磁共振成像系统","Specifications":"永磁"},{"Id":"9b6b25f8-b218-e611-ac23-085700e64e0f","Name":"MRI磁共振成像系统","Specifications":"超导"},{"Id":"6363250e-b318-e611-ac23-085700e64e0f","Name":"DSA血管造影介入治疗系统","Specifications":"平板型"},{"Id":"2fe8801a-b318-e611-ac23-085700e64e0f","Name":"DSA血管造影介入治疗系统","Specifications":"影增型"},{"Id":"b1fcdb2a-b318-e611-ac23-085700e64e0f","Name":"数字乳腺机","Specifications":"非晶硒平板"},{"Id":"542fb734-b318-e611-ac23-085700e64e0f","Name":"数字乳腺机","Specifications":"非晶硅平板"},{"Id":"52ad6e3e-b318-e611-ac23-085700e64e0f","Name":"平板胃肠","Specifications":"动态平板胃肠"},{"Id":"415fb748-b318-e611-ac23-085700e64e0f","Name":"平板胃肠","Specifications":"静态平板胃肠"},{"Id":"02e57177-b518-e611-ac23-085700e64e0f","Name":"影增数字胃肠系统","Specifications":"80kW"},{"Id":"7a1bd285-b518-e611-ac23-085700e64e0f","Name":"影增数字胃肠系统","Specifications":"50kW"},{"Id":"0a466faa-b818-e611-ac23-085700e64e0f","Name":"DR数字摄影系统","Specifications":"平板型"},{"Id":"ee51d7c6-b818-e611-ac23-085700e64e0f","Name":"高频电视胃肠系统","Specifications":"床上管"},{"Id":"88e35ddc-b818-e611-ac23-085700e64e0f","Name":"高频电视胃肠系统","Specifications":"床下管"},{"Id":"e1adecf2-b818-e611-ac23-085700e64e0f","Name":"工频电视胃肠系统","Specifications":"床下管"},{"Id":"61c34210-b918-e611-ac23-085700e64e0f","Name":"高频专用摄影系统","Specifications":"摄影系统"},{"Id":"af4a6419-b918-e611-ac23-085700e64e0f","Name":"常规产品","Specifications":"工频500mA"},{"Id":"1f82b623-b918-e611-ac23-085700e64e0f","Name":"常规产品","Specifications":"工频200mA"},{"Id":"5a32562d-b918-e611-ac23-085700e64e0f","Name":"常规产品","Specifications":"隔室透视机"},{"Id":"089c9037-b918-e611-ac23-085700e64e0f","Name":"常规产品","Specifications":"立式摄影架"}]
     */

    private int errorcode;
    /**
     * Id : 64bc3705-b218-e611-ac23-085700e64e0f
     * Name : MRI磁共振成像系统
     * Specifications : 永磁
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
        private String Specifications;

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

        public String getSpecifications() {
            return Specifications;
        }

        public void setSpecifications(String Specifications) {
            this.Specifications = Specifications;
        }
    }
}
