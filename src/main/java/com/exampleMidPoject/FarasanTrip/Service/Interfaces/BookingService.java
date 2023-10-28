package com.exampleMidPoject.FarasanTrip.Service.Interfaces;

import com.exampleMidPoject.FarasanTrip.Entity.Booking;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();



    String createNewBooking(Booking booking);
    String deleteByBookingId(Long bookingId);
}
