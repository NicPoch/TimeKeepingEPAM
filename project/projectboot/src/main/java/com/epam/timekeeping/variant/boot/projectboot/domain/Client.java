package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Clients")
public class Client extends User{

    @Column(name="company",unique = false,nullable = false)
    private String company;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "assignee",fetch = FetchType.LAZY)
    private Set<Activity> activities = new HashSet<>();

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "client",fetch = FetchType.LAZY)
    private Set<Timecard> timecards = new HashSet<>();

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "client",fetch = FetchType.LAZY)
    private Set<Request> requests = new HashSet<>();


    public Client(Integer id, String name, String username, String password, String mail, String company, Set<Activity> activities) {
        super(id, name, username, password, mail);
        this.company = company;
        this.activities = activities;
    }
}
