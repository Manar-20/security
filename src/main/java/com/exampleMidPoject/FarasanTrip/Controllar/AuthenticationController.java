package com.exampleMidPoject.FarasanTrip.Controllar;

import com.exampleMidPoject.FarasanTrip.Entity.User;
import com.exampleMidPoject.FarasanTrip.Service.Interfaces.AuthenticationService;
import com.exampleMidPoject.FarasanTrip.dito.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<User>signup(@RequestBody SignUpRequest signUpRequest){
      return ResponseEntity.ok(authenticationService.signup(signUpRequest));
    }
}
