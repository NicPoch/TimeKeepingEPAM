package com.epam.timekeeping.variant.boot.projectboot.controller;

import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardDetailDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardPostDto;
import com.epam.timekeeping.variant.boot.projectboot.service.TimecardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timecards")
public class TimecardController {
    Logger logger = LoggerFactory.getLogger(TimecardController.class);
    @Autowired
    private TimecardService timecardService;

    @GetMapping
    public ResponseEntity<List<TimecardDto>> getTimecards(){
        logger.info("Get all timecards");
        return new ResponseEntity<>(timecardService.getTimecards(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TimecardDetailDto> getTimecards(@PathVariable int id){
        logger.info("Get timecard with id: "+id);
        return new ResponseEntity<>(timecardService.getTimecardById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<TimecardDetailDto> postTimecard(@RequestBody TimecardPostDto timecard){
        logger.info("Posting new timecard");
        return new ResponseEntity<>(timecardService.postTimecard(timecard),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<TimecardDetailDto> updateTimecard(@PathVariable int id,@RequestBody TimecardPostDto newTimecard){
        logger.info("Put request for timecard with id: "+id);
        return new ResponseEntity<>(timecardService.updateTimecard(newTimecard,id),HttpStatus.ACCEPTED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<TimecardDetailDto> deleteTimecard(@PathVariable int id){
        logger.info("Delete timecard with id: "+id);
        return new ResponseEntity<>(timecardService.deleteTimecard(id),HttpStatus.OK);
    }
}
