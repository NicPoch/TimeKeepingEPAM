package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.State;
import com.epam.timekeeping.variant.boot.projectboot.dto.state.StateDetail;
import com.epam.timekeeping.variant.boot.projectboot.dto.state.StateDto;
import com.epam.timekeeping.variant.boot.projectboot.exception.state.StateIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.state.StateNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.user.UserNotFound;
import com.epam.timekeeping.variant.boot.projectboot.repository.StateRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {

    Logger logger = LoggerFactory.getLogger(StateService.class);
    @Autowired
    StateRepository stateRepository;

    @Autowired
    ModelMapper mapper;

    public StateDetail getStateById(Integer id) throws StateNotFound
    {
        logger.info("Getting all states");
        return  mapper.map(stateRepository.findById(id).orElseThrow(()->new StateNotFound(id)),StateDetail.class);
    }
    public List<StateDto> getStates(){
        List<StateDto> states = new ArrayList<>();
        stateRepository.findAll().forEach(s->states.add(mapper.map(s,StateDto.class)));
        return states;
    }

    public StateDetail createState(StateDto dto)throws StateIncorrectFormat {
        List<String> errors = new ArrayList<>();
        if(dto.getName()==null || dto.getName().trim().length()==0) errors.add("Empty name");

        if(errors.size()>0) throw new StateIncorrectFormat(errors);
        return mapper.map(stateRepository.save(mapper.map(dto,State.class)),StateDetail.class);
    }

    public StateDetail updateState(StateDto dto,Integer id)throws StateNotFound{
        State state = stateRepository.findById(id).orElseThrow(()->new StateNotFound(id));
        state.setName((dto.getName()==null)?state.getName():dto.getName());
        state.setDescription((dto.getDescription()==null)?state.getDescription():dto.getDescription());

        return mapper.map(stateRepository.save(state),StateDetail.class);
    }

    public StateDetail deleteState(Integer id)throws StateNotFound{
        State state = stateRepository.findById(id).orElseThrow(()->new StateNotFound(id));
        stateRepository.deleteById(id);
        return mapper.map(state,StateDetail.class);
    }
}
