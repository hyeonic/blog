package me.hyeonic.springsecuritysocialjwtv2.dto.user;

import lombok.Data;
import me.hyeonic.springsecuritysocialjwtv2.domain.user.User;

@Data
public class UserMainResponseDto {

    private String email;
    private String name;

    public UserMainResponseDto(User user) {
        this.email = user.getEmail();
        this.name = user.getName();
    }
}