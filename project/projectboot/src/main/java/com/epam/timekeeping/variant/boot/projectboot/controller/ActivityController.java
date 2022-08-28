package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityPostDto;
import com.epam.timekeeping.variant.boot.projectboot.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public ResponseEntity<Object> getActivity(@RequestParam(required = false) String sort){
        return new ResponseEntity<>(activityService.getActivities(sort), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getActivity(@PathVariable int id){
        return new ResponseEntity<>(activityService.getActivityById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> postActivities(@RequestBody ActivityPostDto activity){
        return new ResponseEntity<>(activityService.createActivity(activity),HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateActivity(@PathVariable Integer id,@RequestBody ActivityPostDto activity){
        return new ResponseEntity<>(activityService.updateActivity(id,activity),HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteActivity(@PathVariable int id){
        return new ResponseEntity<>(activityService.deleteActivity(id),HttpStatus.OK);
    }
}
