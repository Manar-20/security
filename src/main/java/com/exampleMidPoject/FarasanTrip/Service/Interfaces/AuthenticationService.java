package com.exampleMidPoject.FarasanTrip.Service.Interfaces;

import com.exampleMidPoject.FarasanTrip.Entity.User;
import com.exampleMidPoject.FarasanTrip.dito.SignUpRequest;

public interface AuthenticationService {
    User signup(SignUpRequest signUpRequest);
}
