package com.example.rentcarapp.services;

import com.example.rentcarapp.models.Branch;
import com.example.rentcarapp.models.RentCar;
import com.example.rentcarapp.models.Reservations;
import com.example.rentcarapp.models.User;
import com.example.rentcarapp.repositories.BranchRepository;
import com.example.rentcarapp.repositories.RentCarRepository;
import com.example.rentcarapp.repositories.ReservationsRepository;
import com.example.rentcarapp.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Console;
import java.math.BigDecimal;
import java.time.LocalDate;

@Component
@AllArgsConstructor
public class DataInit {

    private final ReservationsRepository reservationsRepository;
    private final UserRepository userRepository;
    private final RentCarRepository rentCarRepository;
    private final BranchRepository branchRepository;

    @PostConstruct
    public void init () {
        Reservations reservation = Reservations.builder()
                .amount(BigDecimal.valueOf(199))
                .reservDate(LocalDate.now())
                .dateFor(LocalDate.now())
                .dateTo(LocalDate.now())
                .build();
        reservationsRepository.save(reservation);
    }


}
