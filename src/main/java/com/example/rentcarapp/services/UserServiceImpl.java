package com.example.rentcarapp.services;

import com.example.rentcarapp.dto.user.CreateUserDto;
import com.example.rentcarapp.dto.user.LoginUserDto;
import com.example.rentcarapp.models.User;
import com.example.rentcarapp.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    @Override
    public boolean login(LoginUserDto dto){
        User user = userRepository.getUserByLoginOrEmail(dto.getLogin(), dto.getEmail());
        if(user == null){
            return false;
        }
        return user.getPassword().equals(dto.getPassword());
    }

    @Override
    public void create(CreateUserDto dto) {
        var model = toModel(dto);
        userRepository.save(model);
    }

    private User toModel(CreateUserDto dto){
        return User.builder()
                .email(dto.getEmail())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .login(dto.getLogin())
                .build();
    }
}
