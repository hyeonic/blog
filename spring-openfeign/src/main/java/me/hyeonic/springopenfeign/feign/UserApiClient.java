package me.hyeonic.springopenfeign.feign;

import me.hyeonic.springopenfeign.controller.dto.api.UserSaveRequestDto;
import me.hyeonic.springopenfeign.domain.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "user", url = "http://localhost:8080")
public interface UserApiClient {

    @GetMapping("/api/v1/users")
    List<User> getUsers();

    @GetMapping("/api/v1/users/{userId}")
    User getUser(@PathVariable Long userId);

    @PostMapping("/api/v1/users")
    User save(@RequestBody UserSaveRequestDto requestDto);

    @PutMapping("/api/v1/users/{userId}")
    User update(@PathVariable Long userId, @RequestBody UserSaveRequestDto updateDto);

    @DeleteMapping("/api/v1/users/{userId}")
    void delete(@PathVariable Long userId);
}