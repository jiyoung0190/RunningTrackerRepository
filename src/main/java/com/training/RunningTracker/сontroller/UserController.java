package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/login")
    User login(@RequestBody User user) throws SQLException {
        return userService.getUserByLoginAndPassword(user);
    }

    @DeleteMapping("/delete") //use the username to delete his account in the JSON "body" section
    HttpStatus delete(@RequestBody User user) throws  SQLException {
        return userService.deleteUser(user);
    }

    @PostMapping("/register")
    HttpStatus register(@RequestBody User user) throws SQLException{
        return userService.addNewUser(user);


    }

}
