package parkinglot.Repositories;

import java.util.HashMap;
import java.util.Map;

import parkinglot.Models.Customer;

public class CustomerRepository {
    
    Map<String, Customer> customers;
    
    CustomerRepository(){
        customers = new HashMap<>();
    }

    public Customer getById(String customerId){
        return customers.get(customerId);
    }
}
