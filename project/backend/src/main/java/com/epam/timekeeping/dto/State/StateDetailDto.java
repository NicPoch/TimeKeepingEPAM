package com.epam.timekeeping.dto.State;

import com.epam.timekeeping.dto.Activity.ActivityDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class StateDetailDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private List<ActivityDto> activities;

    public StateDetailDto() {
    }

    public StateDetailDto(Integer id, String name, String description, List<ActivityDto> activities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.activities = activities;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<ActivityDto> getActivities() {
        return activities;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActivities(List<ActivityDto> activities) {
        this.activities = activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateDetailDto entity = (StateDetailDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.activities, entity.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, activities);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "activities = " + activities + ")";
    }
}
