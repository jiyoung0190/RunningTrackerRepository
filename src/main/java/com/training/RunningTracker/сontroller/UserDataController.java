package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
import com.training.RunningTracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/RunningTracker")
@RestController
public class UserDataController {
    private final UserDataService userDataService;


    @Autowired
    public UserDataController(UserDataService userDataService){
        this.userDataService = userDataService;
    }


    @GetMapping("/getData")
    List<UserData> getUserData(@RequestBody User user) {
        return userDataService.getUserData(user);
    }
    
    @PostMapping("/addData/{users_id}")
    HttpStatus post(@PathVariable Integer users_id, @RequestBody UserData userData){
        return userDataService.createUserData(users_id, userData);
    }

    @DeleteMapping("/deleteData/{users_id}")
    HttpStatus delete(@PathVariable Integer users_id){
        return userDataService.deleteUserData(users_id);
    }

    @PutMapping("/updateData/{users_id}/{record_id}")
    HttpStatus update(@PathVariable Integer users_id, @PathVariable Integer record_id, @RequestBody UserData userData){
        return userDataService.updateUserData(users_id, record_id, userData);
    }

}
