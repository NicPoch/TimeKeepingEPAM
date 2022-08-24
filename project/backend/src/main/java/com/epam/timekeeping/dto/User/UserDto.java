package com.epam.timekeeping.dto.User;

import java.io.Serializable;
import java.util.Objects;

public class UserDto implements Serializable {
    private int id;
    private String name;
    private String username;
    private String mail;

    public UserDto() {
    }

    public UserDto(int id, String name, String username, String mail) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.mail = mail;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto entity = (UserDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.mail, entity.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, mail);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "username = " + username + ", " +
                "mail = " + mail + ")";
    }
}
