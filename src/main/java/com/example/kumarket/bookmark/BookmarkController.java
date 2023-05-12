package com.example.kumarket.bookmark;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController {
    private final BookmarkService bookmarkService;

    public BookmarkController(BookmarkService bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    @GetMapping("")
    public List<BookmarkDto> findAllBookmarks(){
        return bookmarkService.findAllBookmarks();
    }

    @PostMapping("")
    public BookmarkDto createBookmark(@RequestBody  CreateBookmarkDto bookmarkDto){
        return bookmarkService.createBookmark(bookmarkDto);
    }
}
