package com.liugawaheliujinnao.singleFunction.payRetry.mapper.impl;

import com.liugawaheliujinnao.singleFunction.payRetry.mapper.OrderMapper;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.OrderPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Vector;

/**
 * @Description: 订单存储实现类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Repository
public class OrderMapperImpl implements OrderMapper {

    private List<OrderPojo> orders = new Vector<OrderPojo>();

    @Override
    public void insert(OrderPojo orderPojo) {
        orders.add(orderPojo);
    }
}
