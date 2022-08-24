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
    private String description;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Client assignee;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private State state;

    public Activity() {
    }

    public Activity(int id, String name, Date startDate, Date endDate, float missingHours, float completedHours, String description) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Client getAssignee() {
        return assignee;
    }

    public void setAssignee(Client assignee) {
        this.assignee = assignee;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
