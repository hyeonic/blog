package me.hyeonic.playlist.feign.spotify;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import me.hyeonic.playlist.dto.social.spotify.SpotifyRequestDto;
import me.hyeonic.playlist.dto.social.spotify.SpotifyTokenInfo;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "spotifyAccount",
        url = "https://accounts.spotify.com",
        configuration = SpotifyAccountClient.Configuration.class)
public interface SpotifyAccountClient {

    @PostMapping(value = "api/token", consumes = "application/x-www-form-urlencoded")
    SpotifyTokenInfo getAccessToken(@RequestBody SpotifyRequestDto requestDto);

    class Configuration {
        @Bean
        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
            return new SpringFormEncoder(new SpringEncoder(converters));
        }
    }
}