package com.example.usecase.service;

import com.example.usecase.dto.Login;
import com.example.usecase.model.User;
import org.springframework.stereotype.Service;

public interface UserService {

    public String register(User user);

    public String login(Login login);

    public String forgotPassword(String email, String newPassword);


}
