package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.mainRental.CreateMainRentalRequest;
import com.example.rentcarapp.dto.mainRental.MainRentalDto;
import com.example.rentcarapp.services.MainRentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class MainRentalController {
    private final MainRentalService mainRentalService;

    @GetMapping("/mainRentals")
    public String getMainRentals(Model model){
        model.addAttribute("mainRentals", mainRentalService.getAllMainRentals());
        return "mainRentals";
    }

    @GetMapping("/addMainRental")
    public String addMainRental(Model model){
        model.addAttribute("createMainRental", new CreateMainRentalRequest());
        return "AddMainRental";
    }
    @PostMapping("/addMainRental")
    public String addMainRental(
            CreateMainRentalRequest createMainRentalRequest,
            Model model){
        mainRentalService.createMainRentals(createMainRentalRequest);
        return "redirect:AddMainRental";
    }
}
