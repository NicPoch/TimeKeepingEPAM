package com.epam.timekeeping.variant.boot.projectboot.dto.Activity;

import com.epam.timekeeping.variant.boot.projectboot.dto.Category.CategoryDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.Client.ClientDto;
import com.epam.timekeeping.variant.boot.projectboot.dto.State.StateDto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ActivityDetailDto implements Serializable {
    private final int id;
    private final String name;
    private final Date startDate;
    private final Date endDate;
    private final float missingHours;
    private final float completedHours;
    private final String description;
    private final ClientDto assignee;
    private final CategoryDto category;
    private final StateDto state;

    public ActivityDetailDto(int id, String name, Date startDate, Date endDate, float missingHours, float completedHours, String description, ClientDto assignee, CategoryDto category, StateDto state) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.missingHours = missingHours;
        this.completedHours = completedHours;
        this.description = description;
        this.assignee = assignee;
        this.category = category;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public float getMissingHours() {
        return missingHours;
    }

    public float getCompletedHours() {
        return completedHours;
    }

    public String getDescription() {
        return description;
    }

    public ClientDto getAssignee() {
        return assignee;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public StateDto getState() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityDetailDto entity = (ActivityDetailDto) o;
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
