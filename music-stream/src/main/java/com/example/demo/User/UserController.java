package com.example.demo.User;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("User")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/")
    public String start(){
        return "Start";
    }

    @GetMapping("/list")
    public List<UserModel> List(){
        return service.ListUsers();
    }

    @PostMapping("/create")
    public String users(@RequestBody UserModel userModel){
        service.CreateUser(userModel);
        return "userlist";
    }
}
