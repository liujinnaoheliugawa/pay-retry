package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request;

import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.dto.GetBillsRequestDto;

/**
 * @Description: 第三方票券接口获取票券请求类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class GetBillsRequest extends BillsCommonRequest {

    private GetBillsRequestDto requestDto;

    public GetBillsRequestDto getRequestDto() {
        return requestDto;
    }

    public void setRequestDto(GetBillsRequestDto requestDto) {
        this.requestDto = requestDto;
    }

    public GetBillsRequest(CheckThirdPartyOrderRequest request) {
        // 逻辑
    }

    public GetBillsRequest(GetBillsRequestDto requestDto) {
        this.requestDto = requestDto;
    }
}
