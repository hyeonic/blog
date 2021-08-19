package me.hyeonic.springopenfeign.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "custom", url = "http://localhost:8080")
public interface CustomClient {

    @GetMapping("api/v1/example-header")
    String exampleHeader(@RequestHeader("Authentication") String token);
}