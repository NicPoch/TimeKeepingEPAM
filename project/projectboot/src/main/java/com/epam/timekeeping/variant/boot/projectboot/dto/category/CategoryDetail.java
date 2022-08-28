package com.epam.timekeeping.variant.boot.projectboot.dto.category;

import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDetail implements Serializable {
    public  Integer id;
    public  String name;
    public  String description;
    public  List<ActivityDto> activities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryDetail entity = (CategoryDetail) o;
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
