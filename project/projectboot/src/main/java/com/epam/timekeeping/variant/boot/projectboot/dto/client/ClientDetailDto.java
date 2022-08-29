package com.epam.timekeeping.variant.boot.projectboot.dto.client;


import com.epam.timekeeping.variant.boot.projectboot.dto.activity.ActivityDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetailDto implements Serializable {
    private int id;
    private String name;
    private String username;
    private String mail;
    private String company;
    private List<ActivityDto> activities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDetailDto entity = (ClientDetailDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.username, entity.username) &&
                Objects.equals(this.mail, entity.mail) &&
                Objects.equals(this.company, entity.company) &&
                Objects.equals(this.activities, entity.activities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, mail, company, activities);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "username = " + username + ", " +
                "mail = " + mail + ", " +
                "company = " + company + ", " +
                "activities = " + activities + ")";
    }

}
