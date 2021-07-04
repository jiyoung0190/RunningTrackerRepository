package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDataController {
    private UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService){
        this.userDataService = userDataService;
    }

}
