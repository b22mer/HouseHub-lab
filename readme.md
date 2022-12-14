# HouseHub

HouseHub는 사용자에게 부동산 관련 정보를 제공하는 서비스입니다.

### Member

| 이름   | 담당 기능                   |
| ------ | --------------------------- |
| 정원철 | Frontend                    |
|        | 프로젝트 페이지 UI및 세부기능|
|        | 아파트 위치 및 거래정보 표시|
|        | kakao map 커스텀 기능 구현  |
| 이상원 | Backend                     |
|        | 부동산 뉴스 크롤링          |
|        | Docker container 배포       |
|        | 로그인 세션 관리            |

## 요구사항 명세서

| index | 요구사항 명             | 요구사항 상세                                                                                   |
| ----- | ----------------------- | ----------------------------------------------------------------------------------------------- |
| 1     | 회원 관리               | 회원가입<br> 회원정보 수정<br> 회원정보 삭제                                                    |
| 2     | 사용자 인증 관리        | 회원 로그인 <br> 회원 로그아웃 <br> JWT access token 인증 <br> 게시글 원작성자 확인(수정, 삭제) |
| 3     | 게시판 관리             | 게시글 작성 <br> 게시글 수정 <br> 게시글 삭제 <br> 게시글 목록 출력                             |
| 4     | 아파트 실거래 정보 검색 | 지역별, 날짜별 실거래가 조회 <br> 실거래 상세보기                                               |
| 5     | 아파트 위치 정보        | 카카오 맵 마커를 이용한 위치 확인                                                               |
| 6     | 실거래가 관심 지역      | 관심지역 즐겨찾기 기능                                                                          |
| 7     | 주변 상권 정보 제공     | 특정 지역별 상권 정보 조회                                                                      |
| 8     | 최신 부동산 정보 확인   | 테마별 부동산 정보 크롤링 <br>크롤링 데이터 기반 부동산 정보 제공                               |
| 9     | 사용자 정보 암호화      | 사용자 이름, 비밀번호 정보 마스킹                                                               |
| 10    | 회원가입 정보 중복 검사 | id 중복 여부 확인                                                                               |
| 11    | social login            | google login                                                                                    |

## HouseHub 서비스 개발 계획표

| 항목/날짜(일)                       | ✅  | 16  | 17  | 18  | 19  | 20  | 21  | 22  | 23  | 24  |
| ----------------------------------- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 설계서 작성                         | ✅  | ▆   |     |     |     |     |     |     |     |     |
| 회원가입                            | ✅  | ▆   | ▆   |     |     |     |     |     |     |     |
| 로그인                              | ✅  | ▆   | ▆   |     |     |     |     |     |     |     |
| id 중복 여부 확인                   | ✅  | ▆   | ▆   |     |     |     |     |     |     |     |
| 사용자 이름, 비밀번호 정보 마스킹   | ✅  | ▆   | ▆   |     |     |     |     |     |     |     |
| 게시판 작성                         | ✅  | ▆   | ▆   |     |     |     |     |     |     |     |
| 게시판 수정                         | ✅  | ▆   | ▆   |     |     |     |     |     |     |     |
| 게시판 삭제                         | ✅  |     | ▆   | ▆   |     |     |     |     |     |     |
| 게시판 관리 권한 설정               | ✅  |     | ▆   | ▆   |     |     |     |     |     |     |
| 회원 정보 수정                      |     |     | ▆   | ▆   |     |     |     |     |     |     |
| 회원 정보 삭제                      |     |     | ▆   | ▆   |     |     |     |     |     |     |
| 사용자 인증 관리                    | ✅  |     | ▆   | ▆   |     |     |     |     |     |     |
| 지역별, 날짜별 실거래가 조회        | ✅  |     |     | ▆   | ▆   | ▆   |     |     |     |     |
| 실거래 상세보기                     | ✅  |     |     | ▆   | ▆   | ▆   |     |     |     |     |
| 카카오 맵 마커를 이용한 위치 확인   | ✅  |     |     |     |     | ▆   | ▆   |     |     |     |
| 관심지역 즐겨찾기 기능              | ✅  |     |     |     |     | ▆   | ▆   |     |     |     |
| social login                        |     |     |     |     | ▆   | ▆   | ▆   | ▆   |     |     |
| 테마별 부동산 정보 크롤링           | ✅  |     |     |     | ▆   | ▆   | ▆   | ▆   |     |     |
| 크롤링 데이터 기반 부동산 정보 제공 | ✅  |     |     |     | ▆   | ▆   | ▆   | ▆   |     |     |
| 특정 지역별 상권 정보 조회          |     |     |     |     | ▆   | ▆   | ▆   | ▆   |     |     |
| ui 수정                             | ✅  | ▆   | ▆   | ▆   | ▆   | ▆   | ▆   | ▆   | ▆   | ▆   |
| ppt 제작                            | ✅  |     |     |     |     |     | ▆   | ▆   | ▆   | ▆   |
| 프로젝트 시연 영상 제작             | ✅  |     |     |     |     |     |     |     | ▆   | ▆   |
| Docker container test               | ✅  |     |     |     |     |     |     |     | ▆   |     |
| 최종 제출                           |     |     |     |     |     |     |     |     |     | ▆   |

