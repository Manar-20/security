package com.exampleMidPoject.FarasanTrip.Repository;

import com.exampleMidPoject.FarasanTrip.Entity.Role;
import com.exampleMidPoject.FarasanTrip.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    User findByRole(Role role);
}
