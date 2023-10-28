package com.exampleMidPoject.FarasanTrip.Service.Implementation;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;
import com.exampleMidPoject.FarasanTrip.Entity.FarasanTrip;
import com.exampleMidPoject.FarasanTrip.Repository.FarasanTripRepository;
import com.exampleMidPoject.FarasanTrip.Service.Interfaces.FarasanTripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarasanTripImplementation implements FarasanTripService {
    @Autowired
    FarasanTripRepository farasanTripRepo;

    // Add a new FarasanTrip to the repository.
    @Override
    public FarasanTrip addNewTrip(FarasanTrip trip) {
        return farasanTripRepo.save(trip);
    }

    // Get a list of all FarasanTrips from the repository.
    @Override
    public List<FarasanTrip> getAllTrips() {
        return farasanTripRepo.findAll();
    }

    // Update the information of a FarasanTrip by its unique ferryName.
    @Override
    public String updateTripById(String farryName, FarasanTrip farasanTrip) {
        Optional<FarasanTrip> optionalFarasanTrip = farasanTripRepo.findById(farryName);

        if (optionalFarasanTrip.isPresent()) {
            FarasanTrip trip = optionalFarasanTrip.get();
            trip.setPrice(farasanTrip.getPrice());
            trip.setAvailableSeats(farasanTrip.getAvailableSeats());
            farasanTripRepo.save(trip);
            return "Information Updated";
        }

        return "Information UnUpdated";
    }


}
