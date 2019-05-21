package com.liugawaheliujinnao.singleFunction.payRetry.pojo;

/**
 * @Description: 商品 Pojo 类，包括单个商品的 id，name 和 兑换需要的点数
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class ProductPojo {

    private long pdId;

    private String pdName;

    private Integer pdPoint;

    public long getPdId() {
        return pdId;
    }

    public void setPdId(long pdId) {
        this.pdId = pdId;
    }

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public Integer getPdPoint() {
        return pdPoint;
    }

    public void setPdPoint(Integer pdPoint) {
        this.pdPoint = pdPoint;
    }

    public ProductPojo(long pdId) {
        this.pdId = pdId;
    }
}
