package com.example.rentcarapp.controllers;


import com.example.rentcarapp.dto.rentCar.CreateRentCarRequest;
import com.example.rentcarapp.dto.returnCar.CreateReturnCarRequest;
import com.example.rentcarapp.dto.returnCar.ReturnCarDto;
import com.example.rentcarapp.services.returnCar.ReturnCarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ReturnCarController {
    private final ReturnCarService returnCarService;

    @GetMapping("/addReturnCar")
    public String addReturnCar(Model model){
        model.addAttribute("creteReturnCarRequest", new CreateReturnCarRequest());
        return "addReturnCar";
    }

    @PostMapping("/addReturnCar")
    public String addReturnCar(
            CreateReturnCarRequest createReturnCarRequest,
            Model model){
        ReturnCarDto returnCarDto = returnCarService.create(createReturnCarRequest);

        return "redirect:addReturnCar";
    }
}
