package me.hyeonic.springsecuritysocialjwt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecuritysocialjwt.dto.social.google.GoogleRequestDto;
import me.hyeonic.springsecuritysocialjwt.dto.social.google.GoogleTokenInfo;
import me.hyeonic.springsecuritysocialjwt.dto.social.google.GoogleUserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoogleService {

    public static final String GRANT_TYPE = "authorization_code";
    public static final String GOOGLE_USERINFO_URL = "https://openidconnect.googleapis.com/v1/userinfo";

    private final RestTemplate restTemplate;

    @Value("${social.registration.google.request-url}")
    private String requestUrl;

    @Value("${social.registration.google.client-id}")
    private String clientId;

    @Value("${social.registration.google.client-secret}")
    private String clientSecret;

    @Value("${social.registration.google.redirect-uri}")
    private String redirectUri;

    public GoogleTokenInfo getAccessToken(String code) {

        GoogleRequestDto googleRequest = GoogleRequestDto.builder()
                .code(code)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectUri(redirectUri)
                .grantType(GRANT_TYPE)
                .build();

        return restTemplate.postForObject(requestUrl, googleRequest, GoogleTokenInfo.class);
    }

    public GoogleUserInfo getUserInfo(String accessToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        HttpEntity request = new HttpEntity(headers);
        GoogleUserInfo googleUserInfo = restTemplate.exchange(
                GOOGLE_USERINFO_URL,
                HttpMethod.GET,
                request,
                GoogleUserInfo.class
        ).getBody();

        return googleUserInfo;
    }

    public boolean validate(String accessToken) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", accessToken);

        new HttpEntity(headers); HttpEntity request = new HttpEntity(headers);
        ResponseEntity<GoogleUserInfo> responseEntity = restTemplate.exchange(
                GOOGLE_USERINFO_URL,
                HttpMethod.GET,
                request,
                GoogleUserInfo.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.UNAUTHORIZED) {
            return false;
        }

        return true;
    }
}
