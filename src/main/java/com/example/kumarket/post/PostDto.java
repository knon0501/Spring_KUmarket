package com.example.kumarket.post;

import com.example.kumarket.bookmark.BookmarkDto;
import com.example.kumarket.bookmark.BookmarkEntity;
import com.example.kumarket.photo.PhotoDto;
import com.example.kumarket.photo.PhotoEntity;
import com.example.kumarket.user.UserDto;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.kumarket.user.UserEntity;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private UserDto user;
    private String category;
    private String title;
    private String thumbnail_url;
    private String description;
    private Long price;
    private Long view_count;
    private String status;
    private String message;

    private List<BookmarkDto> bookmarks;
    private List<PhotoDto> photos;
    public String getMessage() {
        return message;
    }

    public UserDto getUser() {
        return user;
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

    public Long getView_count() {
        return view_count;
    }

    public String getStatus() {
        return status;
    }



}
