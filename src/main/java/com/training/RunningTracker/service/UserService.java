package com.training.RunningTracker.service;


import com.training.RunningTracker.dao.UserDao;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private UserDao userDao;

    private UserService(UserDao userDao){
        this.userDao = userDao;
    }
    
}
