package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/RunningTracker")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    HttpStatus login(@RequestBody User user) {
        if (!userService.getUser(user)) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }

    @DeleteMapping("/delete")
    HttpStatus delete(@RequestBody User user) {
        if (!userService.deleteUser(user)) {
            return HttpStatus.GONE;
        }
        return HttpStatus.NOT_FOUND;
    }

    @PostMapping("/register")
    HttpStatus register(@RequestBody User newUser) {
        if (!userService.addNewUser(newUser)) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.CREATED;
    }

    @PutMapping("/update")
    HttpStatus update(@RequestBody User user) {
        if (!userService.updateUser(user)) {
            return HttpStatus.NOT_FOUND;
        }
        return HttpStatus.OK;
    }
}
