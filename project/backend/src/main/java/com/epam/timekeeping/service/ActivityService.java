package com.epam.timekeeping.service;

import com.epam.timekeeping.domain.Activity;
import com.epam.timekeeping.repository.ActivityRepository;
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
        return  activityRepository.findOne(id);
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
        activityRepository.delete(id);
    }
}
