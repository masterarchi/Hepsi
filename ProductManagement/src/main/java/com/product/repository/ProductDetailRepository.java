package com.product.repository;


import com.product.entity.ProductDetail;
import com.product.util.MyRepositoryFactory;

public class ProductDetailRepository extends MyRepositoryFactory<ProductDetail,Long> {
    public ProductDetailRepository() {
        super(ProductDetail.class);
    }
}
