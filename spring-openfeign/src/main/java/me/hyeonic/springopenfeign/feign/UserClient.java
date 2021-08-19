package me.hyeonic.springopenfeign.feign;

import me.hyeonic.springopenfeign.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "user", url = "http://localhost:8080")
public interface UserClient {

    @GetMapping("/api/v1/users")
    List<User> getUsers();
}