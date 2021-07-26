package me.hyeonic.springsecurityjwt.dto.user;

import lombok.Getter;
import me.hyeonic.springsecurityjwt.domain.Role;
import me.hyeonic.springsecurityjwt.domain.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class UserSaveRequestDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 3, max = 100)
    private String password;

    @NotNull
    @Size(min = 3, max = 20)
    private String name;
}