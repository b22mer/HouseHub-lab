package com.ssafy.home.favorite.dao;

import com.ssafy.home.favorite.dto.FavoriteDTO;
import com.ssafy.home.house.dto.HouseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteMapper {

    void favoritedong(FavoriteDTO favoriteDTO);

    List<HouseDTO> getfavoritedongdeal(String id);

}
