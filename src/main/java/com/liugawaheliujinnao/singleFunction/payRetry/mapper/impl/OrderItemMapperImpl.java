package com.liugawaheliujinnao.singleFunction.payRetry.mapper.impl;

import com.liugawaheliujinnao.singleFunction.payRetry.mapper.OrderItemMapper;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.OrderItemsPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Vector;

/**
 * @Description: 订单内容存储接口类实现
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Repository
public class OrderItemMapperImpl implements OrderItemMapper {

    private static long orderItemsId;

    private List<OrderItemsPojo> orderItems = new Vector<>();

    @Override
    public void insert(OrderItemsPojo orderItemsPojo) {
        orderItemsPojo.setOdItemId(orderItemsId++);
        orderItems.add(orderItemsPojo);
    }
}
