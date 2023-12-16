package com.product.controller;

import com.product.entity.Category;
import com.product.service.CategoryService;
import com.product.util.BAUtils;

import java.util.Optional;

public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(){
        this.categoryService = new CategoryService();
    }

    public void save() {
        String categoryName = BAUtils.readString("Category Name:");
        Category category = Category.builder()
                .name(categoryName)
                .build();

        categoryService.save(category);
    }

    public Optional<Category> findByID(long categoryId) {
        return categoryService.findByID(categoryId);
    }
}
