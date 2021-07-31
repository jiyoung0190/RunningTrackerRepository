package com.training.RunningTracker.service;

import com.training.RunningTracker.dao.UserDataDao;
import com.training.RunningTracker.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataService {
    private final UserDataDao userDataDao;

    @Autowired
    public UserDataService(UserDataDao userDataDao) {
        this.userDataDao = userDataDao;
    }


    public List<UserData> getUserData(UserData userData) {
        return userDataDao.getUserData(userData);
    }

    public boolean createUserData(UserData userData) {
        UserData createdData = userDataDao.createUserData(userData);
        return createdData != null;
    }

    public boolean deleteUserData(UserData userData) {
        UserData deletedData = userDataDao.deleteUserData(userData);
        return deletedData != null;
    }


    public boolean updateUserData(UserData userData) {
        UserData updated = userDataDao.updateUserData(userData);
        return updated != null;
    }
}
