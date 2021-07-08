package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.UserData;
import com.training.RunningTracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

@RestController
public class UserDataController {
    private UserDataService userDataService;

    @Autowired
    public UserDataController(UserDataService userDataService){
        this.userDataService = userDataService;
    }

    //new method
    @PostMapping("/postdata")
    UserData post(@RequestBody UserData userData){
        return userDataService.getUserData(userData);
    }
    


}
