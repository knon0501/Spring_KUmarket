package com.example.kumarket.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    List<UserDto> findAllUser(){
        List<UserEntity> users=userRepository.findAll();
        List<UserDto> usersDto=new ArrayList<>();
        for(UserEntity user : users)
            usersDto.add(user.toDto("Find Success"));
        return usersDto;
    }
    UserDto findUserById(Long id){
        UserEntity userEntity= userRepository.findById(id).orElseThrow(()->new NoSuchElementException());
        return userEntity.toDto("Find Success");
    }
    UserDto createUser(UserCreateDto userCreateDto){
        String username=userCreateDto.getUsername();
        Optional<UserEntity> findDto=userRepository.findByUsername(username);
        if(findDto.isPresent()){
           UserDto returnDto=UserDto.builder()
                    .message("Duplicate Username")
                    .build();
           return returnDto;
        }
        UserEntity userEntity = userCreateDto.toEntity();
        UserEntity returnEntity = userRepository.save(userEntity);
        return returnEntity.toDto("Create Success");
    }
}
