package com.epam.timekeeping.variant.boot.projectboot.dto.activity;

import com.epam.timekeeping.variant.boot.projectboot.dto.category.CategoryDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.client.ClientDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.state.StateDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActivityPostDto implements Serializable {
    private  Integer id;
    private  String name;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private  Date startDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private  Date endDate;
    private  Float missingHours;
    private  Float completedHours;
    private  String description;
    private Integer assignee;
    private Integer category;
    private Integer state;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityPostDto entity = (ActivityPostDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.startDate, entity.startDate) &&
                Objects.equals(this.endDate, entity.endDate) &&
                Objects.equals(this.missingHours, entity.missingHours) &&
                Objects.equals(this.completedHours, entity.completedHours) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.assignee, entity.assignee) &&
                Objects.equals(this.category, entity.category) &&
                Objects.equals(this.state, entity.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, missingHours, completedHours, description, assignee, category, state);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "startDate = " + startDate + ", " +
                "endDate = " + endDate + ", " +
                "missingHours = " + missingHours + ", " +
                "completedHours = " + completedHours + ", " +
                "description = " + description + ", " +
                "assignee = " + assignee + ", " +
                "category = " + category + ", " +
                "state = " + state + ")";
    }
}
