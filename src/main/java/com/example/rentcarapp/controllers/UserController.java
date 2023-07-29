package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.address.CreateAddressRequest;
import com.example.rentcarapp.dto.user.CreateUserDto;
import com.example.rentcarapp.dto.user.CreateUserRequest;
import com.example.rentcarapp.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("users")
    public String getUsers(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        model.addAttribute("createUserRequest", new CreateUserRequest());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(
            CreateUserRequest createUserRequest,
            Model model){
        userService.createUser(createUserRequest);

        return "redirect:addUser";
    }
}
