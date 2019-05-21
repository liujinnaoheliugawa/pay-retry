package com.liugawaheliujinnao.singleFunction.payRetry.pojo;

/**
 * @Description: 订单内容 Pojo 类，一个购物车 对应 一笔订单内容，由于购物车支付成功后会清空，所以需要订单内容表来对商品支付行为做记录
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class OrderItemsPojo {

    private long odItemId;

    private String odId;

    private long odPdId;

    private long odPdQuantity;

    public long getOdItemId() {
        return odItemId;
    }

    public void setOdItemId(long odItemId) {
        this.odItemId = odItemId;
    }

    public String getOdId() {
        return odId;
    }

    public void setOdId(String odId) {
        this.odId = odId;
    }

    public long getOdPdId() {
        return odPdId;
    }

    public void setOdPdId(long odPdId) {
        this.odPdId = odPdId;
    }

    public long getOdPdQuantity() {
        return odPdQuantity;
    }

    public void setOdPdQuantity(long odPdQuantity) {
        this.odPdQuantity = odPdQuantity;
    }

    public OrderItemsPojo(String odId, long odPdId, long odPdQuantity) {
        this.odId = odId;
        this.odPdId = odPdId;
        this.odPdQuantity = odPdQuantity;
    }
}
