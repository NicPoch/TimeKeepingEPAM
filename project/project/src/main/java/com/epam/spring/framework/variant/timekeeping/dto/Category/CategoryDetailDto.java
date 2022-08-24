package com.epam.spring.framework.variant.timekeeping.dto.Category;

import com.epam.spring.framework.variant.timekeeping.dto.Activity.ActivityDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class CategoryDetailDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String description;
    private final List<ActivityDto> activities;

    public CategoryDetailDto(Integer id, String name, String description, List<ActivityDto> activities) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDetailDto entity = (CategoryDetailDto) o;
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
