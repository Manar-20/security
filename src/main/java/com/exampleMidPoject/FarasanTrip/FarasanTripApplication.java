package com.exampleMidPoject.FarasanTrip;

import com.exampleMidPoject.FarasanTrip.Entity.Role;
import com.exampleMidPoject.FarasanTrip.Entity.User;
import com.exampleMidPoject.FarasanTrip.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FarasanTripApplication implements CommandLineRunner {
@Autowired
private UserRepository userRepository;
	public static void main(String[] args) {
		SpringApplication.run(FarasanTripApplication.class, args);
	}
public void run(String... args){
User adminAccount = userRepository.findByRole(Role.ADMIN);
if(null == adminAccount){
	User user =new User();
	user.setUsername("admin");
	user.setEmail("admin@gmail.com");
	user.setRole(Role.ADMIN);
	user.setPassword(new BCryptPasswordEncoder().encode("admin"));
	userRepository.save(user);
}
}
}
