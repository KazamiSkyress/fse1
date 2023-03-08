package com.example.usecase.config;

import com.example.usecase.model.User;
import com.example.usecase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUserName(username);
//        if (user == null) {
//
//            new UsernameNotFoundException("No User found");
//        }
//        return new MyUserDetails(user);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username).map(MyUserDetails::new)
                .orElseThrow(()-> new UsernameNotFoundException("No User found"));
    }

}
