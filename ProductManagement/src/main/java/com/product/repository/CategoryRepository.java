package com.product.repository;

import com.product.entity.Category;
import com.product.util.MyRepositoryFactory;

public class CategoryRepository extends MyRepositoryFactory<Category,Long> {

    public CategoryRepository() {
        super(Category.class);
    }
}
