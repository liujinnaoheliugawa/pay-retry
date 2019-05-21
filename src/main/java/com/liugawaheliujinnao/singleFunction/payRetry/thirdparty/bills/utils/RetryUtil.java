package com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.utils;

import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.BillsResponse;

import java.util.concurrent.*;

/**
 * @Description: 重试工具类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class RetryUtil {

    private String name;

    private Callable<BillsResponse> callable;

    private long reserveTime;

    public RetryUtil(RetryBuilder builder) {
        this.callable = builder.getCallable();
        this.reserveTime = builder.getReserveTime();
        this.name = builder.getName();
    }

    public BillsResponse tries() throws TimeoutException, ExecutionException, InterruptedException {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        ScheduledFuture<BillsResponse> task = es.schedule(callable, 0, TimeUnit.SECONDS.MICROSECONDS);
        es.shutdown();
        BillsResponse response = task.get(reserveTime, TimeUnit.MILLISECONDS);
        return response;
    }
}
