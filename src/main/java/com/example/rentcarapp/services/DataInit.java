package com.example.rentcarapp.services;

import com.example.rentcarapp.models.Reservations;
import com.example.rentcarapp.repositories.ReservationsRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@AllArgsConstructor
public class DataInit {

    private final ReservationsRepository reservationsRepository;

    @PostConstruct

    public void init () {
        Reservations reservation = Reservations.builder()
                .amount(BigDecimal.valueOf(123))
                .build();

        reservationsRepository.save(reservation);
    }


}
