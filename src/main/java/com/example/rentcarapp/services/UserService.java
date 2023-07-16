package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.CreateUserDto;
import com.example.rentcarapp.dto.LoginUserDto;


public interface UserService {

    boolean login(LoginUserDto userDto);
    void create(CreateUserDto userDto);

}
