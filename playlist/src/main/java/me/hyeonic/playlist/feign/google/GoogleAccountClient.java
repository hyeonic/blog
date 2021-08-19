package me.hyeonic.playlist.feign.google;

import me.hyeonic.playlist.dto.social.google.GoogleRequestDto;
import me.hyeonic.playlist.dto.social.google.GoogleTokenInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "googleAccount", url = "https://accounts.google.com")
public interface GoogleAccountClient {

    @PostMapping("o/oauth2/token")
    GoogleTokenInfo getAccessToken(@RequestBody GoogleRequestDto requestDto);
}