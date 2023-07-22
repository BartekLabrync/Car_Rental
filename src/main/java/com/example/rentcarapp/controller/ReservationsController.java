package com.example.rentcarapp.controller;

import com.example.rentcarapp.dto.reservations.ReservationDto;
import com.example.rentcarapp.services.ReservationsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Slf4j
@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationsController {

    private final ReservationsService reservationsService;

    @GetMapping("{id}")
    public ResponseEntity<ReservationDto> getReservation (@PathVariable long id) {
        ReservationDto reservationById = reservationsService.getReservationsById(id);
        return ResponseEntity.ok(reservationById);

    }

    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservations () {
        List<ReservationDto> reservations = reservationsService.getAllReservations();
        return ResponseEntity.ok(reservations);

    }



}
