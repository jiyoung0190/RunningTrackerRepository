package com.training.RunningTracker.service;

import com.training.RunningTracker.dao.UserDataDao;
import com.training.RunningTracker.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataService {
    private final UserDataDao userDataDao;

    @Autowired
    public UserDataService(UserDataDao userDataDao){
        this.userDataDao = userDataDao;
    }


    public List<UserData> getUserData(UserData userData){
        return userDataDao.getUserData(userData);
    }

    public boolean createUserData(UserData userData) {
        UserData createdData = userDataDao.createUserData(userData);
        if(createdData == null){
            return false;
        }
        return true;
    }

    public HttpStatus deleteUserData(UserData userData){
        return userDataDao.deleteUserData(userData);
    }


    public HttpStatus updateUserData(UserData userData) {
        return userDataDao.updateUserData(userData);
    }
}
