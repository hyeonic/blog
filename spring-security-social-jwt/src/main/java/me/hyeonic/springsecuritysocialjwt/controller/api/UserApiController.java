package me.hyeonic.springsecuritysocialjwt.controller.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecuritysocialjwt.controller.response.BasicResponse;
import me.hyeonic.springsecuritysocialjwt.controller.response.CommonResponse;
import me.hyeonic.springsecuritysocialjwt.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;

    @GetMapping("users/my-info")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<? extends BasicResponse> myInfo() {
        return ResponseEntity.ok(new CommonResponse<>(userService.findMyInfo()));
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<? extends BasicResponse> findById(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(new CommonResponse<>(userService.findById(userId)));
    }
}