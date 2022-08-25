package com.epam.timekeeping.variant.boot.projectboot.domain;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Requests")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Client client;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    private Activity activity;

    @Column(nullable = false)
    private String type;
}
