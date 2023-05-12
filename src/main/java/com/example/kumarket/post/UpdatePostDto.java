package com.example.kumarket.post;

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
public class UpdatePostDto {


    private String category;
    private String title;
    private String thumbnail_url;
    private String description;

    private Long price;

    private String status;
    private List<PhotoDto> photos;

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

    public String getStatus() {
        return status;
    }



}
