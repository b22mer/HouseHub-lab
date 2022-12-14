package com.ssafy.home.realestate.model.dto;

public class RealEstateDTO {
    private String imgUrl;
    private String newsUrl;
    private String title;
    private String preview;

    public RealEstateDTO() {
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    @Override
    public String toString() {
        return "RealEstateDTO{" +
                "imgUrl='" + imgUrl + '\'' +
                ", newsUrl='" + newsUrl + '\'' +
                ", title='" + title + '\'' +
                ", preview='" + preview + '\'' +
                '}';
    }
}
