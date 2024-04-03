package com.example.asignment_restapi.Model;

public class USER {
    private String hoten;
    private String phone;
    private String email;
    private String pass;

    public USER(String hoten, String phone, String email, String pass) {
        this.hoten = hoten;
        this.phone = phone;
        this.email = email;
        this.pass = pass;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
