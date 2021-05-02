package me.hyeonic.springinterceptor.repository;

import me.hyeonic.springinterceptor.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private static Map<Long, User> userMap = new HashMap<>();
    private static long count = 1L;

    private UserRepository() {}

    public Long save(User user) {
        user.setId(count);
        userMap.put(count, user);
        count++;

        return user.getId();
    }

    public User findById(Long id) {
        return userMap.get(id);
    }

    public Boolean isUser(String email, String password) {
        return userMap.values().stream()
                .anyMatch((user) -> user.getEmail().equals(email) && user.getPassword().equals(password));
    }

    public User findByEmail(String email) {
        for (User user : userMap.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
    }
}