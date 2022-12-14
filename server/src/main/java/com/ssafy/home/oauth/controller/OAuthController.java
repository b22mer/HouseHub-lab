package com.ssafy.home.oauth.controller;

import com.ssafy.home.common.dto.ResponseDTO;
import com.ssafy.home.member.dto.Member;
import com.ssafy.home.member.service.MemberService;
import com.ssafy.home.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("oauth")
public class OAuthController {
    private final MemberService memberService;
    private final JWTUtil jwtUtil;

    @PostMapping("google")
    public ResponseEntity<ResponseDTO> google(
            HttpServletRequest req) {
        ResponseDTO res = new ResponseDTO();
        try {
            String GOOGLE_USERINFO_REQUEST_URL = "https://www.googleapis.com/oauth2/v1/userinfo";

            String accessToken = req.getHeader(HttpHeaders.AUTHORIZATION);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", accessToken);

            //HttpEntity를 하나 생성해 헤더를 담아서 restTemplate으로 구글과 통신하게 된다.
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity(headers);

            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setReadTimeout(5000);  // 읽기시간초과, ms
            factory.setConnectTimeout(3000); // 연결시간초과, ms
            CloseableHttpClient httpClient = HttpClientBuilder.create()
                    .setMaxConnTotal(100) // connection pool 적용
                    .setMaxConnPerRoute(5) // connection pool 적용
                    .build();
            factory.setHttpClient(httpClient); // 동기실행에 사용될 HttpClient 세팅
            RestTemplate restTemplate = new RestTemplate(factory);

            ResponseEntity<String> response = restTemplate.exchange("https://www.googleapis.com/oauth2/v1/userinfo", HttpMethod.GET, request, String.class);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(response.getBody().toString());

            String passId = (String) jsonObject.get("id");
            String emailId = ((String) jsonObject.get("email"));
            String name = (String) jsonObject.get("name");


            if (memberService.isEmailExist(emailId) == 1) {
                // DB에 있는 계정이라면 로그인
                Member user = memberService.useGoogleOauth(emailId);
                String loginAccessToken = jwtUtil.createToken(user.getId(), user.getName(), user.getAdmin());
                Map<String, Object> map = new HashMap<>();
                map.put("user", user);
                map.put("accessToken", loginAccessToken);
                res.setMsg("success");
                res.setBody(map);
                return new ResponseEntity<>(res, HttpStatus.OK);
            } else {
                // DB에 없는 계정이라면 회원가입 -> 로그인
                Member member = new Member();
                member.setId(emailId);
                member.setPw(passId);
                member.setEmail(emailId);
                member.setName(name);
                memberService.register(member);
                res.setMsg("회원가입 되었습니다 로그인 해주세요");
                return new ResponseEntity<>(res, HttpStatus.OK);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
