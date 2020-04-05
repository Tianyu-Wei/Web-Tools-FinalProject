package com.neu.finalpro.pojo;

public class UserAccountPojo {
    private long id;
    private String username;
    private String token;
    private String password;
    private String email;
    private String recovemail;
    private String phone;

    public UserAccountPojo() {
    }

    public UserAccountPojo(long id, String username, String token, String password, String email, String recovemail, String phone) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.password = password;
        this.email = email;
        this.recovemail = recovemail;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
