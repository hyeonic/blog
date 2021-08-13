package me.hyeonic.playlist.dto.social.spotify;

import lombok.Getter;

@Getter
public class SpotifyTokenInfo {

    private String access_token;
    private String token_type;
    private String scope;
    private String expires_in;
    private String refresh_token;

    public String getTokenTypeAndAccessToken() {
        return token_type + " " + access_token;
    }
}