package com.epam.timekeeping.models;

import java.util.Objects;

public class Client {
    private int id;
    private int user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getUser_id() == client.getUser_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id());
    }
}
