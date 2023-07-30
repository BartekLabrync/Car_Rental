package com.example.rentcarapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainMenuController {

    @GetMapping("mainMenu")
    public String getMenu(Model model){
        return "Main-Menu-View";
    }
}
