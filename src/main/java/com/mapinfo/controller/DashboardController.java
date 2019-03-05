package com.mapinfo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by israjhaliri on 07/11/16.
 */
@RestController
@RequestMapping(value = "/api")
public class DashboardController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(value = "/dashboard",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map home() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        UserDetails userDetails = null;

        if (principal instanceof UserDetails) {
            userDetails = (UserDetails) principal;
        }

        String userName = userDetails.getUsername();

        Map map = new HashMap<>();
        map.put("userName", userName);

        logger.debug("username login : {}",userName);

        return map;
    }

}
