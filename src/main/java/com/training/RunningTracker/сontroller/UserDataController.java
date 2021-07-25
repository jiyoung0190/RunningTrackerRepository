package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
import com.training.RunningTracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/RunningTracker")
@RestController
public class UserDataController {
    private UserDataService userDataService;


    @Autowired
    public UserDataController(UserDataService userDataService){
        this.userDataService = userDataService;
    }


    @GetMapping("/getData")
    UserData getUserData(@RequestBody User user){
        return userDataService.getUserData(user);
    }
    
    @PostMapping("/addData")
    UserData post(@RequestBody UserData userData){
        return userDataService.createUserData(userData);
    }

    //add update and delete
}
