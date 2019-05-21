package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.utils;

import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.CheckThirdPartyOrderLastCallable;
import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.CheckThirdPartyOrderNormalCallable;
import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.GetBillsLastCallable;
import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.GetBillsNormalCallable;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.BillsCommonRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.CheckThirdPartyOrderRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.GetBillsRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.BillsResponse;

import java.util.concurrent.Callable;

/**
 * @Description: 重试工构造类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class RetryBuilder {

    private String name;

    private long nowTime;

    private long reserveTime;

    private Callable<BillsResponse> callable;

    public RetryBuilder(String name, long totalMillSeconds, long startTime, BillsCommonRequest request, int totalTries) {
        String tryName = name;
        long reserveTime = totalMillSeconds - (nowTime - startTime);
        if (totalTries == 1) {
            if (tryName.equalsIgnoreCase("GetBills") && request instanceof GetBillsRequest) {
                callable = new GetBillsLastCallable((GetBillsRequest) request);
            } else if (tryName.equals("GetBills") && request instanceof CheckThirdPartyOrderRequest) {
                callable = new GetBillsLastCallable((CheckThirdPartyOrderRequest) request);
            } else if (tryName.equals("CheckThirdPartyOrder") && request instanceof CheckThirdPartyOrderRequest) {
                callable = new CheckThirdPartyOrderLastCallable((CheckThirdPartyOrderRequest) request);
            } else if (tryName.equals("CheckThirdPartyOrder") && request instanceof GetBillsRequest) {
                callable = new CheckThirdPartyOrderLastCallable((GetBillsRequest) request);
            }
            tryName += "Last";
        } else {
            if (tryName.equalsIgnoreCase("GetBills") && request instanceof GetBillsRequest) {
                callable = new GetBillsNormalCallable(nowTime, reserveTime, totalTries, (GetBillsRequest) request);
            } else if (tryName.equals("GetBills") && request instanceof CheckThirdPartyOrderRequest) {
                callable = new GetBillsNormalCallable(nowTime, reserveTime, totalTries, (CheckThirdPartyOrderRequest) request);
            } else if (tryName.equals("CheckThirdPartyOrder") && request instanceof CheckThirdPartyOrderRequest) {
                callable = new CheckThirdPartyOrderNormalCallable(nowTime, reserveTime, totalTries, (CheckThirdPartyOrderRequest) request);
            } else if (tryName.equals("CheckThirdPartyOrder") && request instanceof GetBillsRequest) {
                callable = new CheckThirdPartyOrderNormalCallable(nowTime, reserveTime, totalTries, (GetBillsRequest) request);
            }
            tryName += "Normal";
        }
        this.name = tryName;
        this.reserveTime = reserveTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNowTime() {
        return nowTime;
    }

    public void setNowTime(long nowTime) {
        this.nowTime = nowTime;
    }

    public long getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(long reserveTime) {
        this.reserveTime = reserveTime;
    }

    public Callable<BillsResponse> getCallable() {
        return callable;
    }

    public void setCallable(Callable<BillsResponse> callable) {
        this.callable = callable;
    }
}
