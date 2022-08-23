package com.epam.spring.framework.variant.timekeeping.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private float missingHours;

    @Column(nullable = false)
    private float completedHours;

    @Column(nullable = false)
    private float description;

    @ManyToOne(optional = false)
    private Client assignee;

    @ManyToOne(optional = false)
    private Category category;

    @ManyToOne(optional = false)
    private State state;

    public Activity() {
    }

    public Activity(int id, String name, Date startDate, Date endDate, float missingHours, float completedHours, float description) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return startDate;
    }

    public void setStart(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEnd() {
        return endDate;
    }

    public void setEnd(Date endDate) {
        this.endDate = endDate;
    }

    public float getMissingHours() {
        return missingHours;
    }

    public void setMissingHours(float missingHours) {
        this.missingHours = missingHours;
    }

    public float getCompletedHours() {
        return completedHours;
    }

    public void setCompletedHours(float completedHours) {
        this.completedHours = completedHours;
    }

    public float getDescription() {
        return description;
    }

    public void setDescription(float description) {
        this.description = description;
    }
}
