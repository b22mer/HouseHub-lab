package com.ssafy.home.realestate.model.service;

import com.ssafy.home.realestate.model.dto.RealEstateDTO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RealEstateService {
    private static final String naverLand = "https://land.naver.com";

    public List<RealEstateDTO> getRealEstateNewsList(String date) {
        // 날짜 넣기 20221123 이런식으로 들어감
        String newsPage = "/news/headline.naver?bss_ymd=" + date;
        Connection conn = Jsoup.connect(naverLand + newsPage);
        try {
            System.out.println("crawling page url : " + newsPage);
            Document document = conn.get();
            return getNewsList(document);
        } catch (IOException e) {
            throw new RuntimeException("부동산 뉴스 정보 크롤링 실패");
        }

    }

    private static List<RealEstateDTO> getNewsList(Document document) {
        Elements list = document.select("ul.headline_list li dl");
        List<RealEstateDTO> realEstateDTOList = new ArrayList<>();
        int idx = 0;

        for (Element e :
                list) {
            ++idx;
            RealEstateDTO realEstateDTO = new RealEstateDTO();
            String url = e.select("dt a").attr("href");
            String imgUrl = e.select("dt a img").attr("src");
            String title = e.select("dt").text();
            if (imgUrl.length() == 0) {
                imgUrl = "https://user-images.githubusercontent.com/55802893/203673672-79cacd6a-d2bb-40a4-8315-e66441e5a2ac.png";
            }
            List<String> preview = List.of(e.select("dd").text().split("\\. "));
            realEstateDTO.setImgUrl(imgUrl);
            realEstateDTO.setNewsUrl(naverLand + url);
            realEstateDTO.setTitle(title);
            realEstateDTO.setPreview(preview.get(0));
            realEstateDTOList.add(realEstateDTO);
            if (idx == 12) break;
        }

        return realEstateDTOList;
    }
}
