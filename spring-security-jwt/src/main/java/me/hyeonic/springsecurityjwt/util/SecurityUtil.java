package me.hyeonic.springsecurityjwt.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SecurityUtil {

    // Security Context의 Authentication 객체를 이용하여 user id를 return 해주는 유틸성 메소드
    public static Optional<Long> getCurrentUserId() {
        // Security Context에 Authentication 객체가 저장되는 시점은
        // JwtFilter의 doFilter메소드에서 Request가 들어올 때 SecurityContext에 Authentication 객체를 저장해서 사용
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.getName() == null) {
            return Optional.empty();
        }

        long userId = Long.parseLong(authentication.getName());
        return Optional.of(userId);
    }
}