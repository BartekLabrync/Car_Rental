package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.reservations.CreateReservationsRequest;
import com.example.rentcarapp.dto.reservations.ReservationDto;
import com.example.rentcarapp.services.ReservationsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class ReservationController {
    private final ReservationsService reservationsService;

    @GetMapping("addReservation")
    public String getReservations(Model model){
        model.addAttribute("reservations", reservationsService.getAllReservations());
        model.addAttribute("createReservationsRequest", new CreateReservationsRequest());
        return "addReservation";
    }


    @GetMapping("/reservations")
    public String addReservation(Model model){
        model.addAttribute("createReservationsRequest", new CreateReservationsRequest());
        return "reservations";
    }

    @PostMapping("/addReservation")
    public String addReservation(
            CreateReservationsRequest createReservationsRequest,
            Model model) {
        ReservationDto reservationDto = reservationsService.createReservation(createReservationsRequest);

        return "redirect: addReservation";
    }
}
