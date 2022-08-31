package com.epam.timekeeping.dto.category;

import com.epam.timekeeping.dto.activity.ActivityDto;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetail implements Serializable {
    public  Integer id;
    public  String name;
    public  String description;
    public  List<ActivityDto> activities;
}
