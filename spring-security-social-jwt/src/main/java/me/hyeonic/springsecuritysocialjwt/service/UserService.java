package me.hyeonic.springsecuritysocialjwt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecuritysocialjwt.domain.user.Role;
import me.hyeonic.springsecuritysocialjwt.domain.user.User;
import me.hyeonic.springsecuritysocialjwt.domain.user.UserRepository;
import me.hyeonic.springsecuritysocialjwt.dto.user.UserMainResponseDto;
import me.hyeonic.springsecuritysocialjwt.dto.user.UserSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserSaveRequestDto requestDto) {

        User user = User.builder()
                .email(requestDto.getEmail())
                .name(requestDto.getName())
                .role(Role.ROLE_USER)
                .build();

        return userRepository.save(user).getId();
    }

    public UserMainResponseDto findById(Long id) {
        return userRepository.findById(id)
                .map(user -> new UserMainResponseDto(user))
                .orElseThrow(() -> new RuntimeException("존재하지 않는 user 입니다. id=" + id));
    }
}