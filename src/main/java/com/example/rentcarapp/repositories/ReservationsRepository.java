package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.Reservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
}
