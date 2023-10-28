package com.exampleMidPoject.FarasanTrip.Service.Interfaces;

import com.exampleMidPoject.FarasanTrip.Entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmin();

    Admin createNewAdmin(Admin admin);


     String deleteByUserId(Long userId);
}
