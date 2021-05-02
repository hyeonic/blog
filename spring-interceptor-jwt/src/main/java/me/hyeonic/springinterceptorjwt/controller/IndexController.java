package me.hyeonic.springinterceptorjwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/api/my-error")
    @ResponseBody
    public String myError() {
        return "my error page";
    }
}