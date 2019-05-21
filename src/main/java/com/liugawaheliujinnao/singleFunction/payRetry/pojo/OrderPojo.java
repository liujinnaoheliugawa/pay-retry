package com.liugawaheliujinnao.singleFunction.payRetry.pojo;

/**
 * @Description: 订单 Pojo 类，只要点击付款，无论购买成功与否，都会生成订单，一次付款操作完成后会更新订单状态
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class OrderPojo {

    private String odId;

    private Integer orderStatus;

    public String getOdId() {
        return odId;
    }

    public void setOdId(String odId) {
        this.odId = odId;
    }

    public OrderPojo(String odId, Integer orderStatus) {
        this.odId = odId;
        this.orderStatus = orderStatus;
    }
}
