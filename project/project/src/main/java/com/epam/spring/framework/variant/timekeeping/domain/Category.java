package com.epam.spring.framework.variant.timekeeping.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.EAGER)
    private List<Activity> activities=new ArrayList<>();

    public Category() {
        super();
    }

    public Category(Integer id, String name, String description, List<Activity> activities) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decription='" + description + '\'' +
                '}';
    }
}
