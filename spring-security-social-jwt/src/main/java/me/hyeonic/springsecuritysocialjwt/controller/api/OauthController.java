package me.hyeonic.springsecuritysocialjwt.controller.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springsecuritysocialjwt.controller.response.BasicResponse;
import me.hyeonic.springsecuritysocialjwt.controller.response.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OauthController {

    @GetMapping("/oauth2callback")
    public ResponseEntity<? extends BasicResponse> callback(@RequestParam String code) {

        log.debug("code = {}", code);

        return ResponseEntity.ok(new CommonResponse<>(code));
    }
}