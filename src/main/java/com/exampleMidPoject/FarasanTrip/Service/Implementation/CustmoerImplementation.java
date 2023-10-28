package com.exampleMidPoject.FarasanTrip.Service.Implementation;

import com.exampleMidPoject.FarasanTrip.Entity.Customer;
import com.exampleMidPoject.FarasanTrip.Repository.CustomerRepository;
import com.exampleMidPoject.FarasanTrip.Service.Interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustmoerImplementation implements CustomerService {
    @Autowired
    CustomerRepository customerRepo;

    @Override
    public Customer addNewCustomer(Customer customer) {
        // This method adds a new customer by saving the provided Customer object to the database using the CustomerRepository.
        return customerRepo.save(customer);
    }
    // This method retrieves a list of all customers by calling the findAll() method of the CustomerRepository.
    @Override
    public List<Customer> getAllAdmin() {
        return customerRepo.findAll();
    }

    // This method deletes a customer by their userID.
    @Override
    public String deleteByUserId(Long userId) {
        Optional<Customer> customerOptional=customerRepo.findByUserId(userId);
        // If a customer with the specified userID is found, delete them from the database.
        if (customerOptional.isPresent()){
            customerRepo.deleteById(userId);
            return "Customer is Deleted";
        }else {
            // If no customer with the specified userID is found, return a message indicating that the customer is not found.
            return "The Customer is Not Found";

        }
    }


}


