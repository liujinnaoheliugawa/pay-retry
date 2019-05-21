package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request;

import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.dto.CheckThirdPartyOrderRequestDto;

/**
 * @Description: 第三方票券接口检查订单状态请求类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class CheckThirdPartyOrderRequest extends BillsCommonRequest {

    private CheckThirdPartyOrderRequestDto requestDto;

    public CheckThirdPartyOrderRequest(GetBillsRequest request) {
        // 逻辑
    }

    public CheckThirdPartyOrderRequestDto getRequestDto() {
        return requestDto;
    }

    public void setRequestDto(CheckThirdPartyOrderRequestDto requestDto) {
        this.requestDto = requestDto;
    }
}
