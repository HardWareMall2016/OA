package com.android.wandong.beans;

import com.android.wandong.base.BaseResponseBean;

import java.util.List;

/**
 * Created by ${keke} on 16/8/6.
 */
public class InspectionReceptionResponseBean extends BaseResponseBean {
    /**
     * errorcode : 0
     * entityInfo : [{"ReceptionId":"f7ad845f-ca69-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000034","AccountId":"91cb40a7-ac69-e611-92fc-085700e64e0f","AccountName":"上海第九十七人民医院","VisitName":"测试","VisitNumber":12,"VisitTelephone":"123463","ApplyTime":"/Date(1472022859000)/","Status":2,"OwnerName":"檀庭","ComeTime":"/Date(1472109000000)/","CreatedOn":"/Date(1472022859000)/"},{"ReceptionId":"910266c8-2c68-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000033","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"呃呃呃","VisitNumber":12,"VisitTelephone":"呃呃呃","ApplyTime":"/Date(1471845224000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1477065600000)/","CreatedOn":"/Date(1471845224000)/"},{"ReceptionId":"92f70328-ec66-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000032","AccountId":"5840c2e6-5516-e611-ac23-085700e64e0f","AccountName":"平南中山医院","VisitName":"小米骄傲","VisitNumber":2,"VisitTelephone":"110","ApplyTime":"/Date(1471707516000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468570740000)/","CreatedOn":"/Date(1471707516000)/"},{"ReceptionId":"76a798fa-f665-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000031","AccountId":"ea3fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"宣威先施医院","VisitName":"chxd ","VisitNumber":5,"VisitTelephone":"13712345678","ApplyTime":"/Date(1471602213000)/","Status":2,"OwnerName":"檀庭","ComeTime":"/Date(1471601880000)/","CreatedOn":"/Date(1471602213000)/"},{"ReceptionId":"5ad73c8f-f665-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000030","AccountId":"5e40c2e6-5516-e611-ac23-085700e64e0f","AccountName":"高平武承谋骨伤专科医院","VisitName":"fjvkff ","VisitNumber":5,"VisitTelephone":"13812345678","ApplyTime":"/Date(1471602033000)/","Status":2,"OwnerName":"檀庭","ComeTime":"/Date(1471774560000)/","CreatedOn":"/Date(1471602033000)/"},{"ReceptionId":"fa224111-f665-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000029","AccountId":"5c40c2e6-5516-e611-ac23-085700e64e0f","AccountName":"彭州仁济医院","VisitName":"rjfm ","VisitNumber":5,"VisitTelephone":"13812345678","ApplyTime":"/Date(1471601821000)/","Status":2,"OwnerName":"檀庭","ComeTime":"/Date(1471601580000)/","CreatedOn":"/Date(1471601821000)/"},{"ReceptionId":"b1c3c1f8-d565-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000028","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"你","VisitNumber":12,"VisitTelephone":"123466","ApplyTime":"/Date(1471588036000)/","Status":3,"OwnerName":"姓名","ComeTime":"/Date(1471673940000)/","CreatedOn":"/Date(1471588036000)/"},{"ReceptionId":"cb5bfc1e-0765-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000027","AccountId":"e83fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"花都区青布社区卫生服务中心","VisitName":"这里的","VisitNumber":5,"VisitTelephone":"13812345678","ApplyTime":"/Date(1471499195000)/","Status":3,"OwnerName":"姓名","ComeTime":"/Date(1471498800000)/","CreatedOn":"/Date(1471499195000)/"},{"ReceptionId":"d4e3d1c1-6464-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000026","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"哈哈哈","VisitNumber":5,"VisitTelephone":"138665588","ApplyTime":"/Date(1471429460000)/","Status":3,"OwnerName":"姓名","ComeTime":"/Date(1471442400000)/","CreatedOn":"/Date(1471429460000)/"},{"ReceptionId":"1396d5b5-6464-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000025","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"哈哈哈","VisitNumber":5,"VisitTelephone":"138665588","ApplyTime":"/Date(1471429440000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1471442400000)/","CreatedOn":"/Date(1471429440000)/"},{"ReceptionId":"72763fb9-ba63-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000024","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"哈哈哈","VisitNumber":5,"VisitTelephone":"138665588","ApplyTime":"/Date(1471356432000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1471442400000)/","CreatedOn":"/Date(1471356432000)/"},{"ReceptionId":"82af5d7b-0a61-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000023","AccountId":"5840c2e6-5516-e611-ac23-085700e64e0f","AccountName":"平南中山医院","VisitName":"123","VisitNumber":78,"VisitTelephone":"456","ApplyTime":"/Date(1471060833000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1471060560000)/","CreatedOn":"/Date(1471060833000)/"},{"ReceptionId":"9c9b4156-0a61-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000022","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"234","VisitNumber":222,"VisitTelephone":"555","ApplyTime":"/Date(1471060771000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1471059180000)/","CreatedOn":"/Date(1471060771000)/"},{"ReceptionId":"5112ec76-dd5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000021","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"名称：","VisitNumber":20,"VisitTelephone":"13162520886","ApplyTime":"/Date(1470381792000)/","Status":2,"OwnerName":"檀庭","ComeTime":"/Date(1470554160000)/","CreatedOn":"/Date(1470381792000)/"},{"ReceptionId":"d3e8d256-3a5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000020","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"测试","VisitNumber":61381,"VisitTelephone":"1231643236","ApplyTime":"/Date(1470311730000)/","Status":3,"OwnerName":"檀庭","ComeTime":"/Date(1469620200000)/","CreatedOn":"/Date(1470311730000)/"},{"ReceptionId":"0e2dcc49-275a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000019","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"朋友1","VisitNumber":1,"VisitTelephone":"110","ApplyTime":"/Date(1470303548000)/","Status":2,"OwnerName":"檀庭","ComeTime":"/Date(1470562320000)/","CreatedOn":"/Date(1470303547000)/"},{"ReceptionId":"70b8c3ff-0e5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000018","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"1111","VisitNumber":11111,"VisitTelephone":"2222","ApplyTime":"/Date(1470293116000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1470379260000)/","CreatedOn":"/Date(1470293115000)/"},{"ReceptionId":"46593ae3-0e5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000017","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"111","VisitNumber":11111,"VisitTelephone":"222222","ApplyTime":"/Date(1470293068000)/","Status":3,"OwnerName":"姓名","ComeTime":"/Date(1470292740000)/","CreatedOn":"/Date(1470293067000)/"},{"ReceptionId":"b42ce665-0b5a-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000016","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"111","VisitNumber":333,"VisitTelephone":"22222","ApplyTime":"/Date(1470291572000)/","Status":4,"OwnerName":"姓名","ComeTime":"/Date(1470291060000)/","CreatedOn":"/Date(1470291572000)/"},{"ReceptionId":"3503cc7c-4c59-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000015","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"我","VisitNumber":1,"VisitTelephone":"12","ApplyTime":"/Date(1470209573000)/","Status":3,"OwnerName":"姓名","ComeTime":"/Date(1470209280000)/","CreatedOn":"/Date(1470209573000)/"},{"ReceptionId":"7ee02064-4c59-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000014","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"我","VisitNumber":12,"VisitTelephone":"136","ApplyTime":"/Date(1470209532000)/","Status":4,"OwnerName":"姓名","ComeTime":"/Date(1470382080000)/","CreatedOn":"/Date(1470209532000)/"},{"ReceptionId":"5de4afe0-4b59-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000013","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"wew","VisitNumber":2,"VisitTelephone":"12312312312","ApplyTime":"/Date(1470209312000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1470209040000)/","CreatedOn":"/Date(1470209311000)/"},{"ReceptionId":"07ccaa3f-6458-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000012","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"这是有图片的","VisitNumber":99,"VisitTelephone":"123465789","ApplyTime":"/Date(1470109828000)/","Status":3,"OwnerName":"姓名","ComeTime":"/Date(1470109560000)/","CreatedOn":"/Date(1470109828000)/"},{"ReceptionId":"926cd409-6458-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000011","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"我","VisitNumber":2,"VisitTelephone":"123456489","ApplyTime":"/Date(1470109737000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1469936640000)/","CreatedOn":"/Date(1470109737000)/"},{"ReceptionId":"4e1590ed-6358-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000010","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"这","VisitNumber":2,"VisitTelephone":"1353863618668","ApplyTime":"/Date(1470109690000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1470109440000)/","CreatedOn":"/Date(1470109690000)/"},{"ReceptionId":"2a818ab0-5b58-e611-92fc-085700e64e0f","ApplyNo":"KCSQ201608000009","AccountId":"5640c2e6-5516-e611-ac23-085700e64e0f","AccountName":"襄城区余家湖社区卫生服务中心","VisitName":"测试结果显示","VisitNumber":2,"VisitTelephone":"132685523648","ApplyTime":"/Date(1470106151000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1470105840000)/","CreatedOn":"/Date(1470106151000)/"},{"ReceptionId":"262ae22e-bd4d-e611-86c6-085700e64e0f","ApplyNo":"KCSQ201607000012","AccountId":"d43fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"博爱医院保山","VisitName":"ertyuyty","VisitNumber":5,"VisitTelephone":"234567654","ApplyTime":"/Date(1468938562000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468938180000)/","CreatedOn":"/Date(1468938562000)/"},{"ReceptionId":"2b2ae22e-bd4d-e611-86c6-085700e64e0f","ApplyNo":"KCSQ201607000015","AccountId":"ce3fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"北京丰台医星中西医结合医院","VisitName":"ertyuyty","VisitNumber":5,"VisitTelephone":"234567654","ApplyTime":"/Date(1468938562000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468938180000)/","CreatedOn":"/Date(1468938562000)/"},{"ReceptionId":"f527d71b-bd4d-e611-86c6-085700e64e0f","ApplyNo":"KCSQ201607000009","AccountId":"e23fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"保山仁济医院","VisitName":"ertyuyty","VisitNumber":5,"VisitTelephone":"234567654","ApplyTime":"/Date(1468938530000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468938180000)/","CreatedOn":"/Date(1468938530000)/"},{"ReceptionId":"05e50fff-bc4d-e611-86c6-085700e64e0f","ApplyNo":"KCSQ201607000008","AccountId":"d43fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"博爱医院保山","VisitName":"ertyuyty","VisitNumber":5,"VisitTelephone":"234567654","ApplyTime":"/Date(1468938482000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468938180000)/","CreatedOn":"/Date(1468938481000)/"},{"ReceptionId":"99bb2fec-bc4d-e611-86c6-085700e64e0f","ApplyNo":"KCSQ201607000007","AccountId":"d43fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"博爱医院保山","VisitName":"ertyuyty","VisitNumber":5,"VisitTelephone":"234567654","ApplyTime":"/Date(1468938450000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468938180000)/","CreatedOn":"/Date(1468938450000)/"},{"ReceptionId":"166682c2-bb4d-e611-86c6-085700e64e0f","ApplyNo":"KCSQ201607000006","AccountId":"d43fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"博爱医院保山","VisitName":"dasdsad","VisitNumber":2,"VisitTelephone":"13324234234","ApplyTime":"/Date(1468937960000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468937460000)/","CreatedOn":"/Date(1468937960000)/"},{"ReceptionId":"156682c2-bb4d-e611-86c6-085700e64e0f","ApplyNo":"KCSQ201607000005","AccountId":"d43fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"博爱医院保山","VisitName":"dasdsad","VisitNumber":234,"VisitTelephone":"13324234234","ApplyTime":"/Date(1468937950000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468937460000)/","CreatedOn":"/Date(1468937950000)/"},{"ReceptionId":"63dc40ad-bb4d-e611-86c6-085700e64e0f","ApplyNo":"KCSQ201607000004","AccountId":"d43fc2e6-5516-e611-ac23-085700e64e0f","AccountName":"博爱医院保山","VisitName":"dasdsad","VisitNumber":234,"VisitTelephone":"13324234234","ApplyTime":"/Date(1468937915000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1468937460000)/","CreatedOn":"/Date(1468937915000)/"},{"ReceptionId":"afcfe8b6-7742-e611-9105-085700e64e0f","ApplyNo":"KCSQ201607000003","AccountId":"1040c2e6-5516-e611-ac23-085700e64e0f","AccountName":"巴州区红十字医院（巴中红十字医院）","VisitName":"陈晗","VisitNumber":1,"VisitTelephone":"18652079898","ApplyTime":"/Date(1467699262000)/","Status":3,"OwnerName":"姓名","ComeTime":"/Date(1467345600000)/","CreatedOn":"/Date(1467699262000)/"},{"ReceptionId":"1d87f78c-7642-e611-9105-085700e64e0f","ApplyNo":"KCSQ201607000001","AccountId":"1040c2e6-5516-e611-ac23-085700e64e0f","AccountName":"巴州区红十字医院（巴中红十字医院）","VisitName":"陈晗","VisitNumber":1,"VisitTelephone":"18652079898","ApplyTime":"/Date(1467648000000)/","Status":2,"OwnerName":"姓名","ComeTime":"/Date(1467345600000)/","CreatedOn":"/Date(1467698763000)/"}]
     */

