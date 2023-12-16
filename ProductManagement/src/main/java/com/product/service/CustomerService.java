package com.product.service;

import com.product.entity.Customer;
import com.product.repository.CustomerRepository;

import java.util.Optional;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(){
        this.customerRepository = new CustomerRepository();
    }

    public void register(Customer customer){
        customerRepository.save(customer);
    }

    public Optional<Customer> findCustomerByIdentity(String identity,String password) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByIdentity(identity);
        if(optionalCustomer.isPresent()){
            if(optionalCustomer.get().getPassword().equals(password)){
                return optionalCustomer;
            }else {
                System.out.println("Password Not Valid");
            }
        }else{
            System.out.println("Customer Not Found");
        }
        return Optional.empty();
    }
}
