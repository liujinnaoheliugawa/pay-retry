package com.liugawaheliujinnao.singleFunction.payRetry.mapper.impl;

import com.liugawaheliujinnao.singleFunction.payRetry.mapper.ShopCartMapper;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ShopCartPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Vector;

/**
 * @Description: 购物车存储实现类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Repository
public class ShopCartMapperImpl implements ShopCartMapper {

    private List<ShopCartPojo> shopCarts = new Vector<>();

    @Override
    public ShopCartPojo selectByPrimaryKey(ShopCartPojo shopCartPojo) {
        for (ShopCartPojo shopCart : shopCarts) {
            if (shopCart.getCartId() == shopCartPojo.getCartId()) {
                return shopCart;
            }
        }
        return null;
    }

    @Override
    public int updateByPrimaryKey(ShopCartPojo shopCartPojo) {
        int result = 0;
        for (ShopCartPojo shopCart : shopCarts) {
            if (shopCart.getCartId() == shopCart.getCartId()) {
                if (shopCartPojo.getCartPayStatus() != null) {
                    shopCart.setCartPayStatus(shopCartPojo.getCartPayStatus());
                }
                if (shopCartPojo.getCartPdQuantity() != null) {
                    shopCart.setCartPdQuantity(shopCartPojo.getCartPdQuantity());
                }
            }
        }
        return result;
    }

    @Override
    public void deleteByPrimaryKey(ShopCartPojo shopCartPojo) {
        List<ShopCartPojo> tmpShopCarts = shopCarts;
        for (ShopCartPojo shopCart : shopCarts) {
            if (shopCart.getCartId() == shopCart.getCartId()) {
                tmpShopCarts.remove(shopCart);
            }
        }
        shopCarts = tmpShopCarts;
    }
}
