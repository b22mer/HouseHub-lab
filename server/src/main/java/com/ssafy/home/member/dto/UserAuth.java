package com.ssafy.home.member.dto;

public class UserAuth {
    private String id;
    private String name;
    private int admin;

    public UserAuth() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", admin=" + admin +
                '}';
    }
}
