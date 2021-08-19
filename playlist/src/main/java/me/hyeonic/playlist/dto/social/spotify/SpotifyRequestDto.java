package me.hyeonic.playlist.dto.social.spotify;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SpotifyRequestDto {

    private String code;
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String grant_type;

    @Builder
    public SpotifyRequestDto(String code, String client_id, String client_secret,
                             String redirect_uri, String grant_type) {
        this.code = code;
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.redirect_uri = redirect_uri;
        this.grant_type = grant_type;
    }
}