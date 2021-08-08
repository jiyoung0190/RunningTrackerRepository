package com.training.RunningTracker.service;


import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public void addNewUser(User user) {
        userRepository.save(user);
    }
}

