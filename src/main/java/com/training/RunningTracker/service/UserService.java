package com.training.RunningTracker.service;


import com.training.RunningTracker.dao.UserDao;
import com.training.RunningTracker.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserService {
    private final UserDao userDao;

    @Autowired
    private UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean getUser(User user) {
        User existentUser = userDao.getUser(user);
        return existentUser.getUsername() != null || existentUser.getPassword() != null;
    }

    public boolean deleteUser(User user) {
        return userDao.deleteUser(user);
    }


    public boolean addNewUser(User user) {
        return userDao.createUser(user) != null;
    }

    public boolean updateUser(User user) {
        return userDao.updateUser(user) != null;
    }
}
