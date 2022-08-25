package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Administrators")
public class Administrator extends User {
    @Column(nullable = false,name = "role")
    private String role;

    public Administrator(Integer id, String name, String username, String password, String mail, String role) {
        super(id, name, username, password, mail);
        this.role = role;
    }
}
