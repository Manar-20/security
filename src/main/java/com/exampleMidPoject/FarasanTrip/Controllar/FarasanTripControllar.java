package com.exampleMidPoject.FarasanTrip.Controllar;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;
import com.exampleMidPoject.FarasanTrip.Service.Implementation.FarasanTripImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class FarasanTripControllar {
    @Autowired
   private FarasanTripImplementation farasanTripImpl;


    @PostMapping("/add-new-Trip")
    public String addNewTrip(@RequestBody FarasanTrip trip) {
        // Create a new trip and return a success message or an error message if failed.
       try {
        farasanTripImpl.addNewTrip(trip);
           String message = "Trip created Successful";
           return message ;
       }
       catch(Exception e){
           String errorMessage ="Trip created Unsuccessful" +e.getMessage();
           return errorMessage;

       }
    }
    @GetMapping("/trips")
    public List<FarasanTrip> getAllTrips(){
        // Get a list of all trips.
        return farasanTripImpl.getAllTrips();
    }
    @PutMapping("/Update-Trip_Info/{farryName}")
    public String updateTrip(@PathVariable String farryName, @RequestBody FarasanTrip  farasanTrip) {
        // Update trip information and return a success message or an error message if failed.
         farasanTripImpl.updateTripById(farryName, farasanTrip);
        try {
            farasanTripImpl.updateTripById(farryName, farasanTrip);
            String message = "Trip Information is Updated";
            return message ;
        }
        catch(Exception e){
            String errorMessage ="Trip Information Not Updated" +e.getMessage();
            return errorMessage;

        }
    }

}
