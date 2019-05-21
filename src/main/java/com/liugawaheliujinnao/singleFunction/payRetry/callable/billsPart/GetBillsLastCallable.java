package com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart;

import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.common.BillsPartCallableCommon;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.BillsCommonRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.CheckThirdPartyOrderRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.GetBillsRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.BillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.GetBillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.email.EmailApi;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

import static com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.BillsApi.invoke;

/**
 * @Description: 规定次数最后一次，执行最后一次获取票券线程
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class GetBillsLastCallable extends BillsPartCallableCommon implements Callable<BillsResponse> {

    public GetBillsLastCallable(CheckThirdPartyOrderRequest request) {
        super(convert(request));
    }

    public GetBillsLastCallable(GetBillsRequest request) {
        super(request);
    }

    @Override
    public BillsResponse call() throws Exception {
        GetBillsResponse response = null;
        GetBillsRequest request = (GetBillsRequest) this.getRequest();
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            response = new GetBillsResponse(invoke(((GetBillsRequest)this.getRequest()).getRequestDto()));
            if (response == null) {
                // 最后一次调用失败，发送错误邮件
                EmailApi.sendBillsErrorMail(new BillsCommonRequest(), "获取票券失败");
            }
            return response;
        } finally {
            lock.unlock();
        }
    }

    private static GetBillsRequest convert(CheckThirdPartyOrderRequest request) {
        return new GetBillsRequest(request);
    }
}
