package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.MainRental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MainRentalRepository extends JpaRepository<MainRental, Long> {
}
