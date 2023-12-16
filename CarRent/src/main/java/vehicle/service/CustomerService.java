package product.service;

import product.entity.Customer;
import product.repository.CustomerRepository;

import javax.persistence.NoResultException;
import java.util.Optional;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(){
        this.customerRepository=new CustomerRepository();
    }

    public void register(Customer customer){
        customerRepository.save(customer);
    }



     public Optional<Customer> findCustomerByIdentity(String identity, String password){
        Optional <Customer> optionalcustomer = customerRepository.findCustomerByIdentity(identity);

        if(optionalcustomer.isPresent()){
            if(optionalcustomer.get().getPassword().equals(password)) {
                return optionalcustomer;
            }else{
                throw new RuntimeException("password is not valid");
            }
        }else {
            throw new RuntimeException("Customer Not found");
        }

     }

}
