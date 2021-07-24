## 현재까지 구현 상황
단순 Oauth2를 활용하여 google code 전달 받은 후 해당 code를 기반으로 accessToken을 얻어 userinfo를 저장

## 고민 사항
 - youtube api 사용을 위해서는 accessToken을 기반으로 요청을 진행해야 한다. 하지만 이러한 accessToken은 어디에 보관해야 하는가?
 - google client 라이브러리 사용을 고려