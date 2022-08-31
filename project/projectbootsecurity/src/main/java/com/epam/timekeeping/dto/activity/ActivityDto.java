package com.epam.timekeeping.dto.activity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto implements Serializable {
    private int id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endDate;
    private float missingHours;
    private float completedHours;
    private String description;
}
