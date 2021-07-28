package me.hyeonic.springsecuritysocialjwt.dto.token;

import lombok.Data;

@Data
public class TokenResponseDto {

    private String token;

    public TokenResponseDto(String token) {
        this.token = token;
    }
}