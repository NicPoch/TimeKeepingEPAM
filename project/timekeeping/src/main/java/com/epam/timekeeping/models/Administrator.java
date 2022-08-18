package com.epam.timekeeping.models;

import java.util.Objects;

public class Administrator {
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
        if (!(o instanceof Administrator)) return false;
        Administrator that = (Administrator) o;
        return getUser_id() == that.getUser_id();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_id());
    }
}
