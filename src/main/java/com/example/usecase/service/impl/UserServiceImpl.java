package com.example.usecase.service.impl;

import com.example.usecase.dto.Login;
import com.example.usecase.model.User;
import com.example.usecase.repository.UserRepository;
import com.example.usecase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public String register(User user) {
        boolean existUser = userRepository.existsByEmail(user.getEmail());
        if(existUser){
            return "User with Email id Already exist try another";
        }
        //Check if Password and confirm password are same or not
        if(!user.getPassword().equals(user.getConfirmPassword())){
            return "Password and confirm password not matching";
        }

        //If User not exist and password and confirm password same
        // Save the User into Database and return Successfully registerd

        userRepository.save(user);
        return "User Registered Successfully";
    }

    @Override
    public String login(Login login) {
       User user = userRepository.findByUserNameAndPassword(login.getUserName(), login.getPassword());
       if(user == null) {
           return "User name or password incorrect";
       }
        return "Welcome to login page";
    }

    @Override
    public String forgotPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email);
        if(user == null){
            return "Your Email id is not Correct";
        }
        user.setPassword(newPassword);
        userRepository.save(user);
        return "Your Password has reset Successfully";
    }
}
