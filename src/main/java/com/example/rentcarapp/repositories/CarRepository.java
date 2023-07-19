package com.example.rentcarapp.repositories;

import com.example.rentcarapp.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
