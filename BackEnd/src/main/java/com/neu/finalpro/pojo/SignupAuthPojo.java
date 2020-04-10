package com.neu.finalpro.pojo;

public class SignupAuthPojo {

    private String authority;
    private SignupUserPojo signupUserPojo;

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public SignupUserPojo getSignupUserPojo() {
        return signupUserPojo;
    }

    public void setSignupUserPojo(SignupUserPojo signupUserPojo) {
        this.signupUserPojo = signupUserPojo;
    }
}
