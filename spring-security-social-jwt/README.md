## spring-security-social-jwt

소셜 로그인을 기반으로 로그인을 진행한 후 자체적인 자원 접근을 위한 JWT 발급 구현 프로젝트

## 과정

1. 프론트에서 google social 로그인을 시도하면 authorization code 받아 callback controller에 parameter로 전달받는다.
2. 서버측은 전달받은 code를 활용하여 google api에 접근 가능한 access token을 발급 받는다. 
3. access token을 활용하여 접근한 user 정보를 조회한다.
4. 조회한 user 정보가 user DB에 존재하는지 검증한 후 없으면 회원가입을 진행하고 있으면 로그인을 진행한다.
5. 로그인이 완료되면, 즉 인증이 완료되면 자체 JWT를 발급하여 로그인을 시도한 user에게 전달한다.