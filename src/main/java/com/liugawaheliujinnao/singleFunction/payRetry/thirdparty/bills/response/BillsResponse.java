package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response;

import java.io.Serializable;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class BillsResponse implements Serializable {

    private String responseCode;

    public BillsResponse() {

    }

    public BillsResponse(BillsCommonResponse commonResponse) {
        // 逻辑
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
