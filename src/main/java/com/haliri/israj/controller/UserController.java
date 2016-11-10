package com.haliri.israj.controller;

import com.haliri.israj.domain.User;
import com.haliri.israj.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by israjhaliri on 09/11/16.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/api/custom_auth", method = RequestMethod.POST)
    public User infoLogin() throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username

        User user = userRepository.findByUsername(name);
        if(user==null){
            throw new Exception("Invalid Session");
        }

        return user;
    }
}
