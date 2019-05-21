package com.liugawaheliujinnao.singleFunction.payRetry.callable.result;

import java.util.List;
import java.util.Map;

/**
 * @Description: 购物车线程返回
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class ShopCartCallableResult {

    private List<String> transacationIds;

    private Map<String, ShopCartPartResult> shopCartPartResult;

    public List<String> getTransacationIds() {
        return transacationIds;
    }

    public void setTransacationIds(List<String> transacationIds) {
        this.transacationIds = transacationIds;
    }

    public Map<String, ShopCartPartResult> getShopCartPartResult() {
        return shopCartPartResult;
    }

    public void setShopCartPartResult(Map<String, ShopCartPartResult> shopCartPartResult) {
        this.shopCartPartResult = shopCartPartResult;
    }
}
