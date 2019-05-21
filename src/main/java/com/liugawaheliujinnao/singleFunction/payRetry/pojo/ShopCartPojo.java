package com.liugawaheliujinnao.singleFunction.payRetry.pojo;

/**
 * @Description: 购物车 Pojo 类，同一个商品将放在一个购物车中，包括 id， 商品 id，商品个数，已经购物车支付状态（用于在多个请求同时更新购物车时加行锁）
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class ShopCartPojo {

    private long cartId;

    private long cartPdId;

    private Integer cartPdQuantity;

    private Integer cartPayStatus;

    public long getCartId() {
        return cartId;
    }

    public void setCartId(long cartId) {
        this.cartId = cartId;
    }

    public long getCartPdId() {
        return cartPdId;
    }

    public void setCartPdId(long cartPdId) {
        this.cartPdId = cartPdId;
    }

    public Integer getCartPdQuantity() {
        return cartPdQuantity;
    }

    public void setCartPdQuantity(Integer cartPdQuantity) {
        this.cartPdQuantity = cartPdQuantity;
    }

    public Integer getCartPayStatus() {
        return cartPayStatus;
    }

    public void setCartPayStatus(Integer cartPayStatus) {
        this.cartPayStatus = cartPayStatus;
    }

    public ShopCartPojo(long cartId) {
        this.cartId = cartId;
    }

    public ShopCartPojo(long cartId, Integer cartPayStatus) {
        this.cartId = cartId;
        this.cartPayStatus = cartPayStatus;
    }

    public ShopCartPojo(long cartId, Integer cartPdQuantity, Integer cartPayStatus) {
        this.cartId = cartId;
        this.cartPdQuantity = cartPdQuantity;
        this.cartPayStatus = cartPayStatus;
    }
}
