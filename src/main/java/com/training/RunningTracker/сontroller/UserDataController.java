package com.training.RunningTracker.сontroller;

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
    public UserDataController(UserDataService userDataService) {
        this.userDataService = userDataService;
    }


    @GetMapping("/userData/{user_id}")
    List<UserData> getUserData(@PathVariable int user_id) {
        return userDataService.getUserData(user_id);
    }

    @PostMapping("/userData")
    HttpStatus post(@RequestBody UserData userData) {
        return userDataService.createUserData(userData)? HttpStatus.CREATED : HttpStatus.BAD_REQUEST;
    }

    @DeleteMapping("/userData")
    HttpStatus delete(@RequestBody UserData userData) {
        if (!userDataService.deleteUserData(userData)) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.GONE;
    }

    @PutMapping("/userData")
    HttpStatus update(@RequestBody UserData userData) {
        if (!userDataService.updateUserData(userData)) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

}
