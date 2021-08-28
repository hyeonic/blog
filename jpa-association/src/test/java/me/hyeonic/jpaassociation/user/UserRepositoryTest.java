package me.hyeonic.jpaassociation.user;

import me.hyeonic.jpaassociation.knowledge.Knowledge;
import me.hyeonic.jpaassociation.knowledge.KnowledgeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    UserRepository userRepository;

    @Autowired
    KnowledgeRepository knowledgeRepository;

    static Knowledge generateKnowledge(User user, String title, String content) {
        return Knowledge.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();
    }

    @Test
    @DisplayName("user 저장")
    void save() {

        // given
        String email = "dev.hyeonic@gmail.com";
        User user = User.builder()
                .email(email)
                .build();

        // when
        userRepository.save(user);

        List<User> users = userRepository.findAll();

        // then
        assertEquals(1, users.size());
    }

    @Test
    @DisplayName("user가 등록한 knowledge 조회")
    void findUserKnowledges() {

        // given
        String email = "dev.hyeonic@gmail.com";
        User user = User.builder()
                .email(email)
                .build();

        userRepository.save(user);
//        user.getKnowledges().add(generateKnowledge(user, "지식1", "지식1 내용"));
//        user.getKnowledges().add(generateKnowledge(user, "지식2", "지식2 내용"));
        knowledgeRepository.save(generateKnowledge(user, "지식1", "지식1 내용"));
        knowledgeRepository.save(generateKnowledge(user, "지식2", "지식2 내용"));

        // 영속성 컨텍스트를 비워준다.
//        em.flush();
//        em.clear();

        // when
        User findUser = userRepository.findById(user.getId()).get();
        List<Knowledge> knowledges = findUser.getKnowledges();

        // then

        for (Knowledge knowledge : knowledges) {
            System.out.println(knowledge.getUser().getId());
            System.out.println(knowledge.getUser().getEmail());
        }

        assertAll(
                () -> assertEquals(2, knowledges.size()),
                () -> assertEquals(2, knowledgeRepository.findAll().size())
        );
    }
}