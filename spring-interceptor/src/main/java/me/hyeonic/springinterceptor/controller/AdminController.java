package me.hyeonic.springinterceptor.controller;

import me.hyeonic.springinterceptor.interceptor.Role;
import me.hyeonic.springinterceptor.interceptor.MySecured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @MySecured(role = Role.ADMIN)
    @GetMapping
    public String admin() {
        return "admin page";
    }
}