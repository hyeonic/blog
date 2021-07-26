package me.hyeonic.springsecurityjwt.controller;

import lombok.RequiredArgsConstructor;
import me.hyeonic.springsecurityjwt.controller.response.BasicResponse;
import me.hyeonic.springsecurityjwt.controller.response.CommonResponse;
import me.hyeonic.springsecurityjwt.dto.user.UserSaveRequestDto;
import me.hyeonic.springsecurityjwt.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("signup")
    public ResponseEntity<? extends BasicResponse> signup(@Valid @RequestBody UserSaveRequestDto requestDto) {
        return ResponseEntity.ok(new CommonResponse<>(userService.signup(requestDto)));
    }

    @GetMapping("users/info")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<? extends BasicResponse> getMyInfo() {
        return ResponseEntity.ok(new CommonResponse<>(userService.findUserInfo()));
    }

    @GetMapping("/users/{userId}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<? extends BasicResponse> getUserInfo(@PathVariable Long userId) {
        return ResponseEntity.ok(new CommonResponse<>(userService.findById(userId)));
    }
}
