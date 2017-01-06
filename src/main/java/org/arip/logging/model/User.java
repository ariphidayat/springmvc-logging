package org.arip.logging.model;

import javax.persistence.*;

/**
 * Created by Arip Hidayat on 12/9/2015.
 */
@Entity
public class User {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String address;

    public User() {}

    public User(String id, String name, String username, String email, String address) {
        this.id = id;
        this.name = name;
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
