package com.example.kumarket.bookmark;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.kumarket.post.PostEntity;
import com.example.kumarket.user.UserEntity;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkDto {
    private Long user_id;
    private Long post_id;


}
