package com.ssafy.home.favorite.dto;

public class FavoriteDTO {
    private String id;
    private String dongCode;

    public FavoriteDTO() {
    }

    public FavoriteDTO(String id, String dongCode) {
        this.id = id;
        this.dongCode = dongCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDongCode() {
        return dongCode;
    }

    public void setDongCode(String dongCode) {
        this.dongCode = dongCode;
    }
}
