package com.example.usecase.controller;

import com.example.usecase.dto.Forgot;
import com.example.usecase.dto.Login;
import com.example.usecase.model.User;
import com.example.usecase.repository.UserRepository;
import com.example.usecase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/shopping")
public class UserController {

   @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
       return ResponseEntity.ok(userService.register(user));

    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login){

     return ResponseEntity.ok(userService.login(login));

//        return ResponseEntity.ok("Login page");
    }

    @PutMapping("/forgot")
    public String logout(@RequestBody Forgot forgotInfo){
        return userService.forgotPassword(forgotInfo.getEmail(), forgotInfo.getNewPassword());
    }




    @GetMapping("/public")
    public String publica(){
        return "Yes I am public";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admin page";
    }

    @GetMapping("/user")
    public String user(){
        return "User page";
    }

    @GetMapping("/demo")
    public String demo(){
        return "Demo page";
    }

}
