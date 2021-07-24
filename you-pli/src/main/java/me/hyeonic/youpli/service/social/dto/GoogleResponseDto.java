package me.hyeonic.youpli.service.social.dto;

import lombok.Data;

@Data
public class GoogleResponseDto {

    private String access_token;
    private String expires_in;
    private String refresh_token;
    private String scope;
    private String token_type;
}