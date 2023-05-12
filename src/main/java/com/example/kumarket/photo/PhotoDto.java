package com.example.kumarket.photo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.kumarket.post.PostEntity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoDto {
    private String url;

    public PhotoEntity toEntity(){
        return PhotoEntity.builder()
                .url(url)
                .build();
    }
}
