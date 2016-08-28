package com.android.wandong.beans;

import java.io.Serializable;

/**
 * Created by ${keke} on 16/8/28.
 */
public class InspectionReceptionApplicationContent implements Serializable {
    public String getReceptionId() {
        return ReceptionId;
    }

    public void setReceptionId(String receptionId) {
        ReceptionId = receptionId;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    private String ReceptionId;
    private String CreateTime ;
}
