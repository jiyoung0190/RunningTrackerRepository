package com.training.RunningTracker.сontroller;

import com.training.RunningTracker.entity.User;
import com.training.RunningTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/RunningTracker")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

   /* @PostMapping("/login")
    public ResponseBody login(@RequestParam String username, @RequestParam String password){
        return userService.
    }


    */

    @PostMapping("/register")
    public void register(@RequestBody User user) {
             userService.addNewUser(user);
    }
}
    /*
    @PutMapping("/update")
    HttpStatus update(@RequestBody User user) {
        if (!userService.updateUser(user)) {
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

     */


