package com.epam.spring.framework.variant.timekeeping.domain;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name="States")
public class State {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(unique = true,nullable = false,name = "name")
    private String name;

    @Column(nullable = true,unique = false,name = "description")
    private String decription;

    public State() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decription='" + decription + '\'' +
                '}';
    }
}
