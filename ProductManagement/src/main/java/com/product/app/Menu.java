package com.product.app;

import com.product.controller.CategoryController;
import com.product.controller.CustomerController;
import com.product.controller.ProductController;
import com.product.entity.Customer;
import com.product.util.BAUtils;

import java.util.HashMap;

public class Menu {

    private final CustomerController customerController;
    private final CategoryController categoryController;
    private final ProductController productController;

    public Menu() {
        this.customerController = new CustomerController();
        this.categoryController = new CategoryController();
        this.productController = new ProductController();
    }


    public void menu(){
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Admin");
        menuItems.put(2, "Customer");

        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                adminMenu();
                break;
            case 2:
                customerMenu();
                break;
        }
    }

    private void customerMenu() {
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Kayıt Ol");
        menuItems.put(2, "Giriş Yap");

        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                customerController.register();
                break;
            case 2:
                customerManagerMenu(customerController.login());
                break;
        }
    }
    private void customerManagerMenu(Customer customer) {
        HashMap<Integer, String> menuItems = new HashMap<>();
        System.out.println(customer.getIdentity());

        menuItems.put(1, "Satın Al");
        int key = BAUtils.menu(menuItems);

        switch (key){
            case 1:
                productController.buyProduct(customer);
                break;
            case 2:
                //System.out.println("Giriş Yap");
                break;
        }
    }

    private void adminMenu() {
        HashMap<Integer, String> menuItems = new HashMap<>();
        menuItems.put(1, "Product Ekle");
        menuItems.put(2, "Category Ekle");
        int key = BAUtils.menu(menuItems);
        //16:04
        switch (key){
            case 1:
                productController.save();
                //name Asus
                //stok 100
                //price 5000
                //categoryId  2
                break;
            case 2:
                categoryController.save();
                break;
        }
    }
}
