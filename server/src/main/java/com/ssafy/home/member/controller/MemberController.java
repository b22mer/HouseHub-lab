package com.ssafy.home.member.controller;

import com.ssafy.home.common.dto.ResponseDTO;
import com.ssafy.home.member.dto.LoginDTO;
import com.ssafy.home.member.dto.Member;
import com.ssafy.home.member.service.MemberService;
import com.ssafy.home.util.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Api(tags = {"users"})
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final JWTUtil jwtUtil;

    @PutMapping("/update")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "사용자 정보수정")
    })
    public ResponseEntity<ResponseDTO> update(
            @ApiParam(value = "member")
            @RequestBody Member member) throws Exception {
        ResponseDTO res = new ResponseDTO();
        System.out.println(member.getName());
        long result = memberService.update(member);
        if (result > 0) {
            res.setMsg("사용자 정보 변경 완료");
            res.setStatusCode(200);
            res.setStatus("success");
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            res.setErrMsg("사용자 정보 변경 실패");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete")
    public void delete(HttpServletRequest req) throws Exception {
        HttpSession session = req.getSession(false);
        if (session != null) {
            Member m = (Member) session.getAttribute("member");
            memberService.delete(m);
            session.invalidate();
        }
    }

    @GetMapping("logout")
    public void logout(HttpServletRequest req) {
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "로그인 성공")
    })
    public ResponseEntity<ResponseDTO> login(
            @RequestBody LoginDTO loginDTO
    ) {
        System.out.println(loginDTO.getId());
        ResponseDTO res = new ResponseDTO();
        try {
            // 로그인 프로세스 추가
            Member user = memberService.login(loginDTO);
            String accessToken = jwtUtil.createToken(user.getId(), user.getName(), user.getAdmin());
            System.out.println(accessToken);

            res.setStatus("success");
            res.setMsg("login success");
            Map<String, Object> map = new HashMap<>();
            map.put("accessToken", accessToken);
            map.put("user", user);
            res.setBody(map);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            res.setStatus("fail");
            res.setErrMsg("로그인 정보가 잘못되었습니다. 다시 로그인해 주세요");
            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "사용자 회원가입")
    })
    public ResponseEntity<ResponseDTO> register(
            @ApiParam(value = "member")
            Member member) throws Exception {
        ResponseDTO res = new ResponseDTO();
        System.out.println(member.getId());
        memberService.register(member);
        res.setMsg("register success");
        res.setStatus("ok");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("idchck")
    public ResponseEntity<ResponseDTO> idCheck(
            @ApiParam(value = "id")
            String id) {
        int isId = memberService.checkId(id);

        ResponseDTO res = new ResponseDTO();
        if (isId > 0) {
            // id 존재
            res.setStatus("fail");
            res.setErrMsg("id가 존재합니다.");
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        } else {
            // id 생성 가능
            res.setStatus("success");
            res.setMsg("id는 생성 가능합니다.");
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
    }
}
