package me.hyeonic.youpli.service.social.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class GoogleRequestDto {

    private String code;
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String grantType;

    @Builder
    public GoogleRequestDto(String code, String clientId, String clientSecret, String redirectUri, String grantType) {
        this.code = code;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
        this.grantType = grantType;
    }
}