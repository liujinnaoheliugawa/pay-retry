package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response;

import java.io.Serializable;

/**
 * @Description: 获取票券返回
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class GetBillsResponse extends BillsResponse implements Serializable {

    public GetBillsResponse(BillsCommonResponse response) {
        super(response);
    }

    public GetBillsResponse(BillsResponse response) {

    }

    public GetBillsResponse(String msg) {

    }
}
