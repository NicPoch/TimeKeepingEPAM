package com.epam.timekeeping.models;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Administrators")
public class Administrator extends User {
    @Column(nullable = false,name = "role")
    private String role;
}
