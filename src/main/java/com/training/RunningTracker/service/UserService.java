package com.training.RunningTracker.service;


import com.training.RunningTracker.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {
    private UserDao userDao;

    @Autowired
    private UserService(UserDao userDao){
        this.userDao = userDao;
    }
    
}
