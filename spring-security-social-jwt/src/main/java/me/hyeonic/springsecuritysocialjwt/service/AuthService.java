package me.hyeonic.springsecuritysocialjwt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecuritysocialjwt.dto.social.google.GoogleTokenInfo;
import me.hyeonic.springsecuritysocialjwt.dto.social.google.GoogleUserInfo;
import me.hyeonic.springsecuritysocialjwt.dto.token.TokenResponseDto;
import me.hyeonic.springsecuritysocialjwt.dto.user.UserMainResponseDto;
import me.hyeonic.springsecuritysocialjwt.jwt.TokenProvider;
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

        String jwt = tokenProvider.createToken(authentication);

        return new TokenResponseDto(jwt);
    }
}