package com.liugawaheliujinnao.singleFunction.payRetry.mapper;

import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ProductPojo;

/**
 * @Description: 商品存储接口类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
public interface ProductMapper {

    ProductPojo selectByPrimaryKey(ProductPojo productPojo);
}
