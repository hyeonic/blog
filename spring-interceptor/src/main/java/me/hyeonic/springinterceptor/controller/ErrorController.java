package me.hyeonic.springinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my-error")
public class ErrorController {

    @GetMapping
    public String error() {
        return "my error page";
    }
}