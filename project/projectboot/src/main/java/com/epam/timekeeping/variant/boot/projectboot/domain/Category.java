package com.epam.timekeeping.variant.boot.projectboot.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(orphanRemoval = true,cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.LAZY)
    private Set<Activity> activities=new HashSet<>();

    public Category(Integer id, String name, String description, Set<Activity> activities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", decription='" + description + '\'' +
                '}';
    }
}
