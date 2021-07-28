package me.hyeonic.springsecuritysocialjwt.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecuritysocialjwt.dto.social.google.GoogleTokenInfo;
import me.hyeonic.springsecuritysocialjwt.dto.social.google.GoogleUserInfo;
import me.hyeonic.springsecuritysocialjwt.service.CustomUserDetailsService;
import me.hyeonic.springsecuritysocialjwt.service.GoogleService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final GoogleService googleService;
    private final CustomUserDetailsService customUserDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        GoogleTokenInfo tokenInfo = (GoogleTokenInfo) authentication.getDetails();

        if (!googleService.validate(tokenInfo.getTokenTypeAndAccessToken())) {
            throw new BadCredentialsException("유효하지 않은 social access token 입니다.");
        }

        GoogleUserInfo userInfo = googleService.getUserInfo(tokenInfo.getTokenTypeAndAccessToken());
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userInfo.getEmail());

        return new UsernamePasswordAuthenticationToken(
                userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
