package com.example.kumarket.post;

import com.example.kumarket.photo.PhotoDto;
import com.example.kumarket.photo.PhotoEntity;
import com.example.kumarket.user.UserDto;
import com.example.kumarket.user.UserEntity;
import com.example.kumarket.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository){
        this.postRepository=postRepository;
        this.userRepository = userRepository;
    }
    public List<PostDto> findAllPosts(){

        List<PostEntity> posts = postRepository.findAll();
        List<PostDto> postsDto = new ArrayList<>();
        for(PostEntity post: posts)
            postsDto.add(post.toDto("Find Success"));
        return postsDto;
    }

    public PostDto findPost(Long id){
        PostEntity postEntity=postRepository.findById(id).orElseThrow(()->new NoSuchElementException());
        postEntity.increment_view_count();
        postRepository.save(postEntity);
        PostDto postDto=postEntity.toDto("Find Success");


        return postDto;
    }

    public PostDto createPost(CreatePostDto postDto){
        Long user_id = postDto.getUser_id();


        Optional<UserEntity> userOptional= userRepository.findById(user_id);
        if(userOptional.isPresent()){
            UserEntity userEntity=userOptional.get();

            PostEntity postEntity=postDto.toEntity(userEntity);
            PostEntity returnEntity=postRepository.save(postEntity);
            return returnEntity.toDto("Create Success");
        }
        else{
            PostDto returnDto= PostDto.builder()
                    .message("No such user")
                    .build();
            return returnDto;
        }

    }

    public PostDto deletePost(Long id){
        findPost(id);
        postRepository.deleteById(id);
        return PostDto.builder()
                .message("Delete Success")
                .build();
    }
    public PostDto updatePost(Long id,UpdatePostDto updatePostDto){

        PostEntity postEntity = postRepository.findById(id).orElseThrow(()->new NoSuchElementException());
        List<PhotoEntity> photoEntities=new ArrayList<>();
        List<PhotoDto> photos=updatePostDto.getPhotos();
        for(PhotoDto photoDto: photos){
            photoEntities.add(photoDto.toEntity());
        }

        postEntity.setCategory(updatePostDto.getCategory());
        postEntity.setDescription(updatePostDto.getDescription());
        postEntity.setPhotos(photoEntities);
        postEntity.setThumbnail_url(updatePostDto.getThumbnail_url());
        postEntity.setPrice(updatePostDto.getPrice());
        postEntity.setStatus(updatePostDto.getStatus());

        postRepository.save(postEntity);
        PostDto returnDto= postEntity.toDto("update success");
        return returnDto;
    }
}
