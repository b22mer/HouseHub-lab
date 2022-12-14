package com.ssafy.home.member.dto;


public class Member {
    private String name;
    private String position;
    private String id;
    private String pw;
    private String email;
    private String phoneNumber;
    private int admin;

    public Member() {
    }

    public Member(String name, String position, String id, String pw, String email, String phoneNumber, int admin) {
        setName(name);
        setPosition(position);
        setId(id);
        setPw(pw);
        setEmail(email);
        setAdmin(admin);
        setPhoneNumber(phoneNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", admin=" + admin +
                '}';
    }
}
