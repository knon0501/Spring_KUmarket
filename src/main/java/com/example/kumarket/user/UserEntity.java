package com.example.kumarket.user;

import com.example.kumarket.bookmark.BookmarkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import com.example.kumarket.post.PostEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String phone_no;

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public List<BookmarkEntity> getBookmarks() {
        return bookmarks;
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<PostEntity> posts = new ArrayList<>();
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<BookmarkEntity> bookmarks= new ArrayList<>();

    public UserDto toDto(String message){
        List<Long> post_ids=new ArrayList<>();
        for(PostEntity postEntity: posts)
        {
            post_ids.add(postEntity.getId());
        }
        List<Long> bookmark_ids=new ArrayList<>();
        for(BookmarkEntity bookmarkEntity: bookmarks)
        {
            bookmark_ids.add(bookmarkEntity.getPost().getId());
        }
        return UserDto.builder()
                .id(id)
                .username(username)
                .phone_no(phone_no)
                .posts(post_ids)
                .bookmarks(bookmark_ids)
                .message(message)
                .build();

    }
}
