package com.epam.timekeeping.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/api/activities")
public class ActivityController {

//    Logger logger = LoggerFactory.getLogger(ActivityController.class);
//    @Autowired
//    private ActivityService activityService;

//    @GetMapping
//    @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
//    public ResponseEntity<Object> getActivity(@RequestParam(required = false) String sort){
////        logger.info("get request for all activities with sort: "+sort);
////        return new ResponseEntity<>(activityService.getActivities(sort), HttpStatus.OK);
//        return new ResponseEntity<>("GET ACTIVITIES",HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Object> getActivity(@PathVariable int id){
////        logger.info("get request for activity with id: "+id);
////        return new ResponseEntity<>(activityService.getActivityById(id),HttpStatus.OK);
//        return new ResponseEntity<>("activity "+ id, HttpStatus.OK);
//    }

//    @PostMapping
//    public ResponseEntity<Object> postActivities(@RequestBody ActivityPostDto activity){
//        logger.info("post request for : "+activity.toString());
//        return new ResponseEntity<>(activityService.createActivity(activity),HttpStatus.CREATED);
//    }
//
//    @PutMapping(value = "/{id}")
//    public ResponseEntity<Object> updateActivity(@PathVariable Integer id,@RequestBody ActivityPostDto activity){
//        logger.info("put request with id "+id+" for : "+activity.toString());
//        return new ResponseEntity<>(activityService.updateActivity(id,activity),HttpStatus.OK);
//    }
//
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity<Object> deleteActivity(@PathVariable int id){
//        logger.info("delete request with id : "+id);
//        return new ResponseEntity<>(activityService.deleteActivity(id),HttpStatus.OK);
//    }
}
