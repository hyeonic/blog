package me.hyeonic.springopenfeign.service;

import lombok.RequiredArgsConstructor;
import me.hyeonic.springopenfeign.controller.dto.api.UserSaveRequestDto;
import me.hyeonic.springopenfeign.domain.user.User;
import me.hyeonic.springopenfeign.feign.UserApiClient;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserApiClient userApiClient;

    public User save(UserSaveRequestDto requestDto) {
        return userApiClient.save(requestDto);
    }

    public User findById(Long userId) {
        return userApiClient.getUser(userId);
    }

    public List<User> findAll() {
        return userApiClient.getUsers();
    }

    public User update(Long userId, UserSaveRequestDto updateDto) {
        return userApiClient.update(userId, updateDto);
    }

    public void delete(Long userId) {
        userApiClient.delete(userId);
    }
}