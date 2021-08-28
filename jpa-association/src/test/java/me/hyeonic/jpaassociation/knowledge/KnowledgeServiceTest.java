package me.hyeonic.jpaassociation.knowledge;

import me.hyeonic.jpaassociation.user.User;
import me.hyeonic.jpaassociation.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class KnowledgeServiceTest {

    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private UserService userService;

    static User generateUser(String email) {
        return User.builder()
                .email(email)
                .build();
    }
}