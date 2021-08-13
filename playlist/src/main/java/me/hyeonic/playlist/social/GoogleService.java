package me.hyeonic.playlist.social;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.playlist.dto.social.google.GoogleRequestDto;
import me.hyeonic.playlist.dto.social.google.GoogleTokenInfo;
import me.hyeonic.playlist.dto.social.google.playlist.YoutubePlaylistDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RequiredArgsConstructor
@Service
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

    public YoutubePlaylistDto.Playlists getPlaylists(String accessToken) {
        String url = "https://www.googleapis.com/youtube/v3/playlists";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("part", "id,snippet,status")
                .queryParam("mine", "true");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", accessToken);

        HttpEntity request = new HttpEntity(httpHeaders);
        ResponseEntity<YoutubePlaylistDto.Playlists> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                request,
                YoutubePlaylistDto.Playlists.class
        );

        return response.getBody();
    }
}