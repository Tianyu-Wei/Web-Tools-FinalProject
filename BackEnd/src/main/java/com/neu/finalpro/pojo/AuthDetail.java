package com.neu.finalpro.pojo;

public class AuthDetail {

    private int id;
    private int userid;
    private String joinid;
    private String date;
    private Authentication authentication;

    public AuthDetail() {
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getJoinid() {
        return joinid;
    }

    public void setJoinid(String joinid) {
        this.joinid = joinid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
