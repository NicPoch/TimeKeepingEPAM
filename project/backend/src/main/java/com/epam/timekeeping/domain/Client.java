package com.epam.timekeeping.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Clients")
public class Client extends User{

    @Column(name="company",unique = false,nullable = false)
    private String company;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "assignee",fetch = FetchType.EAGER)
    private List<Activity> activities = new ArrayList<>();

    public Client() {
        super();
    }

    public Client(int id, String name, String username, String password, String mail, String company, List<Activity> activities) {
        super(id, name, username, password, mail);
        this.company = company;
        this.activities = activities;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
