package com.example.rentcarapp.repository;

import com.example.rentcarapp.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
