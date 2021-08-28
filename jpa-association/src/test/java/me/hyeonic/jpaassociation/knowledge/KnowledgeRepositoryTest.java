package me.hyeonic.jpaassociation.knowledge;

import me.hyeonic.jpaassociation.user.User;
import me.hyeonic.jpaassociation.user.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class KnowledgeRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    KnowledgeRepository knowledgeRepository;

    static User generateUser(String email) {
        return User.builder()
                .email(email)
                .build();
    }

    @Test
    @DisplayName("knowledge 등록")
    void save() {

        // given
        User user = generateUser("dev.hyeonic@email.com");
        user = userRepository.save(user);

        // when
        Knowledge knowledge = Knowledge.builder()
                .title("지식")
                .content("지식을 등록하세요")
                .user(user)
                .build();

        knowledgeRepository.save(knowledge);

        // then
        List<Knowledge> knowledges = knowledgeRepository.findAll();
        assertEquals(1, knowledges.size());
    }
}