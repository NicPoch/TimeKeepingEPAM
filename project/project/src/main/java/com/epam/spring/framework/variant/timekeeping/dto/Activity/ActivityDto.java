package com.epam.spring.framework.variant.timekeeping.dto.Activity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ActivityDto implements Serializable {
    private final int id;
    private final String name;
    private final Date startDate;
    private final Date endDate;
    private final float missingHours;
    private final float completedHours;
    private final String description;

    public ActivityDto(int id, String name, Date startDate, Date endDate, float missingHours, float completedHours, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.missingHours = missingHours;
        this.completedHours = completedHours;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityDto entity = (ActivityDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.startDate, entity.startDate) &&
                Objects.equals(this.endDate, entity.endDate) &&
                Objects.equals(this.missingHours, entity.missingHours) &&
                Objects.equals(this.completedHours, entity.completedHours) &&
                Objects.equals(this.description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, startDate, endDate, missingHours, completedHours, description);
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
                "description = " + description + ")";
    }
}
