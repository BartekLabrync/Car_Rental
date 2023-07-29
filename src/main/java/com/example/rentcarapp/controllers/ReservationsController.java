package com.example.rentcarapp.controllers;

import com.example.rentcarapp.dto.reservations.CreateReservationsRequest;
import com.example.rentcarapp.dto.reservations.ReservationDto;
import com.example.rentcarapp.dto.reservations.UpdateReservationsRequest;
import com.example.rentcarapp.services.ReservationsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Slf4j
@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationsController {

    private final ReservationsService reservationsService;

    @GetMapping("{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable long id) {

        ReservationDto reservationById = reservationsService.getReservationsById(id);
        return ResponseEntity.ok(reservationById);

    }

    @GetMapping("/all")
    public ResponseEntity<List<ReservationDto>> getAllReservations() {

        List<ReservationDto> reservations = reservationsService.getAllReservations();
        return ResponseEntity.ok(reservations);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ReservationDto> updateReservation(@PathVariable long id, @RequestBody UpdateReservationsRequest updateReservationsRequest) {
        reservationsService.updateReservation(id, updateReservationsRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/create-Reservation")
    public ResponseEntity<ReservationDto> createReservation (@RequestBody CreateReservationsRequest createReservationsRequest) {
        ReservationDto reservationDto = reservationsService.createReservation(createReservationsRequest);
        return ResponseEntity.ok(reservationDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteReservation (@PathVariable long id) {
        reservationsService.deleteReservation(id);
        return ResponseEntity.ok().build();
    }

}
