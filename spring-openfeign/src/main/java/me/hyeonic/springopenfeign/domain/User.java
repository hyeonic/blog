package me.hyeonic.springopenfeign.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class User {

    private String name;
    private String age;

    @Builder
    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
}