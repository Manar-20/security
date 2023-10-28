package com.exampleMidPoject.FarasanTrip.Repository;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking , Long> {




    String deleteByBookingId(Long bookingId);

    Optional<Booking> findByBookingId(Long bookingId);
}
