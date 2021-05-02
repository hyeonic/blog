package me.hyeonic.springinterceptor.controller;

import me.hyeonic.springinterceptor.interceptor.MySecured;
import me.hyeonic.springinterceptor.interceptor.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @MySecured(role = Role.USER)
    @GetMapping
    public String user() {
        return "user page";
    }
}