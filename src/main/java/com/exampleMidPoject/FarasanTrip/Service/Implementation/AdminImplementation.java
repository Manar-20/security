package com.exampleMidPoject.FarasanTrip.Service.Implementation;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.Customer;
import com.exampleMidPoject.FarasanTrip.Repository.AdminRepository;
import com.exampleMidPoject.FarasanTrip.Service.Interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminImplementation implements AdminService {
    @Autowired
    AdminRepository adminRepo;
    // This method is used to create a new Admin in the system.
    @Override
    public Admin createNewAdmin(Admin admin) {
        return adminRepo.save(admin);
    }


    // This method retrieves a list of all Admins in the system.
    @Override
    public List<Admin> getAllAdmin() {
        return adminRepo.findAll();
    }
    @Override
    public String deleteByUserId(Long userId) {
        Optional<Admin> adminOptional = adminRepo.findByUserId(userId);
        // If a Admin with the specified userID is found, delete them from the database.
        if (adminOptional.isPresent()) {
            adminRepo.deleteById(userId);
            return "Admin is Deleted";
        } else {
            // If no Admin with the specified userID is found, return a message indicating that the customer is not found.
            return "The Admin is Not Found";
        }
    }


}
