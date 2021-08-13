package me.hyeonic.playlist.social;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.playlist.dto.social.google.GoogleRequestDto;
import me.hyeonic.playlist.dto.social.google.GoogleTokenInfo;
import me.hyeonic.playlist.dto.social.spotify.SpotifyRequestDto;
import me.hyeonic.playlist.dto.social.spotify.SpotifyTokenInfo;
import me.hyeonic.playlist.dto.social.spotify.playlist.SpotifyPlaylistDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class SpotifyService {

    private static final String GRANT_TYPE = "authorization_code";

    private final RestTemplate restTemplate;

    @Value("${social.registration.spotify.request-url}")
    private String requestUrl;

    @Value("${social.registration.spotify.client-id}")
    private String clientId;

    @Value("${social.registration.spotify.client-secret}")
    private String clientSecret;

    @Value("${social.registration.spotify.redirect-uri}")
    private String redirectUri;

    public SpotifyTokenInfo getAccessToken(String code) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("redirect_uri", redirectUri);
        params.add("grant_type", GRANT_TYPE);

        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, httpHeaders);

        return restTemplate.postForObject(requestUrl, httpEntity, SpotifyTokenInfo.class);
    }

    public SpotifyTokenInfo getAccessTokenV2(String code) {

        SpotifyRequestDto googleRequest = SpotifyRequestDto.builder()
                .code(code)
                .clientId(clientId)
                .clientSecret(clientSecret)
                .redirectUri(redirectUri)
                .grantType(GRANT_TYPE)
                .build();

        return restTemplate.postForObject(requestUrl, googleRequest, SpotifyTokenInfo.class);
    }

    public SpotifyPlaylistDto.Playlists getPlaylists(String accessToken) {
        String url = "https://api.spotify.com/v1/me/playlists";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", accessToken);

        HttpEntity request = new HttpEntity(httpHeaders);
        ResponseEntity<SpotifyPlaylistDto.Playlists> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                request,
                SpotifyPlaylistDto.Playlists.class
        );

        return response.getBody();
    }
}