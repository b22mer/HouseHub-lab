package com.ssafy.home.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;


public class LoginDTO {
    @Schema(name = "사용자 id", description = "사용자 id")
    private String id;
    @Schema(description = "사용자 비밀번호")
    private String pw;

    public LoginDTO() {
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }
}
