package com.exampleMidPoject.FarasanTrip.Service.Implementation;

import com.exampleMidPoject.FarasanTrip.Entity.Role;
import com.exampleMidPoject.FarasanTrip.Entity.User;
import com.exampleMidPoject.FarasanTrip.Repository.UserRepository;
import com.exampleMidPoject.FarasanTrip.Service.Interfaces.AuthenticationService;
import com.exampleMidPoject.FarasanTrip.dito.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User signup(SignUpRequest signUpRequest){
    User user =new User();
    user.setUsername(signUpRequest.getUsername());
    user.setEmail(signUpRequest.getEmail());
    user.setRole(Role.CUSTOMER);
    user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
   return userRepository.save(user);
    }
}
