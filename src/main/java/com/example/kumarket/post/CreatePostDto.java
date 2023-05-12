package com.example.kumarket.post;

import com.example.kumarket.bookmark.BookmarkEntity;
import com.example.kumarket.photo.PhotoDto;
import com.example.kumarket.photo.PhotoEntity;
import com.example.kumarket.user.UserDto;
import com.example.kumarket.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.kumarket.user.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreatePostDto {


    private Long user_id;
    private String category;
    private String title;
    private String thumbnail_url;
    private String description;
    private Long price;
    private List<PhotoDto> photos;

    public Long getUser_id() {
        return user_id;
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }

    public PostEntity toEntity(UserEntity user){
        List<PhotoEntity> photoEntities=new ArrayList<>();
        List<BookmarkEntity> bookmarks = new ArrayList<>();
        for(PhotoDto photoDto: photos){
            photoEntities.add(photoDto.toEntity());
        }
        return PostEntity.builder()
                .user(user)
                .category(category)
                .title(title)
                .thumbnail_url(thumbnail_url)
                .description(description)
                .photos(photoEntities)
                .price(price)
                .view_count(0L)
                .status("Sale")
                .bookmarks(bookmarks)
                .build();
    }
}
