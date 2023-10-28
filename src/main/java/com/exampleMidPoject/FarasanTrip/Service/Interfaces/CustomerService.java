package com.exampleMidPoject.FarasanTrip.Service.Interfaces;

import com.exampleMidPoject.FarasanTrip.Entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer addNewCustomer(Customer customer);

    List<Customer> getAllAdmin();



    String deleteByUserId(Long userId);
}
