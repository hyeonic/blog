package me.hyeonic.springsecurityjwt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecurityjwt.domain.Role;
import me.hyeonic.springsecurityjwt.domain.User;
import me.hyeonic.springsecurityjwt.domain.UserRepository;
import me.hyeonic.springsecurityjwt.dto.user.UserMainResponseDto;
import me.hyeonic.springsecurityjwt.dto.user.UserSaveRequestDto;
import me.hyeonic.springsecurityjwt.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserMainResponseDto signup(UserSaveRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).orElse(null) != null) {
            throw new RuntimeException("이미 가입된 유저입니다.");
        }

        User user = User.builder()
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .name(requestDto.getName())
                .role(Role.ROLE_USER)
                .build();

        userRepository.save(user);

        return new UserMainResponseDto(user);
    }

    public UserMainResponseDto findById(Long id) {
        return userRepository.findById(id)
                .map(user -> new UserMainResponseDto(user))
                .orElseThrow(() -> new RuntimeException("존재하지 않는 user 입니다. id=" + id));
    }

    public UserMainResponseDto findUserInfo() {
        String email = SecurityUtil.getCurrentEmail().orElseThrow(() ->
                new RuntimeException("Security Context에 인증 정보가 없습니다."));

        return userRepository.findByEmail(email)
                .map(user -> new UserMainResponseDto(user))
                .orElseThrow(() -> new RuntimeException("존재하지 않는 user 입니다. email=" + email));
    }
}