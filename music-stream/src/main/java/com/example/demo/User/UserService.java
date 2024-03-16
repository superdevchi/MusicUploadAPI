package com.example.demo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserModel CreateUser (UserModel userModel){

        return userRepository.save(userModel);
    }

    public List<UserModel> ListUsers(){
        return userRepository.findAll();
    }
}
