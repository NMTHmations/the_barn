package com.sfm.thebarn.thebarn.service;

import com.sfm.thebarn.thebarn.model.Users;
import com.sfm.thebarn.thebarn.model.UsersCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersCRUD userRepository;

    public boolean userExists(String email) {
        return userRepository.findById(email).isPresent();
    }

    public void registerUser(Users user) {
        userRepository.save(user);
    }
}
