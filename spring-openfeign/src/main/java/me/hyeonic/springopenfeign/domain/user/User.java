package me.hyeonic.springopenfeign.domain.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String age;

    @Builder
    public User(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public void update(User user) {
        this.name = user.name;
        this.age = user.age;
    }
}