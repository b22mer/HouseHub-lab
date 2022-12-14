package com.ssafy.home.interceptor;

import com.ssafy.home.member.dto.UserAuth;
import com.ssafy.home.util.JWTUtil;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {
    private final JWTUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 컨트롤러 메서드에 매핑된 uri가 호출 되면 실행 되는 메서드 controller 진입 직전 수행
        // Authorization에서 access token을 가져옴
        System.out.println(request.getMethod());


        if (!(handler instanceof HandlerMethod)) {
            System.out.println("handler method");
            return true;
        }

        // preflight 요청에 대한 공부 필요
        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("auth : " + authorization);
        if (authorization == null || authorization.length() == 0) {
            throw new JwtException("AUTHORIZATION not exists");
        }
        String accessToken = authorization.split(" ")[1];
        boolean isValid = jwtUtil.isValid(accessToken);
        if (isValid) {
            // 토큰 유효함 user auth 정보 가져오기
            UserAuth userAuth = jwtUtil.getAuth(accessToken);
            request.setAttribute("auth", userAuth);
            return true;
        } else {
            throw new JwtException("access token invalid, login please");
        }
    }
}
