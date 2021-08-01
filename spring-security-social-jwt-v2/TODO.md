로그인 시
1. google 소셜 로그인 진행 -> server 측 인가 code 획득
2. code를 기반으로 access token 및 refresh token 발급
3. access token으로 user 정보 조회하여 로그인 및 회원가입 진행
4. 자체 token 발급

자체 access token 만료
1. 클라이언트는 자체 access token 과 refresh token 발급
2. 적절히 검증하고 자체 token 재발급 진행