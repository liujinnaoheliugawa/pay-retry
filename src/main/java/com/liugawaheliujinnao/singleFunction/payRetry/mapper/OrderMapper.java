package com.liugawaheliujinnao.singleFunction.payRetry.mapper;

import com.liugawaheliujinnao.singleFunction.payRetry.pojo.OrderPojo;

/**
 * @Description: 订单存储接口类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public interface OrderMapper {

    void insert(OrderPojo orderPojo);
}
