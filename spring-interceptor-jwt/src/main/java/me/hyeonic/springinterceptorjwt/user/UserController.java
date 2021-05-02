package me.hyeonic.springinterceptorjwt.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.hyeonic.springinterceptorjwt.interceptor.MySecured;
import me.hyeonic.springinterceptorjwt.interceptor.Role;
import me.hyeonic.springinterceptorjwt.jwt.JwtTokenProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;

    @GetMapping("login")
    public String getLoginPage() {
        return "login-form";
    }

    @PostMapping("login")
    @ResponseBody
    public Result<String> login(@RequestBody Userform userform) {
        User user = userRepository.findByEmailAndPassword(userform.getEmail(), userform.getPassword())
                .orElse(null);

        if (user == null) {
            return new Result<>("false");
        }

        String token = tokenProvider.createToken(userform.getEmail());
        return new Result<>(token);
    }

    @MySecured(role = Role.USER)
    @GetMapping("users/my-info")
    @ResponseBody
    public Result<String> myPage() {
        return new Result<>("my page info");
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class Result<T> {
        T data;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class Userform {
        private String email;
        private String password;
    }
}