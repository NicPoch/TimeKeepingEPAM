package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Activity;
import com.epam.timekeeping.variant.boot.projectboot.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    @Autowired
    ActivityRepository activityRepository;

    public Activity getActivityById(Integer id)
    {
        return  activityRepository.findById(id).get();
    }

    public List<Activity> getActivities(){
        List<Activity> activities = new ArrayList<>();
        activityRepository.findAll().forEach(activities::add);
        return activities;
    }

    public void saveOrUpdateActivity(Activity activity){
        activityRepository.save(activity);
    }

    public void deleteActivity(Integer id){
        activityRepository.deleteById(id);
    }
}
