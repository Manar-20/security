package com.exampleMidPoject.FarasanTrip.Controllar;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;
import com.exampleMidPoject.FarasanTrip.Service.Implementation.AdminImplementation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")


public class AdminController {
    @Autowired
    AdminImplementation adminImpl;

    // This endpoint allows you to create a new Admin
    @PostMapping("/create-Admin")
    public String createNewAdmin(@RequestBody Admin admin) {
        try {
            // Call the AdminImplementation service to create the new Admin.
            adminImpl.createNewAdmin(admin);
            // If the creation is successful, return a success message.
            String message = "Admin created Successful";
            return message ;
        }
        catch(Exception e){
            // If there is an exception return an error message with the exception details.
            String errorMessage ="Admin created Unsuccessful" +e.getMessage();
            return errorMessage;

        }

    }
    // This endpoint allows you to retrieve a list of all Admins.
    @GetMapping("/Admins")
    public List<Admin> Admin(){
        // Call the AdminImplementation service to get a list of all Admins.
        return adminImpl.getAllAdmin();
    }
    @DeleteMapping("/delete-Admin/{userId}")
    @ResponseStatus
    public ResponseEntity<String> deleteAdmin(@PathVariable Long userId) {
        try {
            // Call the AdminImplementation service to delete a customer by userID.
            adminImpl.deleteByUserId(userId);
            String message = "Admin Deleted Successful";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            // If there's an exception return an error message with the exception details.
            String errorMessage = "Admin Deleted Unsuccessful" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }


}
