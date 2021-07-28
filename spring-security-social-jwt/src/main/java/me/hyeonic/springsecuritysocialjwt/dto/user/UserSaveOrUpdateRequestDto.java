package me.hyeonic.springsecuritysocialjwt.dto.user;

import lombok.Builder;
import lombok.Getter;
import me.hyeonic.springsecuritysocialjwt.domain.user.Role;
import me.hyeonic.springsecuritysocialjwt.domain.user.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
public class UserSaveOrUpdateRequestDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String name;

    @Builder
    public UserSaveOrUpdateRequestDto(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public User toEntity() {
        return User.builder()
                .email(this.email)
                .name(this.name)
                .role(Role.ROLE_USER)
                .build();
    }
}