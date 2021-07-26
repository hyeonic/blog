package me.hyeonic.springsecurityjwt.dto.user;

import lombok.Getter;
import me.hyeonic.springsecurityjwt.domain.User;

@Getter
public class UserMainResponseDto {

    private String email;
    private String name;

    public UserMainResponseDto(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
    }
}