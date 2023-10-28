package com.exampleMidPoject.FarasanTrip.Service.Implementation;

import com.exampleMidPoject.FarasanTrip.Repository.UserRepository;
import com.exampleMidPoject.FarasanTrip.Service.Interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService(){
        new UserDetailsService (){
            @Override
            public UserDetails loadUserByUsername( String usename){
                return userRepository.findByUsername(usename)
                        .orElseThrow(()-> new UsernameNotFoundException("user not found"));
            }
        };
      return null;
    }
}
