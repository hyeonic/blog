package me.hyeonic.springopenfeign.controller;

import me.hyeonic.springopenfeign.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1")
@RestController
public class UserApiController {

    @GetMapping("users")
    public List<User> getUser() {

        List<User> users = new ArrayList<>();
        users.add(User.builder().name("userA").age("20").build());
        users.add(User.builder().name("userB").age("21").build());
        users.add(User.builder().name("userC").age("23").build());
        users.add(User.builder().name("userD").age("19").build());
        users.add(User.builder().name("userE").age("17").build());

        return users;
    }
}