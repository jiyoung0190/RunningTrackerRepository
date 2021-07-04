package com.training.RunningTracker.service;

import com.training.RunningTracker.dao.UserDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDataService {
    private UserDataDao userDataDao;

    @Autowired
    public UserDataService(UserDataDao userDataDao){
        this.userDataDao = userDataDao;
    }
}
