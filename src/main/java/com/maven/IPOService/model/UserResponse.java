package com.maven.IPOService.model;

import java.io.Serializable;

/**
 * UserResponse class is used to map the User Response for Create USer api.
 *
 */
public class UserResponse implements Serializable {
    private Long id ;

    private String username;

    private String email;

    private String phonenumber;

    public UserResponse(Long id, String username, String email, String phonenumber) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phonenumber = phonenumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
