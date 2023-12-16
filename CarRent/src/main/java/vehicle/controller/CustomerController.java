package product.controller;

import product.entity.Customer;
import product.entity.Information;
import product.entity.Vehicle;
import product.service.CustomerService;
import product.util.BAUtils;

import java.util.HashMap;

public class CustomerController {

    private final CustomerService customerService;

    public CustomerController() {
        this.customerService = new CustomerService();
    }


    public void register(){
        String firstName = BAUtils.readString("İsminiz");
        String lastName = BAUtils.readString("Soyisminiz");
        String email = BAUtils.readString("email");

        Information information = Information.builder()
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .build();

        String password = BAUtils.readString("şifreniz");
        String identityNo=BAUtils.readString("Tcniz: ");

        Customer customer = Customer.builder()
                .identity(identityNo)
                .password(password)
                .information(information)
                .build();

        customerService.register(customer);

    }

    public Customer login(){
        String identity = BAUtils.readString("TC'nizi giriniz");
        String password = BAUtils.readString("Sifrenizi giriniz");
        return customerService.findCustomerByIdentity(identity,password).get();
    }


    public void aracEkle(){
        String firstName = BAUtils.readString("Arac Marka");
        String lastName = BAUtils.readString("Model");
        String email = BAUtils.readString("email");

        Information information = Information.builder()
                .firstname(firstName)
                .lastname(lastName)
                .email(email)
                .build();

        String password = BAUtils.readString("şifreniz");
        String identityNo=BAUtils.readString("Tcniz: ");

        Customer customer = Customer.builder()
                .identity(identityNo)
                .password(password)
                .information(information)
                .build();

        customerService.register(customer);
    }















}
