package me.hyeonic.springsecuritysocialjwtv2.dto.token;

import lombok.Builder;
import lombok.Data;

@Data
public class TokenResponseDto {

    private String grantType;
    private String accessToken;
    private long expiresIn;
    private String refreshToken;

    @Builder
    public TokenResponseDto(String grantType, String accessToken, long expiresIn, String refreshToken) {
        this.grantType = grantType;
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshToken = refreshToken;
    }
}