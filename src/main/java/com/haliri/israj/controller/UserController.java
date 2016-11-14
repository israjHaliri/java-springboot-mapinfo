package com.haliri.israj.controller;

import com.haliri.israj.domain.Coordinate;
import com.haliri.israj.domain.User;
import com.haliri.israj.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by israjhaliri on 14/11/16.
 */
@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/api/user_info", method = RequestMethod.POST)
    public Map userInfo(@RequestParam(value = "username") String username) {
        User user = userRepository.findByUsername(username);
        Map map = new HashMap();
        map.put("data",user);
        return map;
    }
}
