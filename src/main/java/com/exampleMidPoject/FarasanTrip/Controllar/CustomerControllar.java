package com.exampleMidPoject.FarasanTrip.Controllar;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.Customer;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;
import com.exampleMidPoject.FarasanTrip.Repository.CustomerRepository;
import com.exampleMidPoject.FarasanTrip.Service.Implementation.CustmoerImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerControllar {
    @Autowired
    CustmoerImplementation custmoerImpl;
    CustomerRepository customerRepo;
    // This endpoint allows you to add a new customer.
    @PostMapping("/new-Customer")
    @ResponseStatus
    public ResponseEntity<String> addNewCustomer(@RequestBody Customer customer) {
        try {
            // Call the CustomerImplementation service to add a new customer.
            custmoerImpl.addNewCustomer(customer);
            String message = "Customer created Successful";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            // If there's an exception, return an error message with the exception details.
            String errorMessage = "Customer created Unsuccessful" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
    // This endpoint allows you to retrieve a list of all customers.
    @GetMapping("/Customer")
    public List<Customer> customers(){
        return custmoerImpl.getAllAdmin();
    }
    // This endpoint allows you to delete a customer by their userID.
    @DeleteMapping("/delete/{userId}")
    @ResponseStatus
    public ResponseEntity<String> deleteCustomer(@PathVariable Long userId) {
        try {
            // Call the CustomerImplementation service to delete a customer by userID.
              custmoerImpl.deleteByUserId(userId);
                 String message = "Customer Deleted Successful";
                 return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            // If there's an exception return an error message with the exception details.
            String errorMessage = "Customer Delete Unsuccessful" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}
