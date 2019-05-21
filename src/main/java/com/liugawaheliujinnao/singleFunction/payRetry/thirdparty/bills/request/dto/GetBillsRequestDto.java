package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.dto;

/**
 * @Description:
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class GetBillsRequestDto extends BillsCommonRequestDto {

    public GetBillsRequestDto() {

    }

    public CheckThirdPartyOrderRequestDto convert() {
        return new CheckThirdPartyOrderRequestDto();
    }
}
