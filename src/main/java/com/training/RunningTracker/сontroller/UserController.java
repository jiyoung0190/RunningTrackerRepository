package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequestMapping("/RunningTracker")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login/{username}")
    User login(@PathVariable String username, @RequestBody User passwordBody) throws SQLException {
        return userService.getUserByLoginAndPassword(username, passwordBody); //passwordBody of User type is reserved for user's password input
    }

    @DeleteMapping("/delete/{username}") //use the username to delete his account in the JSON "body" section
    HttpStatus delete(@PathVariable String username) throws  SQLException {
        return userService.deleteUser(username);
    }

    @PostMapping("/register")
    HttpStatus register(@RequestBody User newUser) throws SQLException{
        return userService.addNewUser(newUser);
    }
    
    @PutMapping("/update/{username}")
    User update(@PathVariable String username, @RequestBody User user) throws SQLException{
        return userService.updateUser(username, user);
    }

}
