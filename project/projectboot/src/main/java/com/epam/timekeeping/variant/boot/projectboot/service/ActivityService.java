package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Activity;
import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityDetailDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityPostDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityDto;
import com.epam.timekeeping.variant.boot.projectboot.exception.activity.ActivityIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.activity.ActivityNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.activity.IncorrectActivitySort;
import com.epam.timekeeping.variant.boot.projectboot.exception.category.CategoryNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.state.StateNotFound;
import com.epam.timekeeping.variant.boot.projectboot.repository.ActivityRepository;
import com.epam.timekeeping.variant.boot.projectboot.repository.CategoryRepository;
import com.epam.timekeeping.variant.boot.projectboot.repository.ClientRepository;
import com.epam.timekeeping.variant.boot.projectboot.repository.StateRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ActivityService {
    private final Set<String> SORT_VALUES= new HashSet<>(Arrays.asList("name","category","user",null));
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    ActivityRepository activityRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public ActivityDetailDto getActivityById(Integer id) throws ActivityNotFound
    {
        return  modelMapper.map(activityRepository.findById(id).orElseThrow(()->new ActivityNotFound(id)), ActivityDetailDto.class);
    }

    public List<ActivityDto> getActivities(String sort)throws IncorrectActivitySort{
        if(!SORT_VALUES.contains(sort)) throw new IncorrectActivitySort(sort);
        List<ActivityDto> activities = new ArrayList<>();
        activityRepository.findAll((sort==null) ? Sort.by("id").ascending():Sort.by(sort).ascending()).forEach(a->activities.add(modelMapper.map(a,ActivityDto.class)));
        return activities;
    }

    public ActivityDetailDto updateActivity(Integer id, ActivityPostDto dto)throws ActivityNotFound, StateNotFound, ClientNotFound, CategoryNotFound {
        Activity activity = activityRepository.findById(id).orElseThrow(()-> new ActivityNotFound(id));
        activity.setState((dto.getState()==null)?activity.getState():stateRepository.findById(dto.getState()).orElseThrow(()->new StateNotFound(dto.getState())));
        activity.setDescription((dto.getDescription()==null)?activity.getDescription():dto.getDescription());
        activity.setCategory((dto.getCategory()==null)?activity.getCategory():categoryRepository.findById(dto.getCategory()).orElseThrow(()->new CategoryNotFound(dto.getCategory())));
        activity.setName((dto.getName()==null)?activity.getName():dto.getName());
        activity.setMissingHours((dto.getMissingHours()==null)?activity.getMissingHours():dto.getMissingHours());
        activity.setCompletedHours((dto.getCompletedHours()==null)?activity.getCompletedHours():dto.getCompletedHours());
        activity.setEndDate((dto.getEndDate()==null)?activity.getEndDate():dto.getEndDate());
        activity.setAssignee((dto.getAssignee()==null)?activity.getAssignee():clientRepository.findById(dto.getAssignee()).orElseThrow(()->new ClientNotFound(dto.getAssignee())));
        activity.setCompletedHours((dto.getCompletedHours()==null)?activity.getCompletedHours():dto.getCompletedHours());
        activity.setStartDate((dto.getStartDate()==null)?activity.getStartDate():dto.getStartDate());

        return modelMapper.map(activityRepository.save(activity),ActivityDetailDto.class);
    }

    public ActivityDetailDto createActivity(ActivityPostDto activity)throws ActivityIncorrectFormat{
        System.out.println(activity);
        List<String> errors = new ArrayList<>();
        if(activity.getId()==null) errors.add("Empty id");
        if(activity.getName()==null || activity.getName().trim().length()==0) errors.add("Empty name");
        if(activity.getCompletedHours()==null) errors.add("Completed hours null");
        else if (activity.getCompletedHours()<0) errors.add("Negative completed hours");
        if(activity.getEndDate()==null||activity.getStartDate()==null) errors.add("Null date found");
        else if (activity.getEndDate().compareTo(activity.getStartDate())<=0) errors.add("Non valid dates");
        if(activity.getAssignee()==null) errors.add("No Assignee");
        if(activity.getMissingHours()==null || activity.getMissingHours()<0) errors.add("Incorrect missing hours input");
        if(activity.getCategory()==null) errors.add("No category attached");
        if(activity.getState()==null) errors.add("No state attached");

        if(errors.size()>0) throw new ActivityIncorrectFormat(errors);

        Activity entity = new Activity();
        entity.setName(activity.getName());
        entity.setDescription(activity.getDescription());
        entity.setEndDate(activity.getEndDate());
        entity.setStartDate(activity.getStartDate());
        entity.setMissingHours(activity.getMissingHours());
        entity.setCompletedHours(activity.getCompletedHours());
        entity.setAssignee(clientRepository.findById(activity.getAssignee()).get());
        entity.setCategory(categoryRepository.findById(activity.getCategory()).get());
        entity.setState(stateRepository.findById(activity.getState()).get());

        return modelMapper.map(activityRepository.save(entity), ActivityDetailDto.class);
    }

    public ActivityDetailDto deleteActivity(Integer id)throws ActivityNotFound{
        Activity activity = activityRepository.findById(id).orElseThrow(()->new ActivityNotFound(id));
        activityRepository.delete(activity);
        return modelMapper.map(activity,ActivityDetailDto.class);
    }
}
