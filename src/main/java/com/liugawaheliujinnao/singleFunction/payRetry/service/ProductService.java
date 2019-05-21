package com.liugawaheliujinnao.singleFunction.payRetry.service;

import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ProductPojo;

/**
 * @Description: 商品服务接口类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public interface ProductService {

    ProductPojo selectById(long pdId);
}
