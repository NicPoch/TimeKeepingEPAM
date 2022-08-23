package com.epam.spring.framework.variant.timekeeping.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Clients")
public class Client extends User{

    @Column(name="company",unique = false,nullable = false)
    private String company;

    public Client() {
        super();
    }

    public Client(int id, String name, String username, String password, String mail, String company) {
        super(id, name, username, password, mail);
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
