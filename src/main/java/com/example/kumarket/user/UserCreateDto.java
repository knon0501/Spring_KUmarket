package com.example.kumarket.user;

import com.example.kumarket.bookmark.BookmarkEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.kumarket.post.PostEntity;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private String username;

    private String password;
    private String phone_no;



    private List<PostEntity> posts;
    private List<BookmarkEntity> bookmarks;

    public UserEntity toEntity(){
        return UserEntity.builder()
                .username(username)
                .phone_no(phone_no)
                .posts(posts)
                .bookmarks(bookmarks)
                .password(password)
                .build();
    }
}
