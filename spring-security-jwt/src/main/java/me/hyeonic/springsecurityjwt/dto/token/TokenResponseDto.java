package me.hyeonic.springsecurityjwt.dto.token;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponseDto {

    private String token;

    @Builder
    public TokenResponseDto(String token) {
        this.token = token;
    }
}