# 개발 의도 및 서비스 소개

HouseHub는 전국의 아파트 매매 실거래 정보를 상세하게 제공합니다. 시, 군구, 동, 년도, 월 기준으로 거래된 아파트의 매매 실거래 정보를 확인할 수 있습니다.서비스 이용자는 빠르게 변하는 부동산 시장에서 빠른 정보를 얻을 수 있도록 개발하였습니다.

## 사용 데이터

공공 데이터 포탈:[국토교통부 아파트매매 실거래 상세 자료](https://www.data.go.kr/iim/api/selectAPIAcountView.do)를 이용해 사용자에게 지역별 아파트 매매 정보를 전달

## Tech Stack

| SKILL      | VERSION |           |
| ---------- | :-----: | --------- |
| Java       |   17    | server    |
| Vue        |    3    | client    |
| taliwind   |    3    | css       |
| boot strap |    5    | css       |
| MYSQL      |   8.x   | database  |
| Docker     |    -    | container |
| vuex       |    4    | 상태관리  |

## 서비스 목표

HouseHub에서 서비스 이용자는 최신 부동산 뉴스를 확인할 수 있습니다. HouseHub을 통해 빠르게 변화하는 부동산 정보와 정책에 대해 확인할 수 있습니다. HouseHub 이용자는 시, 군구, 동, 년도, 월을 선택해서 원하는 지역의 아파트 매매 실거래 정보를 얻을 수 있습니다. 매매 정보는 층별 정보까지 얻을 수 있습니다.
HouseHub 이용자는 서비스 정보를 이용해 이사갈 지역이나 부동산 투자에 대해 도움을 받을 수 있습니다.

## 서비스 기능 설명

### 주요 기능: 아파트 실거래 매매 정보 조회

![](/readme_img/deal.png)

HouseHub 사용자는 시, 군구, 동과 날짜를 기준으로 원하는 지역의 아파트 매매 실거래 정보를 얻을 수 있습니다. 조회된 정보에는 도로명 주소, 건축일자, 층 정보, 면적, 거래가를 확인할 수 있습니다. HouseHub 사용자는 거래 정보 카드를 클릭해 해당 아파트의 위치를 지도를 통해 확인할 수 있습니다. 지도에는 아파트 이름을 가진 마커가 표시되고 마커를 누르게 되면 아파트 이름으로 naver.com에 검색 됩니다.

### 주요 기능: 관심지역 확인하기

![](/readme_img/fav.png)

HouseHub 사용자는 지역별 아파트 매매 실거래 정보를 조회 후 조회한 동을 기준으로 관심지역을 추가할 수 있습니다. 아파트 매매 실거래 정보를 조회 후 `관심지역 추가`를 클릭하게 되면 조회된 동이 관심지역에 추가됩니다.
`관심지역 조회`를 클릭하게 되면 관심지역으로 추가한 모든 동의 정보를 조회하게 됩니다. 조회되는 데이터가 너무 많기 때문에 50개로 제한하였습니다.

### 부가 기능: 부동산 뉴스 실시간으로 확인하기

![](/readme_img/news.png)

HouseHub 사용자는 서비스의 메인 화면 하단에서 오늘의 부동산 주요 뉴스를 실시간으로 확인할 수 있습니다. 최대 12개의 실시간 부동산 주요 뉴스를 확인할 수 있으며, 뉴스 카드를 클릭하게 되면 해당 뉴스로 이동해 전체 뉴스를 확인할 수 있습니다.

### 부가 기능: 게시판

![](/readme_img/write.png)
![](/readme_img/modify.png)

HouseHub 사용자는 게시글을 작성, 수정, 삭제할 수 있습니다. 사용자는 자유롭게 게시판에 글을 작성할 수 있습니다. 부동산 관련 정보를 공유하거나 다른 사용자의 글을 확인할 수 있습니다. 목록 아래 버튼으로 페이징이 가능합니다.

## 비기능: Access Token과 JWT Interceptor

사용자가 HouseHub 서비스에 로그인하게 되면 Access token이 발급된다. Access Token은 JWT(Json Web Token)을 사용한다. JWT Token은 인증에 필요한 정보들을 암호화 시킨 토큰이다. JWT token은 header와 payload, signature로 구성되어 있다.

Header에는 토큰의 타입과 알고리즘 방식이 저장된다. 알고리즘은 서명 및 토큰 검증에 사용된다. Payload는 정보의 조각인 claim이 담겨 있다. Signature는 토큰을 인코딩하거나 유효성을 검증할 때 사용하는 고유한 암호화 코드이다.

Access Token은 header의 `Authorization` 에 담겨 전달된다. Client에서 server로 request할 때 header의 Authorization에 토큰을 담아 server로 전달한다.
Client에서 interceptor가 걸리는 url pattern으로 요청 시 server는 client에서 넘어온 토큰이 유효한지 확인한다.

### Interceptor를 사용한 login 인증

```java
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
```

Header의 Authorization 값에 있는 access token을 받아 유효한지 검사한 후 유효하면 request에 사용자 로그인 정보를 저장한다.

## 비기능: 사용자 정보 암호화

![](/readme_img/member.png)
<sub>member table</sub>

![](/readme_img/securityvo.png)
<sub>securityvo table</sub>

데이터베이스에 저장되는 사용자의 정보는 마스킹한 후 저장되어야 한다. 키를 사용해 암호화와 복호화가 가능한 Cipher 클래스를 사용해 인스턴스를 생성하고, Cipher mode, secret key, 복호화에 사용할 키를 넣어 초기화해 준다. 초기화한 Cipher에 평문을 byte로 넣어 암호화 한 후 16진수로 변환해 반환한다. 반환된 16진수 문자열은 데이터베이스에 저장된다.

## 서비스 아키텍처

![](/readme_img/structure.png)

## Dockerizing

client와 server를 local docker container에 올린다

### client/dockerfile

```dockerfile
FROM node:16-alpine AS builder
WORKDIR /app
# package json copy
COPY package*.json ./
COPY yarn.lock ./
RUN yarn
COPY . .
RUN yarn build
EXPOSE 8080
CMD ["yarn", "serve"]
```

### server/dockerfile

```dockerfile
FROM adoptopenjdk/openjdk17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

### tools/build.sh

```shell
cd client
docker build -t myhouse:front .
cd ..
cd server
docker build -t myhouse:back .
docker run -d -p 8080:8080 myhouse:front
docker run -d -p 9999:9999 myhouse:back
```

프로젝트의 root폴더에서 build.sh를 실행하게 되면 client와 server가 docker에 build되고 container에서 실행하게 된다.
![](https://user-images.githubusercontent.com/55802893/203718990-b5b143ba-416b-4914-917e-9a0fde1a50b7.png)
local에서 실행한 후 docker desktop을 확인해보면 mysql와 client, server가 실행중이다.
localhost:8080으로 접근하면 서비스를 사용할 수 있다.

## ERD Diagram

![](https://user-images.githubusercontent.com/55802893/202338027-8d43d589-aae9-47f0-b7b4-b81414d52555.png)

## Class Diagram

![](/readme_img/classDigram.png)
