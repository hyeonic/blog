package me.hyeonic.jpaassociation.knowledge;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.hyeonic.jpaassociation.locker.Locker;
import me.hyeonic.jpaassociation.tag.Tag;
import me.hyeonic.jpaassociation.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Knowledge {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "knowledge_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 20)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "knowledge")
    private List<Tag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "knowledge")
    private List<Locker> lockers = new ArrayList<>();

    @Builder
    public Knowledge(User user, String title, String content) {
        this.user = user;
        this.user.getKnowledges().add(this);
        this.title = title;
        this.content = content;
    }
}