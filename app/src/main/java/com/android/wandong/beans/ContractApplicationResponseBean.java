package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/7.
 */
public class ContractApplicationResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"Field1":{"Title":"ID","Name":"ContractId","Value":"785d3330-f552-e611-9aff-085700e64e0f"},"Field2":{"Title":"单据号","Name":"ApplyNo","Value":"HTSQ201607000005"},"Field3":{"Title":"执行状态","Name":"Status","Value":2},"Field4":{"Title":"负责人","Name":"OwnerName","Value":"姓名"},"Field5":{"Title":"合同金额","Name":"ContracTotal","Value":9.9999999E7},"Field6":{}},{"Field1":{"Title":"ID","Name":"ContractId","Value":"7ec96ced-4a52-e611-9aff-085700e64e0f"},"Field2":{"Title":"单据号","Name":"ApplyNo","Value":"HTSQ201607000004"},"Field3":{"Title":"执行状态","Name":"Status","Value":2},"Field4":{"Title":"负责人","Name":"OwnerName","Value":"姓名"},"Field5":{"Title":"合同金额","Name":"ContracTotal","Value":9.9999999E7},"Field6":{}}]
     */

    private int errorcode;
    /**
     * Field1 : {"Title":"ID","Name":"ContractId","Value":"785d3330-f552-e611-9aff-085700e64e0f"}
     * Field2 : {"Title":"单据号","Name":"ApplyNo","Value":"HTSQ201607000005"}
     * Field3 : {"Title":"执行状态","Name":"Status","Value":2}
     * Field4 : {"Title":"负责人","Name":"OwnerName","Value":"姓名"}
     * Field5 : {"Title":"合同金额","Name":"ContracTotal","Value":9.9999999E7}
     * Field6 : {}
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
        /**
         * Title : ID
         * Name : ContractId
         * Value : 785d3330-f552-e611-9aff-085700e64e0f
         */

        private Field1Bean Field1;
        /**
         * Title : 单据号
         * Name : ApplyNo
         * Value : HTSQ201607000005
         */

        private Field2Bean Field2;
        /**
         * Title : 执行状态
         * Name : Status
         * Value : 2
         */

        private Field3Bean Field3;
        /**
         * Title : 负责人
         * Name : OwnerName
         * Value : 姓名
         */

        private Field4Bean Field4;
        /**
         * Title : 合同金额
         * Name : ContracTotal
         * Value : 9.9999999E7
         */

        private Field5Bean Field5;
        private Field6Bean Field6;

        public Field1Bean getField1() {
            return Field1;
        }

        public void setField1(Field1Bean Field1) {
            this.Field1 = Field1;
        }

        public Field2Bean getField2() {
            return Field2;
        }

        public void setField2(Field2Bean Field2) {
            this.Field2 = Field2;
        }

        public Field3Bean getField3() {
            return Field3;
        }

        public void setField3(Field3Bean Field3) {
            this.Field3 = Field3;
        }

        public Field4Bean getField4() {
            return Field4;
        }

        public void setField4(Field4Bean Field4) {
            this.Field4 = Field4;
        }

        public Field5Bean getField5() {
            return Field5;
        }

        public void setField5(Field5Bean Field5) {
            this.Field5 = Field5;
        }

        public Field6Bean getField6() {
            return Field6;
        }

        public void setField6(Field6Bean Field6) {
            this.Field6 = Field6;
        }

        public static class Field1Bean {
            private String Title;
            private String Name;
            private String Value;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

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

        public static class Field2Bean {
            private String Title;
            private String Name;
            private String Value;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

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

        public static class Field3Bean {
            private String Title;
            private String Name;
            private int Value;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public String getName() {
                return Name;
            }

            public void setName(String Name) {
                this.Name = Name;
            }

            public int getValue() {
                return Value;
            }

            public void setValue(int Value) {
                this.Value = Value;
            }
        }

        public static class Field4Bean {
            private String Title;
            private String Name;
            private String Value;

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

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

        public static class Field5Bean {
        }

        public static class Field6Bean {
        }
    }
}
