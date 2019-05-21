package com.liugawaheliujinnao.singleFunction.payRetry.service.impl;

import com.liugawaheliujinnao.singleFunction.payRetry.mapper.ShopCartMapper;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ShopCartPojo;
import com.liugawaheliujinnao.singleFunction.payRetry.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 购物车服务实现类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired
    private ShopCartMapper shopCartMapper;

    @Override
    public ShopCartPojo selectById(long cartId) {
        return shopCartMapper.selectByPrimaryKey(new ShopCartPojo(cartId));
    }

    @Override
    public int updateShopCartStatusToPaying(long cartId) {
        return shopCartMapper.updateByPrimaryKey(new ShopCartPojo(cartId, 1));
    }

    @Override
    public void updateShopCartStatusToPayed(long cartId) {
        shopCartMapper.updateByPrimaryKey(new ShopCartPojo(cartId, 2));
    }

    @Override
    public void removeById(long cartId) {
        shopCartMapper.deleteByPrimaryKey(new ShopCartPojo(cartId));
    }

    @Override
    public void updateShopCartProductQuantity(long cartId, Integer pdQuantity) {
        shopCartMapper.updateByPrimaryKey(new ShopCartPojo(cartId, pdQuantity, 0));
    }
}
