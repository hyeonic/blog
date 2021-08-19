package me.hyeonic.springopenfeign.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1")
@RestController
public class ExampleApiController {

    @GetMapping("example-header")
    public String exampleHeader(@RequestHeader("Authentication") String token) {
        return token;
    }
}