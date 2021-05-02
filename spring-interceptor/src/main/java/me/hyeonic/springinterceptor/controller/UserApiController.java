package me.hyeonic.springinterceptor.controller;

import lombok.RequiredArgsConstructor;
import me.hyeonic.springinterceptor.domain.User;
import me.hyeonic.springinterceptor.repository.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("users")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}