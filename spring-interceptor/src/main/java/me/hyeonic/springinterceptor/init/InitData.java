package me.hyeonic.springinterceptor.init;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.hyeonic.springinterceptor.domain.Posts;
import me.hyeonic.springinterceptor.interceptor.Role;
import me.hyeonic.springinterceptor.domain.User;
import me.hyeonic.springinterceptor.repository.PostsRepository;
import me.hyeonic.springinterceptor.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class InitData {

    private final UserRepository userRepository;
    private final PostsRepository postsRepository;

    @PostConstruct
    public void init() {
        User admin = new User("admin@email.com", "1234", "관리자");
        admin.setRole(Role.ADMIN);
        userRepository.save(admin);

        User hyeonic = new User("hyeonic@email.com", "1234", "hyeonic");
        hyeonic.setRole(Role.USER);
        userRepository.save(hyeonic);

        postsRepository.save(new Posts("공지사항", "공지사항을 적는 곳입니다.", admin));
        postsRepository.save(new Posts("게시글 1", "게시글 1의 content", hyeonic));
        postsRepository.save(new Posts("게시글 2", "게시글 2의 content", hyeonic));

        List<User> users = userRepository.findAll();
        for (User user : users) {
            log.info(user.toString());
        }

        List<Posts> posts = postsRepository.findAll();
        for (Posts post : posts) {
            log.info(post.toString());
        }
    }
}
