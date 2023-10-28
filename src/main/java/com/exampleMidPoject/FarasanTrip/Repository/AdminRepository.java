package com.exampleMidPoject.FarasanTrip.Repository;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin,Long> {


    Optional<Admin> findByUserId(Long userId);
}
