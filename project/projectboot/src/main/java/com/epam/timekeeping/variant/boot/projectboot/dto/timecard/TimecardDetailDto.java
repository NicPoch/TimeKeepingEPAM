package com.epam.timekeeping.variant.boot.projectboot.dto.timecard;

import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TimecardDetailDto implements Serializable {
    private Integer id;
    private ClientDto client;
    private ActivityDto activity;
    private String title;
    private String comment;
    private Float hours;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date timestamp;
}
