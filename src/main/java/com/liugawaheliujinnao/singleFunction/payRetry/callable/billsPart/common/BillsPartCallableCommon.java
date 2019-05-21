package com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.common;

import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.BillsCommonRequest;

/**
 * @Description: 存放规定次数，规定时间等所有线程可见的变量，抽象为父类参数在工具类中传递
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class BillsPartCallableCommon {

    private volatile long startTime;

    private volatile long totalMillSeconds;

    private volatile int totalTries;

    private BillsCommonRequest request;

    public BillsPartCallableCommon(BillsCommonRequest request) {
        this.request = request;
    }

    public BillsPartCallableCommon(long startTime, long totalMillSeconds, int totalTries, BillsCommonRequest request) {
        this.startTime = startTime;
        this.totalMillSeconds = totalMillSeconds;
        this.totalTries = totalTries;
        this.request = request;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getTotalMillSeconds() {
        return totalMillSeconds;
    }

    public void setTotalMillSeconds(long totalMillSeconds) {
        this.totalMillSeconds = totalMillSeconds;
    }

    public int getTotalTries() {
        return totalTries;
    }

    public void setTotalTries(int totalTries) {
        this.totalTries = totalTries;
    }

    public BillsCommonRequest getRequest() {
        return request;
    }

    public void setRequest(BillsCommonRequest request) {
        this.request = request;
    }
}
