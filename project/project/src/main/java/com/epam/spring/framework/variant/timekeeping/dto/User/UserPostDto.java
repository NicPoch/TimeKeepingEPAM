package com.epam.spring.framework.variant.timekeeping.dto.User;

import java.io.Serializable;
import java.util.Objects;

public class UserPostDto implements Serializable {
    private int id;
    private String name;
    private String username;
    private String password;
    private String mail;

    public UserPostDto() {
    }

    public UserPostDto(int id, String name, String username, String password, String mail) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return password;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPostDto entity = (UserPostDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.password, entity.password) &&
                Objects.equals(this.mail, entity.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, mail);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "username = " + username + ", " +
                "password = " + password + ", " +
                "mail = " + mail + ")";
    }
}
