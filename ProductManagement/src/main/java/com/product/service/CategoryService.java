package com.product.service;

import com.product.entity.Category;
import com.product.repository.CategoryRepository;

import java.util.Optional;

public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService() {
        this.categoryRepository = new CategoryRepository();
    }
    public void save(Category category) {
        categoryRepository.save(category);
    }
    public Optional<Category> findByID(long categoryId) {
        return categoryRepository.findById(categoryId);
    }
}
