package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.dto.request.RequestDetailDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.request.RequestDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.request.RequestPostDto;
import com.epam.timekeeping.variant.boot.projectboot.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @GetMapping
    public ResponseEntity<List<RequestDto>> getRequests(){
        return new ResponseEntity<>(requestService.getRequests(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<RequestDetailDto> getRequests(@PathVariable int id){
        return new ResponseEntity<>(requestService.getRequestById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<RequestDetailDto> postRequest(@RequestBody RequestPostDto request){
        return new ResponseEntity<>(requestService.postRequest(request),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<RequestDetailDto> updateRequest(@PathVariable int id,@RequestBody RequestPostDto newRequest){
        return new ResponseEntity<>(requestService.updateRequest(newRequest,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<RequestDetailDto> deleteRequest(@PathVariable int id){
        return new ResponseEntity<>(requestService.deleteRequest(id),HttpStatus.OK);
    }
}
