package com.example.kumarket.user;

import com.example.kumarket.bookmark.BookmarkDto;
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
public class UserDto {
    private Long id;
    private String username;
    private String phone_no;


    private List<Long> posts;
    private List<Long> bookmarks;
    private String message;

}
