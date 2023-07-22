package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.MainRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRentalRepository extends JpaRepository<MainRental, Long> {
}
