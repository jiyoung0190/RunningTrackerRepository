package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/RunningTracker")
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/getUser/{username}/{password}")
    User getUserByLoginAndPassword(@PathVariable("username") String username, @PathVariable("password") String password) throws SQLException {
        return userService.getUserByLoginAndPassword(new User());
    }



}
