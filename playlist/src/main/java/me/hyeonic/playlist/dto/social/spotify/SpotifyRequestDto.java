package me.hyeonic.playlist.dto.social.spotify;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SpotifyRequestDto {

    private String code;
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String grantType;

    @Builder
    public SpotifyRequestDto(String code, String clientId, String clientSecret, String redirectUri, String grantType) {
        this.code = code;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.grantType = grantType;
    }
}