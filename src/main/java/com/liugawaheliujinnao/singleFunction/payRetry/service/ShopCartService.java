package com.liugawaheliujinnao.singleFunction.payRetry.service;

import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ShopCartPojo;

/**
 * @Description: 购物车服务类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public interface ShopCartService {

    ShopCartPojo selectById(long cartId);

    int updateShopCartStatusToPaying(long cartId);

    void updateShopCartStatusToPayed(long cartId);

    void removeById(long cartId);

    void updateShopCartProductQuantity(long cartId, Integer pdQuantity);
}
