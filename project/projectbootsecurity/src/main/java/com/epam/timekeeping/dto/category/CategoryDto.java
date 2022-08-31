package com.epam.timekeeping.dto.category;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto implements Serializable {
    private Integer id;
    private String name;
    private String description;

}
