package com.epam.spring.framework.variant.timekeeping.dto.Client;

import com.epam.spring.framework.variant.timekeeping.dto.Activity.ActivityDto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ClientDetailDto implements Serializable {
    private final int id;
    private final String name;
    private final String username;
    private final String password;
    private final String mail;
    private final String company;
    private final List<ActivityDto> activities;

    public ClientDetailDto(int id, String name, String username, String password, String mail, String company, List<ActivityDto> activities) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.company = company;
        this.activities = activities;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getCompany() {
        return company;
    }

    public List<ActivityDto> getActivities() {
        return activities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDetailDto entity = (ClientDetailDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.mail, entity.mail) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.activities, entity.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, mail, company, activities);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "mail = " + mail + ", " +
                "company = " + company + ", " +
                "activities = " + activities + ")";
    }

}
