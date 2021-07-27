package com.training.RunningTracker.service;

import com.training.RunningTracker.dao.UserDataDao;
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


    public UserData getUserData(Integer users_id){
        return userDataDao.getUserData(users_id);
    }

    public HttpStatus createUserData(Integer userId, UserData userData) {
        return userDataDao.createUserData(userId, userData);
    }

    public HttpStatus deleteUserData(Integer userId){
        return userDataDao.deleteUserData(userId);
    }


    public HttpStatus updateUserData(Integer userId, Integer recordId, UserData userData) {
        return userDataDao.updateUserData(userId, recordId, userData);
    }
}
