package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response;

/**
 * @Description: 票券返回公共属性类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class BillsCommonResponse {

    private String responseCode;

    private String billsGuid;

    private String billsNo;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getBillsGuid() {
        return billsGuid;
    }

    public void setBillsGuid(String billsGuid) {
        this.billsGuid = billsGuid;
    }

    public String getBillsNo() {
        return billsNo;
    }

    public void setBillsNo(String billsNo) {
        this.billsNo = billsNo;
    }
}
