package com.exampleMidPoject.FarasanTrip.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
public class Admin extends User {
    // Constructor for creating an Admin with specific attributes.

    public Admin(Long userId, String username, String email, String password, Role role) {
        super(userId, username, email, password, role);
    }
}
