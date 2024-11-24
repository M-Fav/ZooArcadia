package com.ZooArcadia.ZooArcadia.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Utilisateur {

    @Id
    private long userName;
    private String password;
    private String name;
    private String firstName;

    public Utilisateur() {}

    public Utilisateur(String password, String name, String firstName) {
        this.password = password;
        this.name = name;
        this.firstName = firstName;
    }

    public long getUserName() {
        return userName;
    }

    public void setUserName(long userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
