package com.example.rentcarapp.services.user;

import com.example.rentcarapp.dto.user.CreateUserDto;
import com.example.rentcarapp.dto.user.LoginUserDto;


public interface UserService {

    boolean login(LoginUserDto userDto);
    void create(CreateUserDto userDto);

}
