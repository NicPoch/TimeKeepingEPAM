package com.epam.spring.framework.variant.timekeeping.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Administrators")
public class Administrator extends User {
    @Column(nullable = false,name = "role")
    private String role;

    public Administrator() {
        super();
    }

    public Administrator(int id, String name, String username, String password, String mail, String role) {
        super(id, name, username, password, mail);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
