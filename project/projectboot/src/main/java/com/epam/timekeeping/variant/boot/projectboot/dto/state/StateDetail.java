package com.epam.timekeeping.variant.boot.projectboot.dto.state;

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
public class StateDetail implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private List<ActivityDto> activities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateDetail entity = (StateDetail) o;
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
