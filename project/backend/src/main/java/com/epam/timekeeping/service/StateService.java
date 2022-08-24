package com.epam.timekeeping.service;

import com.epam.timekeeping.domain.State;
import com.epam.timekeeping.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {
    @Autowired
    StateRepository stateRepository;

    public State getStateById(Integer id)
    {
        return  stateRepository.findOne(id);
    }
    public List<State> getStates(){
        List<State> states = new ArrayList<>();
        stateRepository.findAll().forEach(states::add);
        return states;
    }
    public void saveOrUpdateState(State state){
        stateRepository.save(state);
    }
    public void deleteState(Integer id){
        stateRepository.delete(id);
    }
}
