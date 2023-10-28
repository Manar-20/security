package com.exampleMidPoject.FarasanTrip.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private Long bookingId;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private FarasanTrip trip;
    private String bookingDate;
// This class represents a Booking entity in the system, which is used to store booking information.
}
