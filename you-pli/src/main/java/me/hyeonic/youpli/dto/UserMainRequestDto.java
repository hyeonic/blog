package me.hyeonic.youpli.dto;

import lombok.Builder;
import lombok.Data;
import me.hyeonic.youpli.domain.User;

@Data
public class UserMainRequestDto {

    private String name;
    private String email;

    @Builder
    public UserMainRequestDto(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .build();
    }
}