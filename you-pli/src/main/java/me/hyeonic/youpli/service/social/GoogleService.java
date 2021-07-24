package me.hyeonic.youpli.service.social;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.youpli.service.social.dto.GoogleRequestDto;
import me.hyeonic.youpli.service.social.dto.GoogleResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class GoogleService {

    public static final String GRANT_TYPE = "authorization_code";

    private final RestTemplate restTemplate;

    @Value("${social.registration.google.request-url}")
    private String requestUrl;

    @Value("${social.registration.google.client-id}")
    private String clientId;

    @Value("${social.registration.google.client-secret}")
    private String clientSecret;

    @Value("${social.registration.google.redirect-uri}")
    private String redirectUri;

    public GoogleResponseDto requestAccessToken(String code) {

        log.info("requestUrl = {}", requestUrl);
        log.info("clientId = {}", clientId);
        log.info("clientSecret = {}", clientSecret);
        log.info("redirectUri = {}", redirectUri);

        GoogleRequestDto googleRequest = GoogleRequestDto.builder()
                .code(code)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectUri(redirectUri)
                .grantType(GRANT_TYPE)
                .build();

        return restTemplate.postForObject(requestUrl, googleRequest, GoogleResponseDto.class);
    }
}