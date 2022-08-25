package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Date;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Float missingHours;

    @Column(nullable = false)
    private Float completedHours;

    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Client assignee;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Category category;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private State state;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "activity",fetch = FetchType.EAGER)
    private Set<Timecard> timecards = new HashSet<>();

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "activity",fetch = FetchType.EAGER)
    private Set<Request> requests = new HashSet<>();


    public Activity(Integer id, String name, Date startDate, Date endDate, Float missingHours, Float completedHours, String description) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.missingHours = missingHours;
        this.completedHours = completedHours;
        this.description = description;
    }
}
