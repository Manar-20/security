package com.exampleMidPoject.FarasanTrip.Repository;

import com.exampleMidPoject.FarasanTrip.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Optional<Customer> findByUserId(Long userId);



}
