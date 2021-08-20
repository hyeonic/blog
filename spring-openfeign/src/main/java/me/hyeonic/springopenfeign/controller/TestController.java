package me.hyeonic.springopenfeign.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.hyeonic.springopenfeign.controller.dto.api.UserSaveRequestDto;
import me.hyeonic.springopenfeign.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;

    @GetMapping("test1")
    public Result test1() {

        UserSaveRequestDto userSaveRequestDto = UserSaveRequestDto.builder()
                .name("userA")
                .age("20")
                .build();

        return new Result(userService.save(userSaveRequestDto));
    }

    @GetMapping("test2")
    public Result test2() {
        return new Result(userService.findAll());
    }

    @GetMapping("test3")
    public Result test3() {
        return new Result(userService.findById(1L));
    }

    @GetMapping("test4")
    public Result test4() {

        UserSaveRequestDto updateDto = UserSaveRequestDto.builder()
                .name("update userA")
                .age("25")
                .build();

        return new Result(userService.update(1L, updateDto));
    }

    @GetMapping("test5")
    public Result test5() {

        userService.delete(1L);

        return new Result("id가 1인 user가 삭제되었습니다.");
    }

    @Getter
    @AllArgsConstructor
    static class Result<T> {
        T data;
    }
}