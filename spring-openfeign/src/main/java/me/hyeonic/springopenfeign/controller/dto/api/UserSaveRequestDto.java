package me.hyeonic.springopenfeign.controller.dto.api;

import lombok.Builder;
import lombok.Getter;
import me.hyeonic.springopenfeign.domain.user.User;

@Getter
public class UserSaveRequestDto {

    private String name;
    private String age;

    @Builder
    public UserSaveRequestDto(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public User toEntity() {
        return User.builder()
                .name(this.name)
                .age(this.age)
                .build();
    }
}