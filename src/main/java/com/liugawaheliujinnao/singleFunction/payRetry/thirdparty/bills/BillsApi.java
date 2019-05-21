package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills;

import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.dto.BillsCommonRequestDto;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.dto.CheckThirdPartyOrderRequestDto;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.dto.GetBillsRequestDto;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.BillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.CheckThirdPartyOrderResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.GetBillsResponse;

/**
 * @Description: 票券 第三方 API
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class BillsApi {

    public static BillsResponse invoke(BillsCommonRequestDto requestDto) throws Exception {
        String txMsg;
        txMsg = joinRequestXml(requestDto);
        txMsg = billsStaticProcess(requestDto, txMsg);
        return convertResponse(requestDto, txMsg);
    }

    // 假设第三方提供的 API 调用方式相同
    public static String billsStaticProcess(BillsCommonRequestDto requestDto, String txMsg) throws Exception {
        // 逻辑
        return txMsg;
    }

    // 对象转 xml
    public static String joinRequestXml(BillsCommonRequestDto requestDto) throws Exception {
        String result = "";
        // 逻辑
        return result;
    }

    // 字符串转对象
    private static BillsResponse convertResponse(BillsCommonRequestDto requestDto, String msg) {
        if (requestDto instanceof GetBillsRequestDto) {
            return convertGetBillsResponse(msg);
        } else if (requestDto instanceof CheckThirdPartyOrderRequestDto) {
            return convertCheckThirdPartyOrderResponse(msg);
        }
        return null;
    }

    private static GetBillsResponse convertGetBillsResponse(String msg) {
        // 逻辑
        return new GetBillsResponse(msg);
    }

    private static CheckThirdPartyOrderResponse convertCheckThirdPartyOrderResponse(String msg) {
        // 逻辑
        return new CheckThirdPartyOrderResponse(msg);
    }
}
