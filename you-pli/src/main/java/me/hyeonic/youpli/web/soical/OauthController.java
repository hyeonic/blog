package me.hyeonic.youpli.web.soical;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.youpli.service.social.GoogleService;
import me.hyeonic.youpli.service.social.dto.GoogleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OauthController {

    private final GoogleService googleService;

    @GetMapping("/oauth2callback")
    public ResponseEntity<? extends BasicResponse> callback(@RequestParam String code) {

        log.info("code = {}", code);

        GoogleResponseDto googleResponseDto = googleService.requestAccessToken(code);

        return new ResponseEntity(new BasicResponse<>(googleResponseDto), HttpStatus.OK);
    }
}