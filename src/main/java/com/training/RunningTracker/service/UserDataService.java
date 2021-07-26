package com.training.RunningTracker.service;

import com.training.RunningTracker.dao.UserDataDao;
import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserDataService {
    private UserDataDao userDataDao;

    @Autowired
    public UserDataService(UserDataDao userDataDao){
        this.userDataDao = userDataDao;
    }


    public UserData getUserData(User user){
        return userDataDao.getUserData(user);
    }

    public HttpStatus createUserData(UserData userData) {
        return userDataDao.createUserData(userData);
    }

    public HttpStatus deleteUserData(UserData userData){
        return userDataDao.deleteUserData(userData);
    }


}
