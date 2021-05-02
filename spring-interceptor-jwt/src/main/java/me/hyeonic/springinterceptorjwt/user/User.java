package me.hyeonic.springinterceptorjwt.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hyeonic.springinterceptorjwt.interceptor.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String email;
    private String password;
    private String name;
    private Role role;

    @Builder
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }
}