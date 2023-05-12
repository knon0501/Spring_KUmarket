package com.example.kumarket.photo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import com.example.kumarket.post.PostEntity;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PhotoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String url;
    @ManyToOne
    @JoinColumn(name="POST_ID")
    private PostEntity post;

    public PhotoDto toDto(){
        return PhotoDto.builder()
                .url(url)
                .build();
    }


}
