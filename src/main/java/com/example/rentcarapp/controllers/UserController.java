package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.user.CreateUserRequest;
import com.example.rentcarapp.dto.user.LoginUserDto;
import com.example.rentcarapp.dto.user.UpdateUserRequest;
import com.example.rentcarapp.dto.user.UserDto;
import com.example.rentcarapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById (@PathVariable long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers () {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser (@RequestBody UpdateUserRequest updateUserRequest, @PathVariable long id) {
        userService.updateUser(updateUserRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser (@RequestBody CreateUserRequest createUserRequest) {
        UserDto userDto = userService.createUser(createUserRequest);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteUser (@PathVariable long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginUserDto loginUserDto) {
        if ("admin".equals(loginUserDto.getLogin()) && "password".equals(loginUserDto.getPassword())) {
            return "Logowanie udane!";
        } else {
            return "Błędny login lub hasło.";
        }

    }
}