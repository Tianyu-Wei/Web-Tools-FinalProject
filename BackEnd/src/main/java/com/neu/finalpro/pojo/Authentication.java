package com.neu.finalpro.pojo;

import java.util.Set;

public class Authentication {

    private int userid;
    private String password;
    private boolean auth;
    private String ssid;
    private Set<AuthDetail> authDetails;

    public Authentication() {
    }

    public Set<AuthDetail> getAuthDetails() {
        return authDetails;
    }

    public void setAuthDetails(Set<AuthDetail> authDetails) {
        this.authDetails = authDetails;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }
}
