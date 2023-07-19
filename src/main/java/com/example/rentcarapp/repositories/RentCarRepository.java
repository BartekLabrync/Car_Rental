package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.RentCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentCarRepository extends JpaRepository<RentCar,Long> {
}
