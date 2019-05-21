package com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart;

import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.common.BillsPartCallableCommon;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.CheckThirdPartyOrderRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.GetBillsRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.BillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.CheckThirdPartyOrderResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.utils.RetryBuilder;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.utils.RetryUtil;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

import static com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.BillsApi.invoke;

/**
 * @Description: 规定次数内，规定时间，执行普通检查第三方订单状态线程
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class CheckThirdPartyOrderNormalCallable extends BillsPartCallableCommon implements Callable<BillsResponse> {

    public CheckThirdPartyOrderNormalCallable(long startTime, long totalMillSeconds, int totalTries, CheckThirdPartyOrderRequest request) {
        super(startTime, totalMillSeconds, totalTries, request);
    }

    public CheckThirdPartyOrderNormalCallable(long startTime, long totalMillSeconds, int totalTries, GetBillsRequest request) {
        super(startTime, totalMillSeconds, totalTries, convert(request));
    }

    @Override
    public BillsResponse call() throws Exception {
        int totalTries = this.getTotalTries();
        long totalMillSeconds = this.getTotalMillSeconds();
        long startTime = this.getStartTime();
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            CheckThirdPartyOrderRequest request = (CheckThirdPartyOrderRequest) this.getRequest();
            for (int i = 0; i < totalTries; i++) {
                CheckThirdPartyOrderResponse response = null;
                response = new CheckThirdPartyOrderResponse(invoke(((CheckThirdPartyOrderRequest) this.getRequest()).getRequestDto()));
                // 逻辑
                if (response == null) {
                    this.setTotalTries(totalTries - 1);
                    this.setTotalMillSeconds(totalMillSeconds - (new Date().getTime() - startTime));
                    this.setStartTime(new Date().getTime());
                    return new RetryUtil(new RetryBuilder("GetBills", this.getTotalMillSeconds(), this.getStartTime(), request, this.getTotalTries())).tries();
                } else if (!response.getResponseCode().equals("0000")) {
                    return new RetryUtil(new RetryBuilder((response.equals("9999") ? "CheckThirdPartyOrder" : "GetBills"), this.getTotalMillSeconds(), this.getStartTime(), request, this.getTotalTries())).tries();
                } else if (response.getResponseCode().equals("0000")) {
                    return response;
                }
            }
        } finally {
            lock.unlock();
        }
        return null;
    }

    private static CheckThirdPartyOrderRequest convert(GetBillsRequest request) {
        return new CheckThirdPartyOrderRequest(request);
    }
}
