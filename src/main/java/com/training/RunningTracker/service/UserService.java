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

    public User getUserByLoginAndPassword(String username, User passwordBody) throws SQLException {
        return userDao.getUserByLoginAndPassword(username, passwordBody); //passwordBody of User type is reserved for user's password input
    }

    //delete method also works this way now
    public HttpStatus deleteUser(String username) throws SQLException{
        return userDao.deleteUser(username);
    }


    public HttpStatus addNewUser(User user) throws SQLException{
        return userDao.createUser(user);
    }

    public User updateUser(String oldUsername, User user) throws SQLException{
        return userDao.updateUser(oldUsername, user);
    }
}
