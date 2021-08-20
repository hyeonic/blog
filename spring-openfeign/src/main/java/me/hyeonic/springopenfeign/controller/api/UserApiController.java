package me.hyeonic.springopenfeign.controller.api;

import lombok.RequiredArgsConstructor;
import me.hyeonic.springopenfeign.controller.dto.api.UserSaveRequestDto;
import me.hyeonic.springopenfeign.domain.user.User;
import me.hyeonic.springopenfeign.domain.user.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1")
@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("users/{userId}")
    public User getUser(@PathVariable Long userId) {

        return userRepository.findById(userId).get();
    }


    @GetMapping("users")
    public List<User> getUsers() {

        Iterable<User> usersIterable = userRepository.findAll();
        final List<User> users = new ArrayList<>();
        usersIterable.forEach(users::add);

        return users;
    }

    @PostMapping("users")
    public User saveUser(@RequestBody UserSaveRequestDto requestDto) {

        return userRepository.save(requestDto.toEntity());
    }

    @PutMapping("users/{userId}")
    public User update(@PathVariable Long userId,
                       @RequestBody UserSaveRequestDto updateDto) {

        User user = userRepository.findById(userId).get();
        user.update(updateDto.toEntity());

        return user;
    }

    @DeleteMapping("users/{userId}")
    public void delete(@PathVariable Long userId) {

        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
    }
}