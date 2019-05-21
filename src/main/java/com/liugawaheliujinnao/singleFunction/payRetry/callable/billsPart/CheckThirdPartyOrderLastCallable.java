package com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart;

import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.common.BillsPartCallableCommon;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.BillsCommonRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.CheckThirdPartyOrderRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.GetBillsRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.BillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.CheckThirdPartyOrderResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.email.EmailApi;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

import static com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.BillsApi.invoke;

/**
 * @Description: 规定次数最后一次，执行最后一次检查第三方订单状态线程
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class CheckThirdPartyOrderLastCallable extends BillsPartCallableCommon implements Callable<BillsResponse> {

    public CheckThirdPartyOrderLastCallable(CheckThirdPartyOrderRequest request) {
        super(request);
    }

    public CheckThirdPartyOrderLastCallable(GetBillsRequest request) {
        super(convert(request));
    }

    @Override
    public BillsResponse call() throws Exception {
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            CheckThirdPartyOrderResponse response = new CheckThirdPartyOrderResponse(invoke(((CheckThirdPartyOrderRequest) this.getRequest()).getRequestDto()));
            // 逻辑
            if (response == null) {
                // 最后一次调用失败，不再做重试，发送邮件
                EmailApi.sendBillsErrorMail(new BillsCommonRequest(), "获取票券失败");
            }
            return response;
        } finally {
            lock.unlock();
        }
    }

    private static CheckThirdPartyOrderRequest convert(GetBillsRequest request) {
        return new CheckThirdPartyOrderRequest(request);
    }
}
