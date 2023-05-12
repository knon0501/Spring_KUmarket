package com.example.kumarket.post;

import com.example.kumarket.bookmark.BookmarkDto;
import com.example.kumarket.bookmark.BookmarkEntity;
import com.example.kumarket.photo.PhotoDto;
import com.example.kumarket.user.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import com.example.kumarket.photo.PhotoEntity;
import com.example.kumarket.user.UserEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private UserEntity user;
    private String category;
    private String title;
    private String thumbnail_url;
    private String description;
    private Long price;
    private Long view_count;
    private String status;

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PhotoEntity> photos= new ArrayList<>();

    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BookmarkEntity> bookmarks = new ArrayList<>();
    public void setId(Long id) {
        this.id = id;
    }

    public Long increment_view_count(){
        view_count++;
        return view_count;
    }
    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
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

    public List<BookmarkEntity> getBookmarks() {
        return bookmarks;
    }

    public List<PhotoEntity> getPhotos() {
        return photos;
    }




    public void setBookmarks(List<BookmarkEntity> bookmarks) {
        this.bookmarks = bookmarks;
    }

    public void setView_count(Long view_count) {
        this.view_count = view_count;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPhotos(List<PhotoEntity> photos) {
        this.photos = photos;
    }

    public PostDto toDto(String message){
        List<PhotoDto> photoDtos =new ArrayList<>();
        for(PhotoEntity photoEntity: photos)
            photoDtos.add(photoEntity.toDto());
        List<BookmarkDto> bookmarkDtos=new ArrayList<>();

        for(BookmarkEntity bookmarkEntity: bookmarks){
            bookmarkDtos.add(bookmarkEntity.toDto());
        }
        for(PhotoEntity photoEntity: photos)
            photoDtos.add(photoEntity.toDto());
        return PostDto.builder()
                .user(user.toDto(""))
                .category(category)
                .title(title)
                .thumbnail_url(thumbnail_url)
                .description(description)
                .price(price)
                .view_count(view_count)
                .status(status)
                .message(message)
                .photos(photoDtos)
                .bookmarks(bookmarkDtos)
                .build();
    }
}
