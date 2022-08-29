package com.epam.timekeeping.variant.boot.projectboot.dto.activity;

import com.epam.timekeeping.variant.boot.projectboot.dto.category.CategoryDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.request.RequestDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.state.StateDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.timecard.TimecardDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActivityDetailDto implements Serializable {
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;
    private Float missingHours;
    private Float completedHours;
    private String description;
    private ClientDto assignee;
    private CategoryDto category;
    private StateDto state;
    private Set<TimecardDto> timecards = new HashSet<>();
    private Set<RequestDto> requests = new HashSet<>();
}
