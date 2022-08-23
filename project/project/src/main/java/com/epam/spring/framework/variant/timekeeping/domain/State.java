package com.epam.spring.framework.variant.timekeeping.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="States")
public class State{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String decription;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.PERSIST,mappedBy = "state")
    private List<Activity> activities;

    public State() {
        super();
    }

    public State(Integer id, String name, String decription, List<Activity> activities) {
        this.id = id;
        this.name = name;
        this.decription = decription;
        this.activities = activities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decription='" + decription + '\'' +
                '}';
    }
}
