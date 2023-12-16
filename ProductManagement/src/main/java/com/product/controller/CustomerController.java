package com.product.controller;

import com.product.entity.Customer;
import com.product.entity.Information;
import com.product.service.CustomerService;
import com.product.util.BAUtils;

import java.util.Optional;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }


    public void register(){
        String firstName = BAUtils.readString("İsminiz: ");
        String lastName = BAUtils.readString("Soyİsminiz: ");
        String email = BAUtils.readString("email: ");

        Information information = Information.builder()
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .build();

        String password = BAUtils.readString("şifreniz: ");
        String identityNo = BAUtils.readString("Tcniz: ");

        Customer customer = Customer.builder()
                .identity(identityNo)
                .password(password)
                .information(information)
                .build();

        customerService.register(customer);
    }

    public Customer login() {
        String identity = BAUtils.readString("TC nizi Giriniz: ");
        String password = BAUtils.readString("Şifrenizi Girin: ");

        return customerService.findCustomerByIdentity(identity,password).get();
    }
}
