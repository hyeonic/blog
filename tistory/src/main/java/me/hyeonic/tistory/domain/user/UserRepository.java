package me.hyeonic.tistory.domain.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {

    private static final UserRepository userRepository = new UserRepository();
    private static final Map<Long, User> userMap = new HashMap<>();
    private static long count;
    
    private UserRepository() {}

    public static UserRepository getInstance() {
        return userRepository;
    }
    
    public Long save(String email, String password, String name) {
        User savedUser = new User(count, email, password, name);
        userMap.put(count, savedUser);
        count++;

        return savedUser.getId();
    }

    public Long save(User user) {
        User savedUser = new User(count, user.getEmail(), user.getPassword(), user.getName());
        userMap.put(count, savedUser);
        count++;

        return savedUser.getId();
    }

    public User findById(Long id) {
        return userMap.get(id);
    }

    public List<User> findAll() {
        return new ArrayList<>(new ArrayList<>(userMap.values()));
    }
}