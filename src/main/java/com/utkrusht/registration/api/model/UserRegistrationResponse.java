package com.utkrusht.registration.api.model;

public class UserRegistrationResponse {
    private Long id;
    private String email;
    private String status;

    public UserRegistrationResponse(Long id, String email, String status) {
        this.id = id;
        this.email = email;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}