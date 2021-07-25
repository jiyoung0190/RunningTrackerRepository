package com.training.RunningTracker.service;


import com.training.RunningTracker.dao.UserDao;
import com.training.RunningTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
public class UserService {
    private UserDao userDao;

    @Autowired
    private UserService(UserDao userDao){
        this.userDao = userDao;
    }

    public User getUserByLoginAndPassword(User newUser) throws SQLException {
        return userDao.getUserByLoginAndPassword(newUser);
    }

    public User deleteUser(User user) throws SQLException{
        return userDao.deleteUser(user);
    }


    public HttpStatus addNewUser(User user) {
    }
}
