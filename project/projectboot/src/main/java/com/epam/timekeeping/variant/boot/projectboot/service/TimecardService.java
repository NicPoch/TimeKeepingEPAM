package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Activity;
import com.epam.timekeeping.variant.boot.projectboot.domain.Client;
import com.epam.timekeeping.variant.boot.projectboot.domain.Timecard;
import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardDetailDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardPostDto;
import com.epam.timekeeping.variant.boot.projectboot.exception.activity.ActivityNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.timecard.TimecardIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.timecard.TimecardNotFound;
import com.epam.timekeeping.variant.boot.projectboot.repository.ActivityRepository;
import com.epam.timekeeping.variant.boot.projectboot.repository.ClientRepository;
import com.epam.timekeeping.variant.boot.projectboot.repository.TimecardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimecardService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    TimecardRepository timecardRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    ClientRepository clientRepository;

    public TimecardDetailDto getTimecardById(Integer id) throws TimecardNotFound {
        return mapper.map(timecardRepository.findById(id).orElseThrow(()->new TimecardNotFound(id)),TimecardDetailDto.class);
    }
    public List<TimecardDto> getTimecards(){
        List<TimecardDto> resp = new ArrayList<>();
        timecardRepository.findAll().forEach(r->resp.add(mapper.map(r,TimecardDto.class)));
        return resp;
    }
    public TimecardDetailDto postTimecard(TimecardPostDto dto)throws TimecardIncorrectFormat, ClientNotFound, ActivityNotFound {
        Client client = clientRepository.findById(dto.getClient()).orElseThrow(()->new ClientNotFound(dto.getClient()));
        Activity activity= activityRepository.findById(dto.getActivity()).orElseThrow(()->new ActivityNotFound(dto.getActivity()));
        List<String> errors = new ArrayList<>();
        if(dto.getTitle()==null||dto.getTitle().trim().length()==0) errors.add("Incorrect title");
        if(dto.getTimestamp()==null) errors.add("No timestamp");
        if(dto.getHours()==null||dto.getHours()<=0||(activity.getMissingHours()-dto.getHours())<0) errors.add("Invalid hours");

        if(errors.size()>0) throw new TimecardIncorrectFormat(errors);

        activity.setMissingHours(activity.getMissingHours()-dto.getHours());
        activity.setCompletedHours(activity.getCompletedHours()+ dto.getHours());
        activityRepository.save(activity);

        Timecard timecard = new Timecard();
        timecard.setActivity(activity);
        timecard.setClient(client);
        timecard.setTitle(dto.getTitle());
        timecard.setHours(dto.getHours());
        timecard.setComment(dto.getComment());
        timecard.setTimestamp(dto.getTimestamp());
        return mapper.map(timecardRepository.save(timecard),TimecardDetailDto.class);
    }
    public TimecardDetailDto updateTimecard(TimecardPostDto dto,Integer id)throws TimecardIncorrectFormat, ClientNotFound, ActivityNotFound, TimecardNotFound{
        Timecard timecard = timecardRepository.findById(id).orElseThrow(()->new TimecardNotFound(id));
        Client client = clientRepository.findById(dto.getClient()).orElseThrow(()->new ClientNotFound(dto.getClient()));
        Activity activity= activityRepository.findById(dto.getActivity()).orElseThrow(()->new ActivityNotFound(dto.getActivity()));

        List<String> errors = new ArrayList<>();
        if(dto.getTitle()==null||dto.getTitle().trim().length()==0) errors.add("Incorrect title");
        if(dto.getTimestamp()==null) errors.add("No timestamp");
        if(dto.getHours()==null||dto.getHours()<=0||(activity.getMissingHours()-dto.getHours())<0) errors.add("Invalid hours");

        if(errors.size()>0) throw new TimecardIncorrectFormat(errors);

        activity.setMissingHours((activity.getMissingHours()+ timecard.getHours())-dto.getHours());
        activity.setCompletedHours((activity.getCompletedHours()- timecard.getHours())+ dto.getHours());
        activityRepository.save(activity);

        timecard.setActivity(activity);
        timecard.setClient(client);
        timecard.setTitle(dto.getTitle());
        timecard.setHours(dto.getHours());
        timecard.setComment(dto.getComment());
        timecard.setTimestamp(dto.getTimestamp());
        return mapper.map(timecardRepository.save(timecard),TimecardDetailDto.class);
    }
    public TimecardDetailDto deleteTimecard(Integer id)throws TimecardNotFound{
        Timecard timecard = timecardRepository.findById(id).orElseThrow(()->new TimecardNotFound(id));
        timecardRepository.delete(timecard);
        return mapper.map(timecard,TimecardDetailDto.class);
    }
}
