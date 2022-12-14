package com.ssafy.home.favorite.controller;

import com.ssafy.home.common.dto.ResponseDTO;
import com.ssafy.home.favorite.controller.request.FavoriteDongCode;
import com.ssafy.home.favorite.dto.FavoriteDTO;
import com.ssafy.home.favorite.service.FavoriteService;
import com.ssafy.home.house.dto.HouseDTO;
import com.ssafy.home.member.dto.UserAuth;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("favorite")
@Api(tags = { "favorite" })
public class FavoriteController {
	private final FavoriteService favoriteService;

	@PostMapping("favdong")
	public ResponseEntity<ResponseDTO> favoriteDong(@RequestBody FavoriteDongCode favoriteDongCode,
			HttpServletRequest req) throws Exception {
		System.out.println(favoriteDongCode.getDongCode());
		ResponseDTO res = new ResponseDTO();
		UserAuth userAuth = (UserAuth) req.getAttribute("auth");
		FavoriteDTO favoriteDTO = new FavoriteDTO();
		favoriteDTO.setId(userAuth.getId());
		favoriteDTO.setDongCode(favoriteDongCode.getDongCode());
		try {
			favoriteService.favoriteDong(favoriteDTO);
			res.setStatus("success");
			res.setStatusCode(200);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("관심지역 설정 중에 오류가 발생했습니다");
		}
	}

	@GetMapping("myfavdong")
	public ResponseEntity<ResponseDTO> getFavoriteDong(HttpServletRequest req) throws Exception {
		UserAuth userAuth = (UserAuth) req.getAttribute("auth");
		ResponseDTO res = new ResponseDTO();
		try {
			List<HouseDTO> list = favoriteService.getFavoriteDong(userAuth.getId());
			res.setBody(list);
			res.setStatusCode(200);
			res.setMsg("success");
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception("관심지역 조회에 실패했습니다");
		}

	}
}
