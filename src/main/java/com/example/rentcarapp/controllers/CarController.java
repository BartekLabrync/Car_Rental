package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.car.CarDto;
import com.example.rentcarapp.dto.car.CreateCarRequest;
import com.example.rentcarapp.services.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CarController {
    private final CarService carService;


    @GetMapping("cars")
    public String getCars(Model model){
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }

    @GetMapping("/addCar")
    public String addCar(Model model){
        model.addAttribute("createCarRequest", new CreateCarRequest());
        return "AddCar";
    }

    @PostMapping("/addCar")
    public String addCar(
            CreateCarRequest createCarRequest,
            Model model){
        CarDto carDto = carService.createCar(createCarRequest);

        return "redirect:AddCar";
    }
}
