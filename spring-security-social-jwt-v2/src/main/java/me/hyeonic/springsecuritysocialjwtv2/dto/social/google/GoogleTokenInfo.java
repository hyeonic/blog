package me.hyeonic.springsecuritysocialjwtv2.dto.social.google;

import lombok.Data;

@Data
public class GoogleTokenInfo {

    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;

    public String getTokenTypeAndAccessToken() {
        return token_type + " " + access_token;
    }
}