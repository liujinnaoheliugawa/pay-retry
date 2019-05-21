package com.liugawaheliujinnao.singleFunction.payRetry.controller.request;

import java.util.List;

/**
 * @Description: 前端发起支付请求类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class PayRequest {

    private List<Long> cart_ids; //购物车列表

    public List<Long> getCart_ids() {
        return cart_ids;
    }

    public void setCart_ids(List<Long> cart_ids) {
        this.cart_ids = cart_ids;
    }
}
