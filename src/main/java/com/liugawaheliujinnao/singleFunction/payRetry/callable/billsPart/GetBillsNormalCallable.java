package com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart;

import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.common.BillsPartCallableCommon;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.CheckThirdPartyOrderRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.GetBillsRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.BillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.GetBillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.utils.RetryBuilder;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.utils.RetryUtil;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantLock;

import static com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.BillsApi.invoke;

/**
 * @Description: 规定次数内，规定时间内，执行普通获取票券线程
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class GetBillsNormalCallable extends BillsPartCallableCommon implements Callable<BillsResponse> {

    public GetBillsNormalCallable(long startTime, long totalMilliseconds, int totalTries, GetBillsRequest request) {
        super(startTime, totalMilliseconds, totalTries, request);
    }

    public GetBillsNormalCallable(long startTime, long totalMilliseconds, int totalTries, CheckThirdPartyOrderRequest request) {
        super(startTime, totalMilliseconds, totalTries, convert(request));
    }

    @Override
    public BillsResponse call() throws Exception {
        int totalTries = this.getTotalTries();
        long totalMillSeconds = this.getTotalMillSeconds();
        long startTime = this.getStartTime();
        GetBillsRequest request = (GetBillsRequest) this.getRequest();
        ReentrantLock lock = new ReentrantLock();
        try {
            lock.lock();
            for (int i = 0; i < totalTries; i++) {
                GetBillsResponse response = null;
                response = new GetBillsResponse(invoke(((GetBillsRequest) this.getRequest()).getRequestDto()));
                // 逻辑
                if (null != response && response.getResponseCode().equals("9999")) {
                    this.setTotalTries(totalTries - 1);
                    this.setTotalMillSeconds(totalMillSeconds - (new Date().getTime() - startTime));
                    this.setStartTime(new Date().getTime());
                    return new RetryUtil(new RetryBuilder("CheckThirdPartyOrder", this.getTotalMillSeconds(), this.getStartTime(), request, this.getTotalTries())).tries();
                } else if (response.getResponseCode().equals("0000")) {
                    return response;
                }
            }
        } finally {
            lock.unlock();
        }
        return null;
    }

    private static GetBillsRequest convert(CheckThirdPartyOrderRequest request) {
        return new GetBillsRequest(request);
    }
}
