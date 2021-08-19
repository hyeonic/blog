package me.hyeonic.playlist.social;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.playlist.dto.social.spotify.SpotifyRequestDto;
import me.hyeonic.playlist.dto.social.spotify.SpotifyTokenInfo;
import me.hyeonic.playlist.dto.social.spotify.playlist.SpotifyPlaylistDto;
import me.hyeonic.playlist.feign.spotify.SpotifyAccountClient;
import me.hyeonic.playlist.feign.spotify.SpotifyClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class SpotifyService {

    private static final String GRANT_TYPE = "authorization_code";

    private final RestTemplate restTemplate;
    private final SpotifyAccountClient spotifyAccountClient;
    private final SpotifyClient spotifyClient;

    @Value("${social.registration.spotify.request-url}")
    private String requestUrl;

    @Value("${social.registration.spotify.client-id}")
    private String clientId;

    @Value("${social.registration.spotify.client-secret}")
    private String clientSecret;

    @Value("${social.registration.spotify.redirect-uri}")
    private String redirectUri;

    public SpotifyTokenInfo getAccessToken(String code) {

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("code", code);
//        params.add("client_id", clientId);
//        params.add("client_secret", clientSecret);
//        params.add("redirect_uri", redirectUri);
//        params.add("grant_type", GRANT_TYPE);

//        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(params, httpHeaders);

//        return restTemplate.postForObject(requestUrl, httpEntity, SpotifyTokenInfo.class);

        SpotifyRequestDto spotifyRequest = SpotifyRequestDto.builder()
                .code(code)
                .client_id(clientId)
                .client_secret(clientSecret)
                .redirect_uri(redirectUri)
                .grant_type(GRANT_TYPE)
                .build();

        return spotifyAccountClient.getAccessToken(spotifyRequest);
    }

    public SpotifyPlaylistDto.Playlists getPlaylists(String accessToken) {
//        String url = "https://api.spotify.com/v1/me/playlists";

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("Authorization", accessToken);

//        HttpEntity request = new HttpEntity(httpHeaders);
//        ResponseEntity<SpotifyPlaylistDto.Playlists> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                request,
//                SpotifyPlaylistDto.Playlists.class
//        );

//        return response.getBody();

        return spotifyClient.getPlaylists(accessToken);
    }

    public SpotifyPlaylistDto.Playlist getPlaylist(String accessToken) {
//        String url = "https://api.spotify.com/v1/playlists/4hCmls37NZkju3sLkJbRqX";

//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set("Authorization", accessToken);

//        HttpEntity request = new HttpEntity(httpHeaders);
//        ResponseEntity<SpotifyPlaylistDto.Playlist> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                request,
//                SpotifyPlaylistDto.Playlist.class
//        );

//        return response.getBody();
        return spotifyClient.getPlaylist(accessToken, "4hCmls37NZkju3sLkJbRqX");
    }
}