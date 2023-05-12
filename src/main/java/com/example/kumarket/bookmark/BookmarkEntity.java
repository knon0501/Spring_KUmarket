package com.example.kumarket.bookmark;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import com.example.kumarket.post.PostEntity;
import com.example.kumarket.user.UserEntity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name="POST_ID")
    private PostEntity post;

    public BookmarkDto toDto(){
        return BookmarkDto.builder()
                .user_id(user.getId())
                .post_id(post.getId())
                .build();
    }

    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public PostEntity getPost() {
        return post;
    }
}
