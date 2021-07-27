package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.entity.UserData;
import com.training.RunningTracker.service.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.sql.SQLException;

@RequestMapping("/RunningTracker")
@RestController
public class UserDataController {
    private UserDataService userDataService;


    @Autowired
    public UserDataController(UserDataService userDataService){
        this.userDataService = userDataService;
    }


    @GetMapping("/getData/{users_id}")
    UserData getUserData(@PathVariable Integer users_id) throws SQLException {
        return userDataService.getUserData(users_id);
    }
    
    @PostMapping("/addData")
    HttpStatus post(@RequestBody UserData userData){
        return userDataService.createUserData(userData);
    }

    //add update and delete
}
