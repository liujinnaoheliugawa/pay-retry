package com.liugawaheliujinnao.singleFunction.payRetry.callable.result;

/**
 * @Description: 购物车部分结果类，给前端显示用
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class ShopCartPartResult {

    private String pdName;

    private Integer count;

    private boolean success;

    public String getPdName() {
        return pdName;
    }

    public void setPdName(String pdName) {
        this.pdName = pdName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
