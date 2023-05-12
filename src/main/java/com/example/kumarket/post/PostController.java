package com.example.kumarket.post;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<PostDto> findAllPosts(){

        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostDto findPost(@PathVariable("id")Long id){
        return postService.findPost(id);
    }
    @PostMapping("")
    public PostDto createPost(@RequestBody CreatePostDto createPostDto){
        return postService.createPost(createPostDto);
    }

    @DeleteMapping("/{id}")
    public PostDto deletePost(@PathVariable("id") Long id){
        return postService.deletePost(id);
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable("id") Long id,@RequestBody UpdatePostDto updatePostDto){
        return postService.updatePost(id,updatePostDto);
    }
}
