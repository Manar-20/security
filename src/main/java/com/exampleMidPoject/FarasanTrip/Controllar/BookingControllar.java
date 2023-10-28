package com.exampleMidPoject.FarasanTrip.Controllar;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.Booking;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;
import com.exampleMidPoject.FarasanTrip.Repository.BookingRepository;
import com.exampleMidPoject.FarasanTrip.Repository.FarasanTripRepository;
import com.exampleMidPoject.FarasanTrip.Service.Implementation.BookingImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingControllar {
    @Autowired
    private BookingImplementation bookingImpl;

    // This endpoint allows you to create a new booking
    @PostMapping("/Add-new-booking")
    public String createNewBooking(@RequestBody Booking booking) {
        try {
            // Call the BookingImplementation service to create a new booking.
            bookingImpl.createNewBooking(booking);
            // If the creation is successful, return a success message.
            String message = "Booking Added Successful";
            return message ;
        }
        catch(Exception e){
            // If there's an exception, return an error message with the exception details.
            String errorMessage ="Booking Added Unsuccessful" +e.getMessage();
            return errorMessage;

        }

    }

    // This endpoint allows you to retrieve a list of all bookings.
    @GetMapping("/All-Booking")
    public List<Booking> booking(){
        // Call the BookingImplementation service to get a list of all bookings.
        return bookingImpl.getAllBooking();
    }
    @DeleteMapping("/delete-Booking/{bookingId}")
    @ResponseStatus
    public ResponseEntity<String> deleteBooking(@PathVariable Long bookingId) {
        try {
            // Call the BookingImplementation service to delete a customer by userID.
            bookingImpl.deleteByBookingId(bookingId);
            String message = "Booking Deleted Successful";
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            // If there's an exception return an error message with the exception details.
            String errorMessage = "Booking Deleted Unsuccessful" + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

}
