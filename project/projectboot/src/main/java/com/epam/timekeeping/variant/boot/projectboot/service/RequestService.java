package com.epam.timekeeping.variant.boot.projectboot.service;

import com.epam.timekeeping.variant.boot.projectboot.domain.Activity;
import com.epam.timekeeping.variant.boot.projectboot.domain.Client;
import com.epam.timekeeping.variant.boot.projectboot.domain.Request;
import com.epam.timekeeping.variant.boot.projectboot.dto.request.RequestDetailDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.request.RequestDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.request.RequestPostDto;
import com.epam.timekeeping.variant.boot.projectboot.exception.activity.ActivityNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.client.ClientNotFound;
import com.epam.timekeeping.variant.boot.projectboot.exception.request.RequestIncorrectFormat;
import com.epam.timekeeping.variant.boot.projectboot.exception.request.RequestNotFound;
import com.epam.timekeeping.variant.boot.projectboot.repository.ActivityRepository;
import com.epam.timekeeping.variant.boot.projectboot.repository.ClientRepository;
import com.epam.timekeeping.variant.boot.projectboot.repository.RequestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RequestService {
    private final Set<String> TYPES = new HashSet<>(new ArrayList<>(){{
        add("Create");
        add("Kill");
    }});

    @Autowired
    ModelMapper mapper;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    ClientRepository clientRepository;

    public RequestDetailDto getRequestById(Integer id) throws RequestNotFound{
        return mapper.map(requestRepository.findById(id).orElseThrow(()->new RequestNotFound(id)),RequestDetailDto.class);
    }
    public List<RequestDto> getRequests(){
        List<RequestDto> resp = new ArrayList<>();
        requestRepository.findAll().forEach(r->resp.add(mapper.map(r,RequestDto.class)));
        return resp;
    }
    public RequestDetailDto postRequest(RequestPostDto dto)throws RequestIncorrectFormat, ClientNotFound, ActivityNotFound {
        Client client = clientRepository.findById(dto.getClient()).orElseThrow(()->new ClientNotFound(dto.getClient()));
        Activity activity= activityRepository.findById(dto.getActivity()).orElseThrow(()->new ActivityNotFound(dto.getActivity()));
        List<String> errors = new ArrayList<>();
        if(!TYPES.contains(dto.getType())) errors.add("Incorrect type");
        if(errors.size()>0) throw new RequestIncorrectFormat(errors);
        Request request = new Request();
        request.setActivity(activity);
        request.setClient(client);
        request.setType(dto.getType());
        return mapper.map(requestRepository.save(request),RequestDetailDto.class);
    }
    public RequestDetailDto updateRequest(RequestPostDto dto,Integer id)throws RequestIncorrectFormat, ClientNotFound, ActivityNotFound, RequestNotFound{
        Request request = requestRepository.findById(id).orElseThrow(()->new RequestNotFound(id));

        List<String> errors = new ArrayList<>();
        if(!TYPES.contains(dto.getType())) errors.add("Incorrect type");
        if(errors.size()>0) throw new RequestIncorrectFormat(errors);

        request.setActivity((dto.getActivity()==null)?request.getActivity():activityRepository.findById(dto.getActivity()).orElseThrow(()->new ActivityNotFound(dto.getActivity())));
        request.setClient((dto.getClient()==null)?request.getClient():clientRepository.findById(dto.getClient()).orElseThrow(()->new ClientNotFound(dto.getClient())));
        request.setType(dto.getType());
        return mapper.map(requestRepository.save(request),RequestDetailDto.class);
    }
    public RequestDetailDto deleteRequest(Integer id)throws RequestNotFound{
        Request request = requestRepository.findById(id).orElseThrow(()->new RequestNotFound(id));
        requestRepository.delete(request);
        return mapper.map(request,RequestDetailDto.class);
    }
}
