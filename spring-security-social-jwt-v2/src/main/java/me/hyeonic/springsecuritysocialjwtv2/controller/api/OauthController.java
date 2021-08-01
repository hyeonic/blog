package me.hyeonic.springsecuritysocialjwtv2.controller.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecuritysocialjwtv2.controller.response.BasicResponse;
import me.hyeonic.springsecuritysocialjwtv2.controller.response.CommonResponse;
import me.hyeonic.springsecuritysocialjwtv2.dto.token.TokenResponseDto;
import me.hyeonic.springsecuritysocialjwtv2.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OauthController {

    private final AuthService authService;

    @GetMapping("/oauth2callback")
    public ResponseEntity<? extends BasicResponse> callback(@RequestParam String code) {

        TokenResponseDto tokenResponseDto = authService.login(code);

        return ResponseEntity.ok(new CommonResponse<>(tokenResponseDto));
    }
}