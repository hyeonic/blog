package me.hyeonic.youpli.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.youpli.domain.User;
import me.hyeonic.youpli.domain.UserRepository;
import me.hyeonic.youpli.dto.UserMainRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long save(UserMainRequestDto requestDto) {
        return userRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void update(UserMainRequestDto requestDto) {
        User user = userRepository.findByEmail(requestDto.getEmail()).orElse(null);

        if (user == null) {
            save(requestDto);
        } else {
            user.update(requestDto.toEntity());
        }
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}