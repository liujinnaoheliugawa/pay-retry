package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.dto;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class CheckThirdPartyOrderRequestDto extends BillsCommonRequestDto {

    public CheckThirdPartyOrderRequestDto() {
        super();
    }

    public GetBillsRequestDto convert() {
        return new GetBillsRequestDto();
    }
}
