package com.mapinfo.controller;

import com.mapinfo.domain.Coordinate;
import com.mapinfo.service.CoordinateRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Israj PC on 10/17/2016.
 */
@RestController
@RequestMapping(value = "/api")
public class CoordinateController {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(DashboardController.class);

    @Autowired
    CoordinateRepository coordinateRepository;

    @RequestMapping(value = "/coordinate",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Map home() {
        Map map = new HashMap<>();
        map.put("list_data", coordinateRepository.findAll());

//        String password = "026";
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode(password);
//
//        System.out.println("tai : {}"+ hashedPassword);
        return map;
    }

    @RequestMapping(value = "/coordinate", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void  add(@RequestBody @Valid Coordinate coordinate) {
        coordinateRepository.save(coordinate);
    }

    @RequestMapping(value = "/coordinate",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody @Valid Coordinate coordinate){
        coordinateRepository.save(coordinate);
    }

    @RequestMapping(value = "/coordinate/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Coordinate> search(@PathVariable("id") String id){
        Coordinate param = coordinateRepository.findOne(id);
        if (param == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<Coordinate>(param,HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/coordinate/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") String id){
        coordinateRepository.delete(id);
    }
}
