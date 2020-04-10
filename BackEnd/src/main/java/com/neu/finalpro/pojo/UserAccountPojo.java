package com.neu.finalpro.pojo;

import javax.persistence.*;

public class UserAccountPojo {
    private int id;

    private String username;

    private String password;

    private String email;

    private String recovemail;

    private String phone;

    public UserAccountPojo() {
    }

    public UserAccountPojo(int id, String username, String password, String email, String recovemail, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.recovemail = recovemail;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecovemail() {
        return recovemail;
    }

    public void setRecovemail(String recovemail) {
        this.recovemail = recovemail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
