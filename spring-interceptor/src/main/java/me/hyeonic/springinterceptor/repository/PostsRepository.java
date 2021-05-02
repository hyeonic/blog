package me.hyeonic.springinterceptor.repository;

import me.hyeonic.springinterceptor.domain.Posts;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PostsRepository {

    private static Map<Long, Posts> postsMap = new HashMap<>();
    private static Long count = 1L;

    public Long save(Posts posts) {
        posts.setId(count);
        postsMap.put(posts.getId(), posts);
        count++;

        return posts.getId();
    }

    public Posts findById(Long id) {
        return postsMap.get(id);
    }

    public List<Posts> findAll() {
        return new ArrayList<>(postsMap.values());
    }
}