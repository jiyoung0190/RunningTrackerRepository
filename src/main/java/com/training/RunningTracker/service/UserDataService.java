package com.training.RunningTracker.service;

import com.training.RunningTracker.dao.UserDataDao;
import com.training.RunningTracker.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataService {
    private UserDataDao userDataDao;

    @Autowired
    public UserDataService(UserDataDao userDataDao){
        this.userDataDao = userDataDao;
    }

    //new method
    public UserData getUserData(UserData userData){
        return userDataDao.getUserData(userData);
    }
}
