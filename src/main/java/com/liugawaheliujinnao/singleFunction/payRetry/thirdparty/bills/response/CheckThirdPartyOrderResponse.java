package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response;

import java.io.Serializable;

/**
 * @Description: 检查订单状态返回
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class CheckThirdPartyOrderResponse extends BillsResponse implements Serializable {

    public CheckThirdPartyOrderResponse(BillsCommonResponse response) {
        super(response);
    }

    public CheckThirdPartyOrderResponse(BillsResponse response) {

    }

    public CheckThirdPartyOrderResponse(String msg) {

    }
}
