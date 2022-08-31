package com.epam.timekeeping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(orphanRemoval = true,mappedBy = "category")
    private Set<Activity> activities=new HashSet<>();

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decription='" + description + '\'' +
                '}';
    }
}
