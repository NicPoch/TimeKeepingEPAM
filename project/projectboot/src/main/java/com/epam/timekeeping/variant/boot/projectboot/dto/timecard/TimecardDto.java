package com.epam.timekeeping.variant.boot.projectboot.dto.timecard;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TimecardDto implements Serializable {
    private Integer id;
    private String title;
    private String comment;
    private float hours;
    private Date timestamp;
}
