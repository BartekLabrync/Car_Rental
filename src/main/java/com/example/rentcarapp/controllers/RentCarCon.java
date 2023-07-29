package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.rentCar.CreateRentCarRequest;
import com.example.rentcarapp.dto.rentCar.RentCarDto;
import com.example.rentcarapp.services.RentCarService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class RentCarCon {
    private final RentCarService rentCarService;
    @GetMapping("/addRentCar")
    public String addRentCar(Model model){
        model.addAttribute("createRentCarRequest", new CreateRentCarRequest());
        return "addRentCar";
    }

    @PostMapping("/addRentCar")
    public String addRentCar(
            CreateRentCarRequest createRentCarRequest,
            Model model){
        RentCarDto rentCarDto = rentCarService.create(createRentCarRequest);

        return "redirect:addRentCar";
    }
}