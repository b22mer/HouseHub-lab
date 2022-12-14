package com.ssafy.home.util;

import com.ssafy.home.member.dto.UserAuth;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.Date;

@Service
public class JWTUtil {
    public String createToken(String id, String name, int admin) {
        Date now = new Date();
        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .setSubject("access-token")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(60).toMillis()))
                .claim("id", id)
                .claim("name", name)
                .claim("admin", admin)
                .signWith(SignatureAlgorithm.HS256, "secret")
                .compact();
    }


    public UserAuth getAuth(String accessToken) throws JwtException {
        UserAuth userAuth = new UserAuth();
        Claims body = getPayload(accessToken);
        userAuth.setName(body.get("name", String.class));
        userAuth.setId(body.get("id", String.class));
        userAuth.setAdmin(body.get("admin", Integer.class));
        return userAuth;
    }

    public String getAccessToken(HttpServletRequest req){
        String Authorization = req.getHeader("Authorization");
        String accessToken = Authorization.split(" ")[1];
        System.out.println("access token : " + accessToken);
        return accessToken;
    }

    private Claims getPayload(String accessToken) {
        return Jwts.parser()
                .setSigningKey("secret")
                .parseClaimsJws(accessToken)
                .getBody();
    }

    public boolean isValid(String accessToken) {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey("secret")
                    .parseClaimsJws(accessToken);
            System.out.println(claims.getBody());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
