package me.hyeonic.tistory.controller;

import lombok.Getter;
import lombok.Setter;
import me.hyeonic.tistory.domain.user.User;
import me.hyeonic.tistory.domain.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserApiController {

    private final UserRepository userRepository = UserRepository.getInstance();

    @PostMapping("users")
    public User save(@RequestBody User user) {
        Long saveId = userRepository.save(user);
        return userRepository.findById(saveId);
    }

    @GetMapping("v1/users/{userId}")
    public User getV1(@PathVariable("userId") Long id) {
        return userRepository.findById(id);
    }

    @GetMapping("v2/users/{userId}")
    public ResponseEntity<User> getV2(@PathVariable("userId") Long id) {
        if (userRepository.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

//        return ResponseEntity.ok().body(userRepository.findById(id));
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("v3/users/{userId}")
    public ResponseEntity<Map<String, Object>> getV3(@PathVariable("userId") Long id) {
        if (userRepository.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, Object> result = new HashMap<>();
        result.put("data", userRepository.findById(id));

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("v4/users")
    public ResponseEntity<Map<String, Object>> getV4() {
        List<User> users = userRepository.findAll();

        Map<String, Object> result = new HashMap<>();
        result.put("data", users);
        result.put("count", users.size());

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("v5/users")
    public ResponseEntity<Result<List<User>>> getV5() {
        List<User> users = userRepository.findAll();

        return ResponseEntity.ok().body(new Result<>(users, users.size()));
    }

    @Getter
    @Setter
    static class Result<T> {
        private T data;
        private int count;

        public Result(T data, int count) {
            this.data = data;
            this.count = count;
        }
    }
}




