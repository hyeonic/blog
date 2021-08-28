package me.hyeonic.jpaassociation.user;

import me.hyeonic.jpaassociation.knowledge.Knowledge;
import me.hyeonic.jpaassociation.knowledge.KnowledgeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private KnowledgeService knowledgeService;

    static Knowledge generateKnowledge(User user, String title, String content) {
        return Knowledge.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();
    }

    @Test
    @DisplayName("user가 등록한 knowledge 조회")
    void findByKnowledge() {

        // given
        String email = "dev.hyeonic@gmail.com";
        User user = User.builder()
                .email(email)
                .build();

        userService.save(user);
        knowledgeService.save(generateKnowledge(user, "지식1", "지식1 내용"));
        knowledgeService.save(generateKnowledge(user, "지식2", "지식2 내용"));

        // when
        int size = userService.findByKnowledgeSize(user.getId());

        // then
        assertAll(
                () -> assertEquals(2, size)
        );
    }
}