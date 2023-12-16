package com.product.repository;

import com.product.entity.Product;
import com.product.util.MyRepositoryFactory;

public class ProductRepository extends MyRepositoryFactory<Product,Long> {
    public ProductRepository() {
        super(Product.class);
    }
}
