package com.example.fragapp.models;

public class User {

    private String email;
    private String pass;
    private String phone;
    private String age;

    public User(){

    }

    public User(String email, String pass, String phone, String age) {
        this.email = email;
        this.pass = pass;
        this.phone = phone;
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getPhone() {
        return phone;
    }

    public String getAge() {
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
