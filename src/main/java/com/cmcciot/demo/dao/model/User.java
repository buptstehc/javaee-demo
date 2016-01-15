package com.cmcciot.demo.dao.model;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class User extends BasePO implements Serializable{
    private Integer id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}