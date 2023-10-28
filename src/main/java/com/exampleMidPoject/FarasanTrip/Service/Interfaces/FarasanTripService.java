package com.exampleMidPoject.FarasanTrip.Service.Interfaces;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;

import java.util.List;

public interface FarasanTripService {
    FarasanTrip addNewTrip(FarasanTrip trip);

    List<FarasanTrip> getAllTrips();

    String updateTripById(String farryName, FarasanTrip farasanTrip);
}
