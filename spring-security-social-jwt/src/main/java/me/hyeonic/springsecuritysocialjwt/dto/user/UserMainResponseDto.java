package me.hyeonic.springsecuritysocialjwt.dto.user;

import me.hyeonic.springsecuritysocialjwt.domain.user.User;

public class UserMainResponseDto {

    private String email;
    private String name;

    public UserMainResponseDto(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
    }
}