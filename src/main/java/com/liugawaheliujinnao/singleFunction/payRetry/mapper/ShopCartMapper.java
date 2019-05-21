package com.liugawaheliujinnao.singleFunction.payRetry.mapper;

import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ShopCartPojo;

/**
 * @Description: 购物车存储接口类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public interface ShopCartMapper {

    ShopCartPojo selectByPrimaryKey(ShopCartPojo shopCartPojo);

    int updateByPrimaryKey(ShopCartPojo shopCartPojo);

    void deleteByPrimaryKey(ShopCartPojo shopCartPojo);
}
