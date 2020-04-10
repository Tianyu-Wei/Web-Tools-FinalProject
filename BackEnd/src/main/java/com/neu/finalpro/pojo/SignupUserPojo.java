package com.neu.finalpro.pojo;

import java.util.HashSet;
import java.util.Set;

public class SignupUserPojo {

    private String username;
    private String password;
    private boolean enabled;
    private Set<SignupAuthPojo> authorities = new HashSet<>();

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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<SignupAuthPojo> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<SignupAuthPojo> authorities) {
        this.authorities = authorities;
    }
}
