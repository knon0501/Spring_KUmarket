package com.example.kumarket.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<UserDto> findAllUser(){
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping("")
    public UserDto createUser(@RequestBody  UserCreateDto userCreateDto){

        return userService.createUser(userCreateDto);
    }

}
