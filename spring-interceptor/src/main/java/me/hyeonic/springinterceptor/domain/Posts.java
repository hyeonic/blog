package me.hyeonic.springinterceptor.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Posts {

    private Long id;
    private String title;
    private String content;
    private User user;

    public Posts(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}