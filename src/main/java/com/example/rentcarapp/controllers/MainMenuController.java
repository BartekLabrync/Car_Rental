package com.example.rentcarapp.controllers;

import com.example.rentcarapp.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainMenuController {
    private final CarService carService;

    @GetMapping("mainMenu")
    public String getMenu(Model model){
        return "Main-Menu-View";
    }

    @GetMapping("/carsToRent")
    public String getCarsToRent(Model model){

        model.addAttribute("cars", carService.getAllCars());

        return "carsMenu";
    }
}
