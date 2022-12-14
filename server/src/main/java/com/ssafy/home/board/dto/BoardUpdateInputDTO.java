package com.ssafy.home.board.dto;


public class BoardUpdateInputDTO {
    private String code;
    private String title;
    private String content;

    public BoardUpdateInputDTO() {
    }

    public BoardUpdateInputDTO(String code, String title, String content) {
        setCode(code);
        setTitle(title);
        setContent(content);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
