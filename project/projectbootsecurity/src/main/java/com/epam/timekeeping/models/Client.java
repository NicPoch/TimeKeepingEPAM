package com.epam.timekeeping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Clients")
public class Client extends User{

    @Column(name="company",nullable = false)
    private String company;

    @OneToMany(orphanRemoval = true,mappedBy = "assignee")
    private Set<Activity> activities = new HashSet<>();

    @OneToMany(orphanRemoval = true,mappedBy = "client")
    private Set<Timecard> timecards = new HashSet<>();

    @OneToMany(orphanRemoval = true,mappedBy = "client")
    private Set<Request> requests = new HashSet<>();

}
