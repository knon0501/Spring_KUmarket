package com.example.kumarket.bookmark;

import com.example.kumarket.post.PostEntity;
import com.example.kumarket.post.PostRepository;
import com.example.kumarket.user.UserEntity;
import com.example.kumarket.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookmarkService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkService(UserRepository userRepository, PostRepository postRepository, BookmarkRepository bookmarkRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.bookmarkRepository = bookmarkRepository;
    }

    public List<BookmarkDto> findAllBookmarks(){
        List<BookmarkEntity> bookmarks = bookmarkRepository.findAll();
        List<BookmarkDto> bookmarksDto = new ArrayList<>();
        for(BookmarkEntity bookmark: bookmarks)
            bookmarksDto.add(bookmark.toDto());
        return bookmarksDto;
    }

    public BookmarkDto createBookmark(CreateBookmarkDto bookmarkDto){
        Long user_id=bookmarkDto.getUser_id();
        Long post_id=bookmarkDto.getPost_id();
        UserEntity userEntity= userRepository.findById(user_id).orElseThrow(()->new NoSuchElementException());
        PostEntity postEntity = postRepository.findById(post_id).orElseThrow(()->new NoSuchElementException());


        BookmarkEntity bookmarkEntity=BookmarkEntity.builder()
                .user(userEntity)
                .post(postEntity)
                .build();
        BookmarkEntity returnEntity=bookmarkRepository.save(bookmarkEntity);
        return returnEntity.toDto();
    }
}
