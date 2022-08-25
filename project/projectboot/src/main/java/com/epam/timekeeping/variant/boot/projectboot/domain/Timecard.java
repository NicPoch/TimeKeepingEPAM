package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Timecards")
public class Timecard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Client client;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Activity activity;

    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String comment;

    @Column(nullable = false)
    private float hours;

    @Column(nullable = false)
    private Date timestamp;
}
