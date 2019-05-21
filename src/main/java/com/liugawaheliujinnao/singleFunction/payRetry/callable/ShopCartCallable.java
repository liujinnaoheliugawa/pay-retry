package com.liugawaheliujinnao.singleFunction.payRetry.callable;

import com.liugawaheliujinnao.singleFunction.payRetry.callable.result.ShopCartCallableResult;
import com.liugawaheliujinnao.singleFunction.payRetry.callable.result.ShopCartPartResult;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.OrderItemsPojo;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ProductPojo;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ShopCartPojo;
import com.liugawaheliujinnao.singleFunction.payRetry.service.OrderItemService;
import com.liugawaheliujinnao.singleFunction.payRetry.service.ProductService;
import com.liugawaheliujinnao.singleFunction.payRetry.service.ShopCartService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: 购物车线程
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public class ShopCartCallable implements Callable<ShopCartCallableResult> {

    private ShopCartService shopCartService;

    private ProductService productService;

    private OrderItemService orderItemService;

    private String odId;

    private long cartId;

    public ShopCartCallable(ShopCartService shopCartService, ProductService productService, OrderItemService orderItemService, String odId, long cartId) {
        this.shopCartService = shopCartService;
        this.productService = productService;
        this.orderItemService = orderItemService;
        this.odId = odId;
        this.cartId = cartId;
    }

    @Override
    public ShopCartCallableResult call() {
        ShopCartCallableResult result = new ShopCartCallableResult();
        Map<String, ShopCartPartResult> map = new HashMap<>();
        boolean shopCartFalse = false;
        ShopCartPojo shopCart = shopCartService.selectById(cartId);
        if (shopCart != null) {
            if (shopCartService.updateShopCartStatusToPaying(cartId) == 1) { //加行锁，防止同时更新同一笔订单
                Integer i;
                long pdId = shopCart.getCartPdId();
                Integer pdQuantity = shopCart.getCartPdQuantity();
                ProductPojo product = productService.selectById(pdId);
                if (product != null) {
                    Integer pdPoint = product.getPdPoint();
                    orderItemService.insert(new OrderItemsPojo(odId, pdId, pdQuantity));
                    int reserveQuantity = pdQuantity; //用来记录支付过程中还剩余的笔数
                    ExecutorService es = Executors.newFixedThreadPool(4);
                    for (i = 0; i < pdQuantity; i++) {

                    }
                    es.shutdown();
                    while (true) {
                        if (es.isShutdown()) {
                            break;
                        }
                    }
                    if (reserveQuantity == 0) { //全部兑换成功，从购物车中删除
                        shopCartService.updateShopCartStatusToPayed(cartId);
                        shopCartService.removeById(cartId);
                    } else { //部分兑换失败，更新购物车中商品数量
                        shopCartService.updateShopCartProductQuantity(cartId, reserveQuantity);
                    }
                }
            }
        }
        return result;
    }
}
