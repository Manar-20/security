package com.exampleMidPoject.FarasanTrip.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "trips_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
// Entity class for representing FarasanTrip data.
public class FarasanTrip {
    @Id
    private String farryName;
    private int availableSeats;
    private double price;
    @ManyToOne
    private Admin admin;

    }