    private int errorcode;
    /**
     * ReceptionId : f7ad845f-ca69-e611-92fc-085700e64e0f
     * ApplyNo : KCSQ201608000034
     * AccountId : 91cb40a7-ac69-e611-92fc-085700e64e0f
     * AccountName : 上海第九十七人民医院
     * VisitName : 测试
     * VisitNumber : 12
     * VisitTelephone : 123463
     * ApplyTime : /Date(1472022859000)/
     * Status : 2
     * OwnerName : 檀庭
     * ComeTime : /Date(1472109000000)/
     * CreatedOn : /Date(1472022859000)/
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
        private String ReceptionId;
        private String ApplyNo;
        private String AccountId;
        private String AccountName;
        private String VisitName;
        private int VisitNumber;
        private String VisitTelephone;
        private String ApplyTime;
        private int Status;
        private String OwnerName;
        private String ComeTime;
        private String CreatedOn;

        public String getReceptionId() {
            return ReceptionId;
        }

        public void setReceptionId(String ReceptionId) {
            this.ReceptionId = ReceptionId;
        }

        public String getApplyNo() {
            return ApplyNo;
        }

        public void setApplyNo(String ApplyNo) {
            this.ApplyNo = ApplyNo;
        }

        public String getAccountId() {
            return AccountId;
        }

        public void setAccountId(String AccountId) {
            this.AccountId = AccountId;
        }

        public String getAccountName() {
            return AccountName;
        }

        public void setAccountName(String AccountName) {
            this.AccountName = AccountName;
        }

        public String getVisitName() {
            return VisitName;
        }

        public void setVisitName(String VisitName) {
            this.VisitName = VisitName;
        }

        public int getVisitNumber() {
            return VisitNumber;
        }

        public void setVisitNumber(int VisitNumber) {
            this.VisitNumber = VisitNumber;
        }

        public String getVisitTelephone() {
            return VisitTelephone;
        }

        public void setVisitTelephone(String VisitTelephone) {
            this.VisitTelephone = VisitTelephone;
        }

        public String getApplyTime() {
            return ApplyTime;
        }

        public void setApplyTime(String ApplyTime) {
            this.ApplyTime = ApplyTime;
        }

        public int getStatus() {
            return Status;
        }

        public void setStatus(int Status) {
            this.Status = Status;
        }

        public String getOwnerName() {
            return OwnerName;
        }

        public void setOwnerName(String OwnerName) {
            this.OwnerName = OwnerName;
        }

        public String getComeTime() {
            return ComeTime;
        }

        public void setComeTime(String ComeTime) {
            this.ComeTime = ComeTime;
        }

        public String getCreatedOn() {
            return CreatedOn;
        }

        public void setCreatedOn(String CreatedOn) {
            this.CreatedOn = CreatedOn;
        }
    }
}
