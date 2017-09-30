package com.easyloan.dto;

public class UserDto {
    private String username;
    private String password;
    private String verification_code;
    private String session_verification_code;

    public UserDto() {
    }

    public String getSession_verification_code() {
        return session_verification_code;
    }

    public void setSession_verification_code(String session_verification_code) {
        this.session_verification_code = session_verification_code;
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

    public String getVerification_code() {
        return verification_code;
    }

    public void setVerification_code(String verification_code) {
        this.verification_code = verification_code;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verification_code='" + verification_code + '\'' +
                ", session_verification_code='" + session_verification_code + '\'' +
                '}';
    }

    public UserDto(String username, String password, String verification_code, String session_verification_code) {
        this.username = username;
        this.password = password;
        this.verification_code = verification_code;
        this.session_verification_code = session_verification_code;
    }




}
