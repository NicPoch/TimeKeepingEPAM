package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardDetailDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardPostDto;
import com.epam.timekeeping.variant.boot.projectboot.service.TimecardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timecards")
public class TimecardController {
    @Autowired
    private TimecardService timecardService;

    @GetMapping
    public ResponseEntity<List<TimecardDto>> getTimecards(){
        return new ResponseEntity<>(timecardService.getTimecards(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TimecardDetailDto> getTimecards(@PathVariable int id){
        return new ResponseEntity<>(timecardService.getTimecardById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TimecardDetailDto> postTimecard(@RequestBody TimecardPostDto timecard){
        return new ResponseEntity<>(timecardService.postTimecard(timecard),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<TimecardDetailDto> updateTimecard(@PathVariable int id,@RequestBody TimecardPostDto newTimecard){
        return new ResponseEntity<>(timecardService.updateTimecard(newTimecard,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TimecardDetailDto> deleteTimecard(@PathVariable int id){
        return new ResponseEntity<>(timecardService.deleteTimecard(id),HttpStatus.OK);
    }
}
