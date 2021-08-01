package me.hyeonic.springsecuritysocialjwtv2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecuritysocialjwtv2.domain.refreshtoken.RefreshToken;
import me.hyeonic.springsecuritysocialjwtv2.domain.refreshtoken.RefreshTokenRepository;
import me.hyeonic.springsecuritysocialjwtv2.domain.user.User;
import me.hyeonic.springsecuritysocialjwtv2.dto.social.google.GoogleTokenInfo;
import me.hyeonic.springsecuritysocialjwtv2.dto.social.google.GoogleUserInfo;
import me.hyeonic.springsecuritysocialjwtv2.dto.token.TokenRequestDto;
import me.hyeonic.springsecuritysocialjwtv2.dto.token.TokenResponseDto;
import me.hyeonic.springsecuritysocialjwtv2.dto.user.UserMainResponseDto;
import me.hyeonic.springsecuritysocialjwtv2.jwt.TokenProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserService userService;
    private final GoogleService googleService;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public TokenResponseDto login(String code) {

        // access token 가져오기
        GoogleTokenInfo googleTokenInfo = googleService.getAccessToken(code);

        // access token 을 기반으로 user 정보 가져오기
        GoogleUserInfo googleUserInfo = googleService.getUserInfo(googleTokenInfo.getTokenTypeAndAccessToken());

        // user 정보를 기반으로 저장 or update 하기
        UserMainResponseDto userMainResponseDto = userService.saveOrUpdate(googleUserInfo.toUserSaveOrUpdateRequestDto());

        // user 정보를 기반으로 UsernamePasswordAuthenticationToken 객체 생성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userMainResponseDto.getEmail(), "");

        // 인증 요청
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        User user = userService.findByEmail(userMainResponseDto.getEmail());

        // 토큰 생성
        TokenResponseDto tokenResponseDto = tokenProvider.createToken(authentication);

        // RefreshToken 저장
        RefreshToken refreshToken = RefreshToken.builder()
                .user(user)
                .refreshToken(tokenResponseDto.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        return tokenResponseDto;
    }

    @Transactional
    public TokenResponseDto reissue(TokenRequestDto tokenRequestDto) {

        // refresh token 유효성 검사
        if (!tokenProvider.validateToken(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("유효하지 않은 Refresh Token 입니다.");
        }

        // 유효하면 access token 에서 정보 꺼내기
        Authentication authentication = tokenProvider.getAuthentication(tokenRequestDto.getAccessToken());

        // user email 을 활용하여 refreshToken 정보 조회
        RefreshToken refreshToken = refreshTokenRepository.findByUserEmail(authentication.getName())
                .orElseThrow(() -> new RuntimeException("Refresh Token 이 존재하지 않습니다."));

        //  requestDto 의 refresh token 과 DB 에서 조회한 token 정보 비교
        if (!refreshToken.getRefreshToken().equals(tokenRequestDto.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 일치하지 않습니다.");
        }

        // 토큰 생성
        TokenResponseDto tokenResponseDto = tokenProvider.createToken(authentication);

        // 기존 user 의 새로운 token 을 담아 build
        RefreshToken newRefreshToken = RefreshToken.builder()
                .user(refreshToken.getUser())
                .refreshToken(tokenResponseDto.getRefreshToken())
                .build();

        // token 정보 update
        refreshToken.update(newRefreshToken);

        return tokenResponseDto;
    }
}