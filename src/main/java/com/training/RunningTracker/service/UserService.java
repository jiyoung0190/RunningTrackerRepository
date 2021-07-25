package com.training.RunningTracker.service;


import com.training.RunningTracker.dao.UserDao;
import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
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

    public User getUserByLoginAndPassword(User user) throws SQLException {
        return userDao.getUserByLoginAndPassword(user);
    }

    public User deleteUser(User user) throws SQLException{
        return userDao.deleteUser(user);
    }


    public User addNewUser(User user) {
        return userDao.createUser(user);
    }


}
