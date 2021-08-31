package me.hyeonic.springcacheredis.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("users/{userId}")
    public ResponseEntity findById(@PathVariable("userId") Long userId) {

        return new ResponseEntity(userService.findById(userId), HttpStatus.OK);
    }
}