package me.hyeonic.springinterceptorjwt.jwt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtTokenProviderTest {

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Test
    void createToken() {
        String token = jwtTokenProvider.createToken("admin@email.com");
        System.out.println(token);
    }

    @Test
    void validateToken() {
        String token = jwtTokenProvider.createToken("admin@email.com");
        System.out.println(token);
        jwtTokenProvider.validateToken(token);
    }
}