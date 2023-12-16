package com.product.controller;

import com.product.entity.Category;
import com.product.entity.Customer;
import com.product.entity.Product;
import com.product.service.CategoryService;
import com.product.service.ProductService;
import com.product.util.BAUtils;

import java.util.Optional;

public class ProductController {
    private final ProductService productService;
    private final CategoryController categoryController;
    public ProductController() {
        this.productService = new ProductService();
        this.categoryController = new CategoryController();
    }

    public void save() {
        String productName = BAUtils.readString("Prdouct Name: ");
        double price = BAUtils.readDouble("Price : ");
        int stock = BAUtils.readInt("Stock: ");

        long categoryId = BAUtils.readInt("Category Belirle");
        Optional<Category> optionalCategory =  categoryController.findByID(categoryId);

        Product product = Product.builder()
                .name(productName)
                .price(price)
                .stock(stock)
                .category(optionalCategory.get())
                .build();

        productService.save(product);
    }

    public void buyProduct(Customer customer) {
        long id = BAUtils.readInt("ALmak istediğiniz ürünün idsini Girin");
        int amount = BAUtils.readInt("Kaç adet almak istiyosunuz");

        Optional<Product> optionalProduct =  productService.buyProduct(id,amount);

        optionalProduct.get().getCustomers().add(customer);
        optionalProduct.get().setStock(optionalProduct.get().getStock() - amount);

        productService.update(optionalProduct.get());

    }
}
