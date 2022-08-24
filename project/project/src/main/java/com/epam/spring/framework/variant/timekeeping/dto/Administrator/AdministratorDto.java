package com.epam.spring.framework.variant.timekeeping.dto.Administrator;

import java.io.Serializable;
import java.util.Objects;

public class AdministratorDto implements Serializable {
    private final int id;
    private final String name;
    private final String username;
    private final String mail;
    private final String role;

    public AdministratorDto(int id, String name, String username, String mail, String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.mail = mail;
        this.role = role;
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

    public String getMail() {
        return mail;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdministratorDto entity = (AdministratorDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.mail, entity.mail) &&
                Objects.equals(this.role, entity.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, mail, role);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "username = " + username + ", " +
                "mail = " + mail + ", " +
                "role = " + role + ")";
    }
}
