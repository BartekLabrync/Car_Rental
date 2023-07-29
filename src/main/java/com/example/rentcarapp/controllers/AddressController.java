package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.address.AddressDto;
import com.example.rentcarapp.dto.address.CreateAddressRequest;
import com.example.rentcarapp.services.address.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/addAddress")
    public String addAddress(Model model){
        model.addAttribute("createAddressRequest", new CreateAddressRequest());
        return "addAddress";
    }

    @PostMapping("/addAddress")
    public String addAddress(
            CreateAddressRequest createAddressRequest,
            Model model){
        AddressDto addressDto = addressService.create(createAddressRequest);

        return "redirect:addAddress";
    }
}
