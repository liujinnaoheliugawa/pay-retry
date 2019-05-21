package com.liugawaheliujinnao.singleFunction.payRetry.service.impl;

import com.liugawaheliujinnao.singleFunction.payRetry.mapper.OrderMapper;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.OrderPojo;
import com.liugawaheliujinnao.singleFunction.payRetry.service.OrderService;
import com.liugawaheliujinnao.singleFunction.payRetry.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * @Description: 订单服务实现类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public String generateOrder() {
        String orderId = null;
        try {
            orderId = RandomUtil.createOrderId();
            orderMapper.insert(new OrderPojo(orderId, 0));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("订单 ID 生成失败");
            e.printStackTrace();
        }
        return orderId;
    }
}
