package com.epam.timekeeping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
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

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client assignee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_id", nullable = false)
    private State state;

    @OneToMany(orphanRemoval = true,mappedBy = "activity")
    private Set<Timecard> timecards = new HashSet<>();

    @OneToMany(orphanRemoval = true,mappedBy = "activity")
    private Set<Request> requests = new HashSet<>();

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", missingHours=" + missingHours +
                ", completedHours=" + completedHours +
                ", description='" + description + '\'' +
                ", assignee=" + assignee +
                ", category=" + category +
                ", state=" + state +
                ", timecards=" + timecards +
                ", requests=" + requests +
                '}';
    }
}
