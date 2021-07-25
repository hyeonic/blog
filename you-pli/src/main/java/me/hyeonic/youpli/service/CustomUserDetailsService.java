package me.hyeonic.youpli.service;

import lombok.RequiredArgsConstructor;
import me.hyeonic.youpli.domain.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    // 로그인시에 DB에 유저정보와 권한정보를 가져온다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .map(user -> new CustomUserDetails(user)).orElseThrow(
                        () -> new UsernameNotFoundException(username + " 존재하지 않는 username 입니다."));
    }
}