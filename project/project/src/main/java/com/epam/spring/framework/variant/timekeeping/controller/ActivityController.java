package com.epam.spring.framework.variant.timekeeping.controller;

import com.epam.spring.framework.variant.timekeeping.domain.Activity;
import com.epam.spring.framework.variant.timekeeping.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping
    public List<Activity> getActivity(){
        return activityService.getActivities();
    }

    @GetMapping(value = "/{id}")
    public Activity getActivity(@PathVariable int id){
        return activityService.getActivityById(id);
    }

    @PostMapping
    public Activity postActivities(@RequestBody Activity activity){
        activityService.saveOrUpdateActivity(activity);
        return activity;
    }

    @PutMapping(value = "/{id}")
    public Activity updateActivity(@PathVariable int id,@RequestBody Activity newActivity){
        Activity activity = this.activityService.getActivityById(id);
        if(activity!=null) activityService.saveOrUpdateActivity(newActivity);
        return newActivity;
    }

    @DeleteMapping(value = "/{id}")
    public Activity deleteActivity(@PathVariable int id){
        Activity activity = activityService.getActivityById(id);
        if(activity!=null) activityService.deleteActivity(id);
        return activity;
    }
}
