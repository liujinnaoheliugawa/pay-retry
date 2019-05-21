package com.liugawaheliujinnao.singleFunction.payRetry.controller;

import com.liugawaheliujinnao.singleFunction.payRetry.callable.BillsMainCallable;
import com.liugawaheliujinnao.singleFunction.payRetry.callable.ShopCartCallable;
import com.liugawaheliujinnao.singleFunction.payRetry.callable.result.ShopCartCallableResult;
import com.liugawaheliujinnao.singleFunction.payRetry.controller.common.Response;
import com.liugawaheliujinnao.singleFunction.payRetry.controller.request.PayRequest;
import com.liugawaheliujinnao.singleFunction.payRetry.service.OrderItemService;
import com.liugawaheliujinnao.singleFunction.payRetry.service.OrderService;
import com.liugawaheliujinnao.singleFunction.payRetry.service.ProductService;
import com.liugawaheliujinnao.singleFunction.payRetry.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeoutException;

/**
 * @Description: 支付接口 Controller
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Controller
@RequestMapping("api")
public class ApiController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ShopCartService shopCartService;

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping("/pay")
    @ResponseBody
    public Response pay(@RequestBody PayRequest request) {
        String odId = orderService.generateOrder();
        List<Long> cartIds = request.getCart_ids();
        int cartSize = cartIds.size();
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 1; i < cartSize; i++) {
            // 逻辑
            ShopCartCallable shopCartCallable = new ShopCartCallable(shopCartService, productService, orderItemService, odId, cartIds.get(i));
            FutureTask<ShopCartCallableResult> task = new FutureTask<>(shopCartCallable);
            es.submit(task);
            try {
                ShopCartCallableResult shopCartCallableResult = task.get();
                // 逻辑
            } catch (Exception e) {

            }
        }
        es.shutdown();
        while(true) {
            if (es.isTerminated()) {
                // 购物车线程结束
                break;
            }
        }
        return new Response();
    }
}
