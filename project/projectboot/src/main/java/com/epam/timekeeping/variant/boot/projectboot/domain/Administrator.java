package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Administrators")
public class Administrator extends User {
    @Column(nullable = false,name = "role")
    private String role;
}
