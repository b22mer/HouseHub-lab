package com.ssafy.home.favorite.service;

import com.ssafy.home.favorite.dao.FavoriteMapper;
import com.ssafy.home.favorite.dto.FavoriteDTO;
import com.ssafy.home.house.dto.HouseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteService {
    private final FavoriteMapper favoriteMapper;

    public void favoriteDong(FavoriteDTO favoriteDTO) {
        favoriteMapper.favoritedong(favoriteDTO);
    }

    public List<HouseDTO> getFavoriteDong(String id) {
        return favoriteMapper.getfavoritedongdeal(id);
    }

}
