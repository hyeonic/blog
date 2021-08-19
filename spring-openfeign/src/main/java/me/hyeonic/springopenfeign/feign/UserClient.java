package me.hyeonic.springopenfeign.feign;

import me.hyeonic.springopenfeign.controller.dto.api.UserSaveRequestDto;
import me.hyeonic.springopenfeign.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user", url = "http://localhost:8080")
public interface UserClient {

    @GetMapping("/api/v1/users")
    List<User> getUsers();

    @PostMapping("/api/v1/users")
    User postUser(@RequestBody UserSaveRequestDto requestDto);
}