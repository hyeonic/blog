package me.hyeonic.springopenfeign.service;

import lombok.RequiredArgsConstructor;
import me.hyeonic.springopenfeign.controller.dto.api.UserSaveRequestDto;
import me.hyeonic.springopenfeign.domain.User;
import me.hyeonic.springopenfeign.feign.UserClient;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserClient userClient;

    public List<User> getUsers() {
        return userClient.getUsers();
    }

    public User save(UserSaveRequestDto requestDto) {
        return userClient.postUser(requestDto);
    }
}