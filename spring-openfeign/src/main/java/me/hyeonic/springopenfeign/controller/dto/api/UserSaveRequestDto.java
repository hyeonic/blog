package me.hyeonic.springopenfeign.controller.dto.api;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UserSaveRequestDto {

    private String name;
    private String age;

    @Builder
    public UserSaveRequestDto(String name, String age) {
        this.name = name;
        this.age = age;
    }
}