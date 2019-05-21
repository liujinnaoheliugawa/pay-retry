package com.liugawaheliujinnao.singleFunction.payRetry.service.impl;

import com.liugawaheliujinnao.singleFunction.payRetry.mapper.ProductMapper;
import com.liugawaheliujinnao.singleFunction.payRetry.pojo.ProductPojo;
import com.liugawaheliujinnao.singleFunction.payRetry.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 商品接口实现类
 * @Author: LiugawaHeLiujinnao
 * @Date: 2019-05-21
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductPojo selectById(long pdId) {
        return productMapper.selectByPrimaryKey(new ProductPojo(pdId));
    }
}
