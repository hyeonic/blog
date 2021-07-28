package me.hyeonic.springsecuritysocialjwt.dto.user;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
public class UserSaveRequestDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String name;
}