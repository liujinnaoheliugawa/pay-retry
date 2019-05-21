package com.liugawaheliujinnao.singleFunction.payRetry.service.impl;

import com.liugawaheliujinnao.singleFunction.payRetry.mapper.OrderItemMapper;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.OrderItemsPojo;
import com.liugawaheliujinnao.singleFunction.payRetry.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 订单内容服务接口类实现
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Override
    public void insert(OrderItemsPojo orderItemsPojo) {
        orderItemMapper.insert(orderItemsPojo);
    }
}
