package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
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
