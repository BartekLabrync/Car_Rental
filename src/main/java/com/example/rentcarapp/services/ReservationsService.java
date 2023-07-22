package com.example.rentcarapp.services;

import com.example.rentcarapp.models.Reservations;
import com.example.rentcarapp.repositories.ReservationsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ReservationsService {

    private final ReservationsRepository reservationsRepository;

    public List<Reservations> getAllReservations() {
        return reservationsRepository.findAll();
    }

    public Optional<Reservations> getReservationsById(Long id) {
        return reservationsRepository.findById(id);
    }
}
