package com.liugawaheliujinnao.singleFunction.payRetry.callable;

import com.liugawaheliujinnao.singleFunction.payRetry.callable.billsPart.GetBillsNormalCallable;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ProductPojo;
import com.liugawaheliujinnao.singleFunction.payRetry.service.ProductService;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.GetBillsRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.request.dto.GetBillsRequestDto;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.BillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.bills.response.GetBillsResponse;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.email.EmailApi;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.points.PointsApi;
import com.liugawaheliujinnao.singleFunction.payRetry.thirdparty.points.request.PointsRequest;

import java.util.concurrent.*;

/**
 * @Description: 票券线程
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class BillsMainCallable implements Callable<BillsResponse> {

    private ProductService productService;

    private long pdId;

    private long startTime;

    private long totalMillSeconds;

    private int totalTries;

    public BillsMainCallable(ProductService productService, long pdId, long startTime, long totalMillSeconds, int totalTries) {
        this.productService = productService;
        this.pdId = pdId;
        this.startTime = startTime;
        this.totalMillSeconds = totalMillSeconds;
        this.totalTries = totalTries;
    }

    @Override
    public BillsResponse call() {
        ProductPojo productPojo = productService.selectById(pdId);
        GetBillsResponse response;
        GetBillsRequestDto requestDto = new GetBillsRequestDto();
        GetBillsRequest getBillsRequest = new GetBillsRequest(requestDto);
        GetBillsNormalCallable getBillsNormalCallable = new GetBillsNormalCallable(startTime, totalMillSeconds, totalTries, getBillsRequest);
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        ScheduledFuture<BillsResponse> task = es.schedule(getBillsNormalCallable, 0, TimeUnit.MILLISECONDS);
        es.shutdown();

        // 设置规定时间
        try {
            BillsResponse billsResponse = task.get(10000, TimeUnit.MILLISECONDS);
            if (billsResponse != null) {
                // 逻辑
                GetBillsResponse getBillsResponse = new GetBillsResponse(billsResponse);
                // 获取成功，进行扣点
                if (!PointsApi.minus(pdId, 1)) { // 如果扣点失败
                    // 逻辑
                    // 发送错误邮件
                    EmailApi.sendPointsErrorMail(new PointsRequest(), "扣点失败");
                }
            }
            return billsResponse;
        } catch (TimeoutException e) {
            System.out.println("超时");
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
