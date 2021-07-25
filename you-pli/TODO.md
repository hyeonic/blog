## 현재까지 구현 상황
단순 Oauth2를 활용하여 google code 전달 받은 후 해당 code를 기반으로 accessToken을 얻어 userinfo를 저장

## 고민 사항

### 20210724 
 - youtube api 사용을 위해서는 accessToken을 기반으로 요청을 진행해야 한다. 하지만 이러한 accessToken은 어디에 보관해야 하는가?
 - google client 라이브러리 사용을 고려

## 20210725
 - JWT와 Oauth는 엄연히 다른 개념이다.
 - 지금 내가 해야 하는 것은 다른 social에서 제공하는 Oauth2 인증을 기반으로 자체적인 user를 생성하고 해당 user의 우리 자체 JWT 토큰을 발급해야 한다.
 - 추가적으로 각 social에서 제공하는 Oauth인증 후 발급받은 accessToken과 refreshToken 등 중간 저장소가 필요하다. -> 이것의 해결책이 redis session storage인가?
 - 결국 AccessToken을 가지고 있어야 youtube api나 spotify에 접근이 가능한 것으로 판단된다.
 - 만약 security 없이 구현한다고 가정하면 이러한 일련의 과정은 interceptor에서 처리가 가능하다. 우선 필터와 인터셉터에 대한 정리를 마무리하자.

