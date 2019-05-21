package com.liugawaheliujinnao.singleFunction.payRetry.mapper.impl;

import com.liugawaheliujinnao.singleFunction.payRetry.mapper.ProductMapper;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ProductPojo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Vector;

/**
 * @Description: 商品存储接口类实现
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Repository
public class ProductMapperImpl implements ProductMapper {

    private List<ProductPojo> products = new Vector<>();

    @Override
    public ProductPojo selectByPrimaryKey(ProductPojo productPojo) {
        for (ProductPojo product : products) {
            if (product.getPdId() == productPojo.getPdId()) {
                return product;
            }
        }
        return null;
    }
}
